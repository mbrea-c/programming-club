#!/bin/bash
PROJECT_PATH=$(dirname $(realpath $0))

sources=""
for file in $PROJECT_PATH/src/*; do
	echo "Found source file: $file"
	sources="$sources $file"
done
	
echo "Compiling with command: javac $sources -d $PROJECT_PATH/bin/"
javac $sources -d $PROJECT_PATH/bin/
