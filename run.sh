#!/bin/bash
# if you need permission use chmod +x run.sh to make it executable
pwd = $PWD
# argument 1 should be folder or path to folder to run
# argument 2 should be client/server
# argument 3 would be a port, default is 3000 (only used with server)
# NOTE: this expects you're following my directory structure
if [ "$2" ]
then
    if [ "$2" == "client" ]; then
        target="$1.client.ClientUI"
    elif [ "$2" == "server" ]; then
        p=$3
        port="${p:-default}"
        target="$1.server.Server $port"
    fi
    if [ "$target" ]; then
        echo "Running $target"
        java $target
        echo "Exiting $target"
    fi
else
    echo "Missing argument of folder/path"
fi