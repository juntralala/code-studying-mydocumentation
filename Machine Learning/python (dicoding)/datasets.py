import pandas
from sklearn.model_selection import train_test_split

x = range(10)
y = range(10)

print("random_state ditentukan")
for i in range(3):
    x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.3, random_state=42)
    print(f"{x_test} | {y_test}")

print("random_state tidak ditentukan")
for i in range(3):
    x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.3, random_state=None)
    print(f"{x_test} | {y_test}")

