#!/bin/bash
# if you need permission use chmod +x run.sh to make it executable
pwd = $PWD
# argument should be folder or path to folder to compile
if [ "$1" ]
then
    echo "Changing Directory to $1"
    cd $1 
    echo "Finding .java files..."
    find . -name "*.java" > sources.txt
    echo "Compiling acquired files..."
    javac @sources.txt
    echo "Done compiling moving back to pwd"
    cd $pwd
else
    echo "Missing argument of folder/path"
fi