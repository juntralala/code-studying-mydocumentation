# cara ringkas
openssl req -x509 -days 365 -newkey rsa:2048 -nodes -out cetrificate.cert -keyout privatekey.pem

# 
openssl req -new -nodes -key pub.pem -out my.csr
openssl x509 -req -days 365 -in my.csr -singkey privkey.pem -out my.cert

# memeriksa/melihat csr
openssl req -in request.csr -noout -text
