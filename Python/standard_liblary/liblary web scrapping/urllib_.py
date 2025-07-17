'''
Urllib adalah library bawaan dari Python yang bertujuan untuk scraping konten dari sebuah website.
Penggunaan urllib berbeda dengan beautifulsoup. Bisa dikatakan bahwa cara penggunaan urllib sedikit
kompleks dibandingkan beautifulsoup.
'''

from urllib.request import urlopen
 
# Pengambilan konten
url = "http://python.org/"
page = urlopen(url)
html = page.read().decode("utf-8")
 
# Mencari indeks awal dan akhir
start_index = html.find("<title>") + len("<title>")
end_index = html.find("</title>")
 
# Mengekstrak dan mencetak judul halaman
title = html[start_index:end_index]
print(title)