'''
Beautifulsoup adalah library untuk mengambil data dari halaman web dan mengekstrak informasi yang diperlukan
'''

from urllib.request import urlopen
from bs4 import BeautifulSoup

#  mengambil konten
url = "https://youtube.com"
page = urlopen(url)
html = page.read().decode("utf-8")

# membuat object BeautifulSoup
soup = BeautifulSoup(html, "html.parser")

# Mencetak judul halaman
print(soup.title)
