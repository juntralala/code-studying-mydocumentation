car_started = False

while True:
    command = input('>').lower()
    if command == 'start':
        if car_started :
            print('Car already started')
        elif not car_started:
            print('car started...')
            car_started = True
    elif command == 'stop':
        if not car_started:
            print('Car already stopped')
        elif car_started:
            print('car stoped...')
            car_started = False
    elif command == 'quit':
        if car_started:
            print('Tidak bisa keluar dari program ketika\nmobil sedang berjalan, silahkan hentikan mobil\nterlebih dahulu')
        elif not car_started:
            print('quiting... from program')
            break
    elif command == 'help' :
        print('''start -> for starting car
stop -> for stopping cart
quit -> for quit from program'''
              )
    else:
        print('Maaf, perintah tidak dimengerti\nsilahkan masukan perintah help untuk\nmelihat perintah apa saja yang tersedia')