def solution(dots):
    answer = 0
    a = max(dots[0][0], dots[1][0], dots[2][0]) - min(dots[0][0], dots[1][0], dots[2][0])
    b = max(dots[0][1], dots[1][1], dots[2][1]) - min(dots[0][1], dots[1][1], dots[2][1])
    return a * b