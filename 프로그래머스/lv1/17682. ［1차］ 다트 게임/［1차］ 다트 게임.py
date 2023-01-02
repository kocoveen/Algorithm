import re

def solution(dartResult):
    dartResult = re.split('(\d+)(\w)', dartResult)
    lst = []
    for i in range(len(dartResult)):
        if dartResult[i] == 'S':
            lst.append(int(dartResult[i-1]))
        elif dartResult[i] == 'D':
            lst.append(int(dartResult[i-1]) ** 2)
        elif dartResult[i] == 'T':
            lst.append(int(dartResult[i-1]) ** 3)
        elif dartResult[i] == '*':
            if len(lst) != 1:
                lst[int((i/3)-1)-1] *= 2
                lst[int((i/3)-1)] *= 2
            else:
                lst[int((i/3)-1)] *= 2
        elif dartResult[i] == '#':
            lst[int((i/3)-1)] *= -1
            
        print(i, dartResult[i], lst)

    return sum(lst)