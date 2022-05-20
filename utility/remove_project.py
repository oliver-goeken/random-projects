import os
import sys

#prints usage if incorrect number of args
if not (len(sys.argv) == 3 or len(sys.argv) == 2):
    print("USAGE: remove_project [project name] (folder name)")
else:
    print("deleting project ... ", end = "")
    
    #sets project name to first arg
    project_name = sys.argv[1]

    if(len(sys.argv) == 3):
        #sets folder name if 2nd arg exists
        folder_name = sys.argv[2]
        #deletes project folder
        os.system(f"rm -rf ../{folder_name}/{project_name} || rmdir /s /q ..\\{folder_name}\\{project_name}")
    else:
        #deletes project folder
        os.system(f"rm -rf ../{project_name} || rmdir /s /q ..\\{project_name}")

    print("done.")

print()