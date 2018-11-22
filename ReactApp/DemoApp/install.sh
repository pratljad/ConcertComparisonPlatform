#!/bin/bash
echo $1

while read STRING
do
    IFS=';' read -r -a array <<< "$STRING"
    echo "Installing npm package: ${array[0]}"
    echo "Version: ${array[1]}"
    npm install ${array[0]}@${array[1]} --save
done
