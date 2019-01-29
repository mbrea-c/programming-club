#!/bin/bash
PROJECT_PATH=$(dirname $(realpath $0))

for file in $PROJECT_PATH/bin/*; do
	echo "Deleting file: $file"
	rm $file
done

touch "$PROJECT_PATH/bin/emptyfile"
	
