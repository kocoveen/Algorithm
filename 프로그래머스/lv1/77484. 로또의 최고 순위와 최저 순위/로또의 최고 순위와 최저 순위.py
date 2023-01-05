def solution(lottos, win_nums):

    rank=[6, 6, 5, 4, 3, 2, 1]

    cnt_0 = lottos.count(0)
    hit = 0
    
    for x in win_nums:
        if x in lottos:
            hit += 1
    return rank[cnt_0 + hit], rank[hit]