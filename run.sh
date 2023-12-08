#!/bin/sh
start_time=$(date "+%Y-%m-%d %H:%M:%S.%3N")
echo "Start Time: $start_time"
go run 2023-6-1.go < input.txt
end_time=$(date "+%Y-%m-%d %H:%M:%S.%3N")
echo "End Time: $end_time"
