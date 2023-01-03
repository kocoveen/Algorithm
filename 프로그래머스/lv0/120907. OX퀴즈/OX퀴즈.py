def solution(quiz):
    a = [i.split(" = ") for i in quiz]
    b = []
    for i in a:
        if eval(i[0]) == int(i[1]):
            b.append("O")
        else:
            b.append("X")
            
    return b