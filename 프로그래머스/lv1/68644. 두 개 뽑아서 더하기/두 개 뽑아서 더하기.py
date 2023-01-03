def solution(numbers):
    answer = []
    for i in range(len(numbers)-1):
        for j in range(i+1, len(numbers)):
            answer.append(numbers[i] + numbers[j])
            
    answer = list(set(answer))
    
    for i in range(len(answer)):
        for j in range(0, len(answer)-i-1):
            if answer[j] > answer[j+1]: 
                answer[j], answer[j+1] = answer[j+1], answer[j]

    return answer