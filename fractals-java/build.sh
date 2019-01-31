#!/bin/bash
PROJECT_PATH=$(dirname $(realpath $0))

sources=""
for file in $PROJECT_PATH/src/*; do
	echo "Found source file: $file"
	sources="$sources $file"
done
	
echo -e "...\nCompiling with command: javac $sources -d $PROJECT_PATH/bin/\n...\n..."
javac $sources -d $PROJECT_PATH/bin/
