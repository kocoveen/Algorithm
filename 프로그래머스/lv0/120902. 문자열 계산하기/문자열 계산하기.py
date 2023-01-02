def solution(my_string):
    lst = my_string.split(" ")
    answer = int(lst[0])
    for i in range(1, len(lst)-1):
        if lst[i] == '+':
            answer += int(lst[i+1])
        elif lst[i] == '-':
            answer -= int(lst[i+1])
    return answer