import os
os.system('cls')

Dict = {
    'Nama' : 'Muhammad Junaidi',
    'Umur' : 18,
    'Perkerjaan' : 'Mahasiswa',
}
print(Dict)
print(Dict['Nama'])

lendict = len(Dict)
print(f'Panjang Dict : {lendict}')

key = 'Umur'
key_check = key in Dict
print(f'Check kata kunci {key} Ada di Dict : {key_check}')

print(Dict['Nama'])
print(Dict.get('Nama'))
print(Dict.get('Alamat','data tidak di temukan'))

Dict['Nama'] = 'Ahmad Maulana'
print(Dict)
Dict.update({'Nama' : 'Muhammad Junaidi'})
print(Dict)
Dict.update({'Alamat' : 'Handil Rantau'})
print(Dict)

del Dict['Alamat']
print(Dict)