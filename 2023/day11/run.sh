#!/bin/sh
javac part1.java
javac part2.java
java part1 input.txt
java part2 input.txt
rm part1.class Node.class part2.class 
