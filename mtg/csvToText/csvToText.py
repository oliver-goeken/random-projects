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

#loop until an existing file is found
while not os.path.exists(location):
    os.system('cls||clear')

    #sets an error message if the file does not exist, otherwise leaves error blank
    error = ""
    if not location == "":
        error = "\"" + location + "\" does not exist"

    #utilizes carriage return to add the error message after an input on a cleared terminal
    location = input("Please input a file location: \n" + error + "\033[1;31H").strip("\"")

output = ""

try:
    with open(location) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        line_count = 0

        #adds each row's first and second column together as one string and adds to output
        for row in csv_reader:
            if not line_count == 0:
                output += row[0] + " " + row[1] + "\n"
            line_count += 1

except PermissionError:
    #catches a permission error if the program cannot access the file
    print("This program does not have access to that file")

print(output)   