def solution(polynomial):
    answer = ''
    a = [0, 0]
    for i in polynomial.split():
        if 'x' in i:
            if len(i) == 1:
                a[0] += 1
            else:
                a[0] += int(i[:-1])
        elif i == '+':
            continue;
        else:
            a[1] += int(i)
    
    if a[0] == 0:
        answer += str(a[1])
    elif a[0] == 1:
        answer += 'x'
        if a[1] != 0:
            answer += ' + ' + str(a[1])
    else:
        answer += str(a[0]) + 'x'
        if a[1] != 0:
            answer += ' + ' + str(a[1])
    return answer
                
            