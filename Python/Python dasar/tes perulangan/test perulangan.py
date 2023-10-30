import tkinter as tk

import os
os.system('cls')

text= ['Muhammad Junaidi',1,2,'Humaidi']
panjang = len(text)

for i in text :
    print(i)
print(panjang)
print(len(text[0]))
print(text[0].count('a'))

window = tk.Tk()

window.mainloop()


