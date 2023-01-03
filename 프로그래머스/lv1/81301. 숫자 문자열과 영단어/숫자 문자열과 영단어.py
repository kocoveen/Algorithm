def solution(s):
    answer = ''
    c = ''
    num = ['zero','one','two','three','four','five','six','seven','eight','nine']
    for i in s:
        if i.isalpha():
            c += i
            if c in num:
                answer += str(num.index(c))
                c = ''
        else:
            answer += i
            
    return int(answer)