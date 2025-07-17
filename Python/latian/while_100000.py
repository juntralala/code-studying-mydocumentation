import time
start = time.time()

n = 0

while (n<100000):
    n +=1
    print(n)
    
end = time.time()

print(end - start)