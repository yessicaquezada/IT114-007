package M4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Server {
    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();
    private int numberToGuess = -1; // 7.1 solution
    private int answer = Integer.MIN_VALUE; // 7.4 solution

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);

                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;

                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }

    protected synchronized void disconnect(ServerThread client) {
        long id = client.getId();
        client.disconnect();
        broadcast("Disconnected", id);
    }

    protected synchronized void broadcast(String message, long id) {
        if (processCommand(message, id)) {

            return;
        }
        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect
        message = String.format("User[%d]: %s", id, message);
        // end temp identifier

        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(message);
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                it.remove();
                broadcast("Disconnected", id);
            }
        }
    }

    // added helper method for multiple solutions
    private void sendToOne(String message, long to) {
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            if (client.getId() == to) {
                client.send(message);

                break;
            }
        }
    }

    // 7.5 solution
    protected synchronized void sendPrivateMessage(String message, long from, long to) {

        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect
        message = String.format("User[%d]: %s", from, message);
        // end temp identifier

        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            // check to and from so both parties get the message
            if (client.getId() == from || client.getId() == to) {
                boolean wasSuccessful = client.send(message);
                if (!wasSuccessful) {
                    System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                    it.remove();
                    broadcast("Disconnected", to);
                }
            }
        }
    }

    private boolean processCommand(String message, long clientId) {
        System.out.println("Checking command: " + message);
        if (message.equalsIgnoreCase("disconnect")) {
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if (client.getId() == clientId) {
                    it.remove();
                    disconnect(client);

                    break;
                }
            }
            return true;
        }
        // 7.1 number guesser
        else if (message.equalsIgnoreCase("start guesser")) {
            if (numberToGuess > -1) {
                sendToOne("Game already in progress", clientId);
            } else {
                numberToGuess = new Random().nextInt(10) + 1;
                broadcast("A number has been picked between 1-10, try to guess it", clientId);
            }
            return true;
        } else if (message.equalsIgnoreCase("stop guesser")) {
            numberToGuess = -1;
            broadcast("Stopped the number guesser game", clientId);
            return true;
        } else if (message.startsWith("guess")) {
            if (numberToGuess < 0) {
                return false;
            }
            String[] parts = message.split(" ");
            if (parts.length > 1) {
                int guess = -1;
                try {
                    guess = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    broadcast(parts[1] + " is not a valid guess", clientId);
                }
                if (guess > -1) {
                    boolean isCorrect = guess == numberToGuess;
                    broadcast("Guessed " + guess + " and it was " + (isCorrect ? "correct" : "incorrect"), clientId);
                    if (isCorrect) {
                        numberToGuess = new Random().nextInt(10) + 1;
                        broadcast("A number has been picked between 1-10, try to guess it", clientId);
                    }
                }
            }
            return true;
        }
        // end 7.1
        // 7.2 coin toss command
        else if (message.equalsIgnoreCase("flip")) {
            broadcast("Flipped a coin and got " + (Math.random() > .5 ? "heads" : "tails"), clientId);
            return true;
        }
        // end 7.2
        // 7.3 dice roller with special multi-dice format
        else if (message.startsWith("roll")) {
            String[] parts = message.split(" ");
            if (parts.length > 1) {
                String[] dice = parts[1].split("d");
                int numOfDice = 0;
                int maxValue = 0;
                try {
                    numOfDice = Integer.parseInt(dice[0]);
                } catch (NumberFormatException e) {
                }
                try {
                    maxValue = Integer.parseInt(dice[1]);
                } catch (NumberFormatException e) {
                }
                int total = 0;
                for (int i = 0; i < numOfDice; i++) {
                    total += new Random().nextInt(maxValue) + 1;
                }
                broadcast("Rolled a " + parts[1] + " and got " + total, clientId);
                return true;
            }
        }
        // end 7.3
        // 7.4 math game
        else if (message.equalsIgnoreCase("start math")) {
            if (answer > Integer.MIN_VALUE) {
                sendToOne("Math game already in progress", clientId);
            } else {
                int a = new Random().nextInt(20) + 1;
                int b = new Random().nextInt(20) + 1;
                b *= Math.random() > 0.5 ? 1 : -1;
                answer = a + b;
                broadcast("What is the answer for " + a + " + " + b + "?", clientId);
            }
            return true;
        } else if (message.equalsIgnoreCase("stop math")) {
            answer = Integer.MIN_VALUE;
            broadcast("Stopped the math game", clientId);
            return true;
        } else if (message.startsWith("answer")) {
            if (answer == Integer.MIN_VALUE) {
                return false;
            }
            String[] parts = message.split(" ");
            if (parts.length > 1) {
                int ans = Integer.MIN_VALUE;
                try {
                    ans = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                }
                if (ans > Integer.MIN_VALUE) {
                    boolean isCorrect = ans == answer;
                    broadcast("Answered " + ans + " and it was " + (isCorrect ? "correct" : "incorrect"), clientId);
                    if (isCorrect) {
                        int a = new Random().nextInt(20) + 1;
                        int b = new Random().nextInt(20) + 1;
                        b *= Math.random() > 0.5 ? 1 : -1;
                        answer = a + b;
                        broadcast("What is the answer for " + a + " + " + b + "?", clientId);
                    }
                }
            }
            return true;
        }
        // end 7.4
        // 7.5 send private message
        else if (message.startsWith("@")) {
            String[] parts = message.split("@");
            if (parts.length > 1) {
                String[] nameAndMessage = parts[1].split(" ");
                long to = -1;
                try {
                    to = Long.parseLong(nameAndMessage[0]);
                } catch (NumberFormatException e) {
                }
                if (to > -1) {
                    sendPrivateMessage(message, clientId, to);
                    return true;
                }
            }
        }
        // end 7.5
        // 7.6 message shuffler
        else if (message.startsWith("shuffle")) {
            String[] parts = message.split("shuffle");
            if (parts.length > 1) {
                String msg = parts[1];
                String[] letters = msg.split("");
                for (int i = 0; i < letters.length; i++) {
                    String t = letters[i];
                    int newIndex = (int) Math.floor(Math.random() * letters.length);
                    letters[i] = letters[newIndex];
                    letters[newIndex] = t;
                }
                broadcast(String.join("", letters), clientId);
                return true;
            }
        }
        // end 7.6
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
}
