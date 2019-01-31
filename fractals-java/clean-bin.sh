#!/bin/bash
PROJECT_PATH=$(dirname $(realpath $0))

for file in $PROJECT_PATH/bin/*; do
	echo "Deleting file: $file"
	rm $file
done

echo "Creating empty file to allow git to detect the directory"
touch "$PROJECT_PATH/bin/emptyfile"
	
