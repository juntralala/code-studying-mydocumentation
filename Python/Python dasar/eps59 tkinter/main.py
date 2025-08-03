import tkinter as tk
from tkinter import ttk
from tkinter.messagebox import showinfo


window = tk.Tk()

window.configure(bg="#eaeaea")
window.geometry("600x400")
# window.resizable(False,False)
window.title("Sapa Dia😎")

# Frame Input
inputFrame = ttk.Frame(window)
# Penempatan Grid, Pack, Place
inputFrame.pack(padx=10,pady=10,fill='x',expand=True)
# kompnen-kompunen
# nama Depan Lable
namaDepanLabel = ttk.Label(inputFrame,text='NAMA DEPAN')
namaDepanLabel.pack(padx=10,pady=10,fill='x',expand=True)
namaDepanLabel.configure(background="white")
# nama depan Entry
namaDepan = tk.StringVar()
namaDepanEntry = ttk.Entry(inputFrame,textvariable=namaDepan)
namaDepanEntry.pack(padx=10,pady=10,fill='x',expand=True)
# nama Belakang Lable
namaBelakangLabel = ttk.Label(inputFrame,text='NAMA BELAKANG')
namaBelakangLabel.pack(padx=10,pady=10,fill='x',expand=True)
namaBelakangLabel.configure(background="white")
# nama Belakang Entry
namaBelakang = tk.StringVar()
namaBelakangEntry = ttk.Entry(inputFrame,textvariable=namaBelakang)
namaBelakangEntry.pack(padx=10,pady=10,fill='x',expand=True)
# Tombol Sapa
def tombolSapaIpul():
    print(f'Hallo {namaDepan.get()} {namaBelakang.get()}')
    showinfo(title='Sapa Dia',message=f'Halo {namaDepan.get()} {namaBelakang.get()}')
tombolSapa = ttk.Button(inputFrame,text="Sapa",command=tombolSapaIpul)
tombolSapa.pack(padx=10,pady=10,fill='x',expand=True)


window.mainloop()