def solution(n):
    answer = 0
    a = ''
    while n:
        a += str(n % 3)
        n //= 3
    
    return int(a, 3)