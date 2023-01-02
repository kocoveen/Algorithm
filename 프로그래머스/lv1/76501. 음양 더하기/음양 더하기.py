def solution(absolutes, signs):
    return sum([i * -1 if x is False else i * x for i, x in zip(absolutes, signs)])