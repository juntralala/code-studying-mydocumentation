def emoji_converter(texts:str):
    simbols = {
        '(:':'😊',
        '):':'☹️',
    }
    new_text = ''
    for word in text.split(' '):
        new_text += simbols.get(word, word) + ' '
    # print(new_text + 'dalam function')
    return new_text


text = input('Masukan text : ')
new_texts = emoji_converter(text)

print(new_texts)