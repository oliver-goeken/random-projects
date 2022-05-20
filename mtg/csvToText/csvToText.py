import csv
import sys
import os
from colorama import init

#allow ANSI escape sequences to work
init()

location = ""

#set location to first argument if there are arguments
if len(sys.argv) > 1:
    location = sys.argv[1]

while not os.path.exists(location):
    os.system('cls||clear')

    error = ""

    if not location == "":
        error = "\"" + location + "\" does not exist"

    location = input("Please input a file location: \n" + error + "\033[1;31H")

try:
    with open(location) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        line_count = 0
except PermissionError:
    print("This program does not have access to that file")

print()