var_arr = [1, 7, 2, 89, 3]

left = 0
right = 0
for v in var_arr:
    right = v
    if right > left:
        left = right

print(left)