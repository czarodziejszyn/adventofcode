#!/bin/sh
javac part1.java
#javac part2.java
#start_time=$(date "+%Y-%m-%d %H:%M:%S.%3N")
#echo "Start Time: $start_time"
java part1 input.txt
#java part2 input.txt
#finish_time=$(date "+%Y-%m-%d %H:%M:%S.%3N")
#echo "Finish Time: $finish_time"
rm part1.class #part2.class
