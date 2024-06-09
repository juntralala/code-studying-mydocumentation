"""
isdigit(): Memeriksa apakah string hanya terdiri dari digit unicode.

Digit unicode adalah karakter yang memiliki kategori Unicode "Nd". Ini termasuk digit Arab (0-9), digit Latin (0-9), dan digit lainnya seperti digit Bengali (০-৯).
Digit numerik adalah subset dari digit unicode yang hanya terdiri dari digit Arab (0-9).
"""

print("123".isdigit())   # true
print("123 ".isdigit())  # false