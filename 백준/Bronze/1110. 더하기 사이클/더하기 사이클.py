a = input()

num = [i for i in a]

def cycleSum(arr):
    cnt = 1
    arr.append(str((int(arr[-1]) + int(arr[-2])) % 10))
    while (arr[-2] + arr[-1]) != (arr[0] + arr[1]):
        arr.append(str((int(arr[-2]) + int(arr[-1])) % 10))
        cnt += 1
    
    return print(cnt)
    
if len(num) != 1:
    cycleSum(num)
else:
    num.insert(0, "0")
    cycleSum(num)