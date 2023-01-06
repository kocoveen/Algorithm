def solution(numbers):
    numbers=sorted(numbers)
    return max(numbers[0]*numbers[1], numbers[-2]*numbers[-1])