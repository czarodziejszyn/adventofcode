file = open("inputaoc13.txt","r")
lines = file.readlines()
for line in lines:
    newline = ''
    for x in range(len(line)-1):
        if  line[x] == '[':
            newline += ('(')
        elif line[x] == ']':
            newline += (')')
        else:
            newline += (line[x])
    print(newline)