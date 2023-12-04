file = open("inputaoc13.txt","r")
lines = file.readlines()
result = 0


def check(line, index, power):
    num = 0
    if line[index] == '[':
        power += 1
        num = 0
    elif line[index] == ']':
        power -= 1
        num = 0
    elif line[index] != ',':
        num += int(line[index])
        if line[index+1] != ']' and line[index+1] != '[' and line[index+1] != ',':
            num *= 10
            index += 1
            num += int(line[index])
    return (index, power, num)


for x in range (len(lines)-1):
    line1 = lines[x]
    x+=1
    line2 = lines[x]
    x+=1
    l1power = 0
    l2power = 0
    num1 = 0
    num2 = 0
    l2index = -1
    for char in range (len(line1)-1):
        l2index += 1
        if l2index < len(line2)-1:
            l2index += 1
            (char, l1power, num1) = check(line1, char, l1power)
            (l2index, l2power, num2) = check(line2, l2index, l2power)
        else:
            break
        if num1 != 0 and num2 != 0:
            if num1 > num2:
                break
            elif num1 < num2:
                result += x+1
                break
        elif num1 != 0 and num2 == 0:
            while l2index < len(line2)-1:
                (l2index, l2power, num2) = check(line2, l2index, l2power)
                if num2 != 0:
                    break
                else:
                    if line2[l2index]=='[':
                        l1power += 1
                    elif l1power > l2power:
                        char = len(line1)
                        break
                