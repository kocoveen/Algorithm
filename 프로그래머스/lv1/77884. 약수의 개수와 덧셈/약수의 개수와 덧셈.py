def solution(left, right):
    answer = 0
    for i in range(left, right+1):
        if i == 1:
            answer = -1
            continue
        else:
            cnt = 2

        for j in range(2, int(i/2+1)):
            if i % j == 0:
                cnt += 1

        if cnt % 2 == 0:
            answer += i
        else:
            answer -= i
    return answer