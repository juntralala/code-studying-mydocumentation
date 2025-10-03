# cara-1: ringkas
openssl req -x509 -days 365 -newkey rsa:2048 -nodes -out cetrificate.cert -keyout privatekey.pem

# cara-2
openssl req -new -nodes -key .pem -out my.csr
openssl x509 -req -days 365 -in my.csr -singkey priv.pem -out my.cert

# cara-3
openssl req -new -x509 -key privatekey.pem -out cert.pem -days 365 -nodes

# memeriksa/melihat csr
openssl req -in request.csr -noout -text
