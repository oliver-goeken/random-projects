import sys
import os

#allow ANSI escape sequences to work
from colorama import init
init()

#runs only if correct number of arguments
if(len(sys.argv) == 4):
    #assigns each argument to a variable
    name = sys.argv[1]
    type = sys.argv[2]
    folder = sys.argv[3]

    #creates project folder (should work for any OS)
    print("creating folder ... ", end = "")
    os.system(f"mkdir ..\\{folder}\\{name} || mkdir ../{folder}/{name}")
    print("done.")

    #if it is a python project, create a virtual environemnt to work in (should also work on any OS)
    if type == "python":
        print("creating virtual environment ... ", end = "")
        os.system(f"python3 -m venv ../{folder}/{name}/venv/ || python3 -m venv ..\\{folder}\\{name}\\venv/")
        print("done.")
else:
    #prints correct usage if used incorrectly
    print("USAGE: add_project [project name] [project type] (project_folder)")

    # checks if there are arguments, then if the argument help is present,
    # prints a helpful message
    if(len(sys.argv) >= 2):
        if(sys.argv[1] == "help"):
            print()
            print("Project Types:")
            print(" -Python")
    
print()