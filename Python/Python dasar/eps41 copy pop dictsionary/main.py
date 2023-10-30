import os
os.system('cls')

teman_teman = {
    'jun' : 'Muhammad Junaidi',
    'lan' : 'Ahmad Maulana',
    'ham' : 'M hamdani',
    'sad' : 'M Arsyad'
}

freinds = teman_teman.copy()

print(teman_teman)
print(freinds)

teman_teman['ham'] = 'Ilham'
print(teman_teman)
print(freinds)

teman_teman.pop('ham')
print(teman_teman)

teman_teman.popitem()
print(teman_teman)

