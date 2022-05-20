import sys
import os

#allow ANSI escape sequences to work
from colorama import init
init()

if(len(sys.argv) == 4):
    name = sys.argv[1]
    type = sys.argv[2]
    folder = sys.argv[3]

    print("creating folder ... ", end = "")
    os.system(f"mkdir ..\\{folder}\\{name} || mkdir ../{folder}/{name}")
    print("done.")

    if type == "python":
        print("creating virtual environment ... ", end = "")
        os.system(f"python3 -m venv ../{folder}/{name}/venv/ || python3 -m venv ..\\{folder}\\{name}\\venv/")
        print("done.")
else:
    print("USAGE: add_project [project name] [project type] (project_folder)")

    if(len(sys.argv) >= 2):
        if(sys.argv[1] == "help"):
            print()
            print("Project Types:")
            print(" -Python")
    
print()