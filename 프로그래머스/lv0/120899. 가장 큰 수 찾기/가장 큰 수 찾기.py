def solution(array):
    return sum([[x, i] for i, x in enumerate(array) if max(array) == x], [])