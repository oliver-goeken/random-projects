import sys
import os

if(len(sys.argv) == 4):
    # TODO: Add functionality (os-specific)
    print()
else:
    print("USAGE: add_project [project name] [project type] (project_folder)")

    if(len(sys.argv) >= 2):
        if(sys.argv[1] == "help"):
            print()
            print("Project Types:")
            print(" -Python")
    
    print()