numbers = ['zero','one','two','three','four','five','six','seven','eight','nine']

def solution(s):
    answer = s
    for i, num in enumerate(numbers):
        answer = answer.replace(str(num), str(i))
    return int(answer)