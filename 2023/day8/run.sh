#!/bin/sh
#javac part1.java
javac Node.java
javac part2.java
#start_time=$(date "+%Y-%m-%d %H:%M:%S.%3N")
#echo "Start Time: $start_time"
#java part1 input.txt
start_time=$(date "+%Y-%m-%d %H:%M:%S.%3N")
echo "Start Time: $start_time"
java part2 input.txt
finish_time=$(date "+%Y-%m-%d %H:%M:%S.%3N")
echo "Finish Time: $finish_time"
rm Node.class part2.class #part1.class
