openssl genpkey -algorithm RSA -pkeyopt rsa_keygen_bits:2048 -out pkey.pem [-outform PEM|DER]
openssl pkey -in pkey.pem -pubout -out public.pem
openssl pkey -in pkey.pem -noout -text

openssl pkey -outform DER -in pkey.pem -out pkey.der

openssl pkey -aes-256-cbc -in pkey.pem -out enc_pkey.pem # memberi password ke priv.key
openssl pkey -in enc_pkey.pem -out enc_pkey.pem # hapus password
openssl pkey -aes-256-cbc -in enc_pkey.pem -out enc_pkey.pem # ganti password

# Versi lama (sudah deprecated)
openssl genrsa -out privatekey.pem 2048
openssl rsa -in privatekey.pem -pubout -out public.pem
openssl rsa -in privatekey.pem -noout -text

openssl rsa -in private.pem -outform DER -out private.der # ganti format
