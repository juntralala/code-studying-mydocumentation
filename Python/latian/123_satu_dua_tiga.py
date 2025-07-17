import random

print(random.randint(10,20))


phone = input('Masukan no : ')

kamus = {
    '0':'nol',
    '1':'satu',
    '2':'dua',
    '3':'tiga',
    '4':'empat',
    '5':'lima',
    '6':'enam',
    '7':'tujuh',
    '8':'delapan',
    '9':'sembilan'
}

phone_text = ''
for number in phone:
    phone_text += kamus[number] + ' '
    
print(phone_text) 