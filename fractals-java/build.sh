#!/bin/bash
PROJECT_PATH=$(dirname $(realpath $0))


javac $PROJECT_PATH/src/Fractals.java -d $PROJECT_PATH/bin/
