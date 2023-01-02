def solution(absolutes, signs):
    return sum([a if s else -a for a, s in zip(absolutes, signs)])