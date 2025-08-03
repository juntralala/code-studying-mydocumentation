
text = input('Masukan text : ')

simbols = {
    '(:':'😊',
    '):':'☹️',
}
new_text = ''
for word in text.split(' '):
    new_text += simbols.get(word, word) + ' '

print(new_text)

print(new_text)