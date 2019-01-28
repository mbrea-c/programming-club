#!/bin/bash
PROJECT_PATH=$(dirname $(realpath $0))

sources=""
for file in $PROJECT_PATH/src/*; do
	sources="$sources $file"
done
	
javac $sources -d $PROJECT_PATH/bin/
