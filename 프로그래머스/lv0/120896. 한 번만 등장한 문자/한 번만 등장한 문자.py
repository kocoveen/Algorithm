def solution(s):
    a = {}
    for i in s:
        if a.get(i) != None:
            a[i] += 1
        else:
            a[i] = 0
    return ''.join(sorted(list({x for x in a if a[x] == 0})))