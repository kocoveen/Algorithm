def insertZero(x, n):
    while len(x) < n:
        x = '0' + x
    return x

def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        answer.append(insertZero(format(arr1[i] | arr2[i], 'b'), n).replace('1', '#').replace('0', ' '))
    return answer