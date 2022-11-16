<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Yessica Quezada (ysq2)</td></tr>
<tr><td> <em>Generated: </em> 10/25/2022 11:56:05 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-milestone1/grade/ysq2" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project</li><li>Create a milestone1.md file inside the project folder</li><li>Git add/commit/push it to Github</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example of the lessons</li><ol><li>Recommended Part 5, but Part 4 should be sufficient</li><li><a href="https://github.com/MattToegel/IT114/tree/Module5/Module5">https://github.com/MattToegel/IT114/tree/Module5/Module5</a>&nbsp;<br></li></ol><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/78096228/197928760-1643e0a8-57ec-4c4e-9041-bfe1f881fc83.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot showing the server port<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/78096228/197928858-224b4e28-acb8-4c20-a9d7-38fff5b5810f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot of client waiting for input and successfully connected under the localhost (server)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <p>The server-side and client-side both depend on each other. If the client isn&#39;t<br>connected in the host that the server is in, then the client will<br>not be able to receive or send any message to other clients that<br>are connected to the server. Server-side is needed in order for client-side to<br>work.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/78096228/197929530-36faac95-d417-48e9-96f1-f4e895d4afeb.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot of two clients connected under the server<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/78096228/197929619-ab744fc3-2d49-4c9f-b1c8-1b4863834585.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot of two clients sending a message to each other<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/78096228/197929735-c1d27017-f659-42d7-ab32-fb79fa413774.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>In this screenshot it shows that Yessica is in room Test and Ashley<br>is in room Test1. They both sent a message but they didn&#39;t receive<br>it since they&#39;re not in the same room.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted, and received</td></tr>
<tr><td> <em>Response:</em> <p>As client 1 (Yessica) send her message in the local host, client 2<br>(Ashley) can receive and send her a message from the server thread. But,<br>once they&#39;re in separate rooms, they can&#39;t communicate with each other since the<br>room names are different. On each client side, you can see the message<br>that is sent along with the message that is received if they&#39;re under<br>the local host.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist on the right</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/78096228/197930095-1dd3bbaf-1de9-42bc-9092-3fa59d3b22b6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Here&#39;s a screenshot of one client disconnecting from the server. <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/78096228/197930200-d5e6a15f-ca25-4dbe-8a1f-79282e8b978e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Here&#39;s a screenshot of both clients disconnecting from the server <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <p>A client gets disconnected from a Socket if it was manually disconnected. Depending<br>on the &quot;triggers&quot; that the client inputs, it can either disconnect them or<br>keep them in the server. The client&#39;s program doesn&#39;t crash because it&#39;s basically<br>just leaving the server. If the code was tampered with causing the client<br>not to leave, that would be a different scenario. Server isn&#39;t crashing either<br>because the clients are just leaving, but as long as it&#39;s running, they<br>can rejoin the local host.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/yessicaquezada/IT114-007/pull/4">https://github.com/yessicaquezada/IT114-007/pull/4</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-milestone1/grade/ysq2" target="_blank">Grading</a></td></tr></table>
