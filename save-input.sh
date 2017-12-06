#!/usr/bin/env bash

#set -x

if [ -z "$1" ]; then
  echo "Usage: $0 <day>"
  echo "Example: $0 5"
  exit 1
fi

COOKIE=`cat ~/.aoc-cookie`

if [ -z "$COOKIE" ]; then
  echo "Please save your Advent of Code session cookie to ~/.aoc-cookie"
  exit 1
fi

OUTPUT_FILE=`printf "day%02d.txt" $1`

curl --cookie "$COOKIE" http://adventofcode.com/2017/day/$1/input > src/test/resources/$OUTPUT_FILE
