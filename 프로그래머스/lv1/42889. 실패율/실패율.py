def solution(N, stages):
    a = {}
    answer = [len(stages)]
    for i in range(1, N+1):
        answer.append(answer[-1] - stages.count(i))
    
    for i in range(N):
        if answer[i] != 0:
            a[i+1] = stages.count(i+1) / answer[i]
        else:
            a[i+1] = 0
    return [i[0] for i in sorted(a.items(), key=lambda item: item[1], reverse=True)]