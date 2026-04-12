FROM php:8.0-alpine

RUN mkdir /wwww
WORKDIR /www
RUN echo "hello world" > index.php 
CMD ["php", "-S", "0.0.0.0:8080"]