def encrypt_vigenere(plaintext, key):
    encrypted_text = ""
    key_length = len(key)
    for i, char in enumerate(plaintext):
        if char.isalpha():
            shift = ord(key[i % key_length].upper()) - ord('A')
            new_char = chr((ord(char.upper()) - ord('A') + shift) % 26 + ord('A'))
            encrypted_text += new_char if char.isupper() else new_char.lower()
        else:
            encrypted_text += char
    return encrypted_text

def decrypt_vigenere(ciphertext, key):
    decrypted_text = ""
    key_length = len(key)
    for i, char in enumerate(ciphertext):
        if char.isalpha():
            shift = ord(key[i % key_length].upper()) - ord('A')
            new_char = chr((ord(char.upper()) - ord('A') - shift + 26) % 26 + ord('A'))
            decrypted_text += new_char if char.isupper() else new_char.lower()
        else:
            decrypted_text += char
    return decrypted_text

# Contoh penggunaan
plaintext = "HELLO"
key = "KEY"

encrypted = encrypt_vigenere(plaintext, key)
print("Encrypted:", encrypted)

decrypted = decrypt_vigenere(encrypted, key)
print("Decrypted:", decrypted)
