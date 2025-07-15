def encrypt_caesar(plaintext, shift):
    encrypted_text = ""
    for char in plaintext:
        if char.isalpha():
            shift_amount = shift % 26
            new_char = chr((ord(char) - ord('A') + shift_amount) % 26 + ord('A')) if char.isupper() else chr((ord(char) - ord('a') + shift_amount) % 26 + ord('a'))
            encrypted_text += new_char
        else:
            encrypted_text += char
    return encrypted_text

def decrypt_caesar(ciphertext, shift):
    return encrypt_caesar(ciphertext, -shift)

# Contoh penggunaan
plaintext = "KAMU GANTENG BINGITZ"
shift = 3
encrypted = encrypt_caesar(plaintext, shift)
print("Encrypted:", encrypted)
decrypted = decrypt_caesar(encrypted, shift)
print("Decrypted:", decrypted)
