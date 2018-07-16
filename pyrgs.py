import random
import webbrowser
import os
def random_line():
    lines = open('searches.txt').read().splitlines()
    myline = random.choice(lines)
    return myline
def usr_input():
    while True:
        try:
            tabs = int(input("How many random tabs would you like to open?" + os.linesep))
        except ValueError:
            print("That is not a valid integer." + os.linesep + "If you believe this is an error make an issue report on https://github.com/davidteather/Random-Google-Search/tree/RGS-Python" + os.linesep)
            continue
        else:
            return tabs
            break
print ("By using this program you are taking full responsibilities for your own actions with this program and in no way is the creator or contributors liable for your own actions." + os.linesep)
tabs1 = usr_input()
while (tabs1 > 0):
    tabs1 -= 1
    name = random_line()
    name1 = random_line()
    if name == name1:
        name1 = random_line()
    url = 'https://www.google.com/search?q=' + name + "%20" + name1
    webbrowser.open_new(url)
