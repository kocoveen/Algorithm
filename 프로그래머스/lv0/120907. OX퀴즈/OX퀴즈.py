def solution(quiz):
    answer = []
    for q in quiz:
        L, R = q.split(" = ")
        a, op, b = L.split()
        if op == '+':
            result = 'O' if int(a) + int(b) == int(R) else "X"
            answer.append(result)
        elif op == '-':
            result = 'O' if int(a) - int(b) == int(R) else "X"
            answer.append(result)

    return answer