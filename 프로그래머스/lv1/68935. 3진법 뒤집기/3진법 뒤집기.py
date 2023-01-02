def solution(n):
    answer = 0
    a = ''
    while n // 3 >= 1:
        a += str(n % 3)
        n //= 3
    a += str(n % 3)
    
    answer = sum([int(a[-i-1])*3**i for i in range(len(a))])
    
    return answer