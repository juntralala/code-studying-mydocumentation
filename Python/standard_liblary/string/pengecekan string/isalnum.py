"""
return true hanya jika string berupa alfabet atau integer atau gabungan keduanya
"""

print("Junaidi".isalnum())  # true
print("12348".isalnum())    # true
print("12ujun".isalnum())   # true
print("12 . ujun".isalnum())        # false
print("Muhammad Junaidi".isalnum()) # false
