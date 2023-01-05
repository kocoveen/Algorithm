def solution(lottos, win_nums):
    answer = []
    win_nums2 = []
    
    maxHit = 7
    minHit = 7
    
    for i in win_nums:
        win_nums2.append(i)
    
    for i in lottos:
        if i in win_nums:
            minHit -= 1
            win_nums2.remove(i)
            
    for i in lottos:
        if i == 0:
            lottos[lottos.index(i)] = win_nums2.pop()
    

    for i in lottos:
        if i in win_nums:
            maxHit -= 1

    if minHit == 7:
        minHit = 6
    if maxHit == 7:
        maxHit = 6

    return [maxHit, minHit]