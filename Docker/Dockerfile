#kumpulan instruction di docker
FROM imageName:version

# RUN menjalankan perintah yang satu kali saat build
RUN command arg arg
RUN ["executable", "arg1", "arg2", ...]

# menampilkan detail build: (karna ditdak ditampilkan default)
#  --progress=plain
#  --no-cache        <= default docker melakukan cache    


CMD command arg arg
CMD ["executable", "arg1", "arg2", ...]
CMD ["arg1", "arg2", ...]  # <= akan menggunakan ENTRY POINT

LABEL key=value                 # <= bisa dilihat dengan docker image inspect
LABEL key1=value1 key2=value2

ADD source destination  # <= tidak hanya bisa copy, tapi bisa otomatis extract file archive atau download dari url
COPY source destination

EXPOSE port # <= hanya sebagai dokumentasi, default tcp
EXPOSE port/tcp
EXPOSE port/udp

# env variable
ENV key=value 
ENV key1=value1 key2=value2
EXPOSE ${VAR_ENV} # <= env bisa digunakna dengan cara ini
# env bisa ditimpa saat create container

VOLUME /lokasi/folder
VOLUME /lokasi/folder /lokasi2/folder2
VOLUME ["/lokasi/folder", "/lokasi2/folder2"]

WORKDIR /lokasi/folder # <= lokasi untuk menjalankan RUN, CMD, ENTRY POINT, COPY atau ADD. Default akan buat otomatis. Jika relarive path, maka relative path dari workdir sebelumnya

USER user# <= Default user root.
USER user:group

ARG key=value key=value # <= singkatnya, mirip seperti env tapi digunakan hanya saat build image

HEALTHCHECK NONE # <= disable
HEALTHCHECK [OPTIONS] CMD commad # <= disable
# OPTIONS:
#   --interval=DURATION(default:30s)
#   --timeout=DURATION(default:30s)
#   --start-period=DURATION(default:0s)
#   --retries=N(default:3)

ENTRYPOINT executable param param # <= menentukan executable file yang akan dijalankan, kalau ada ini CMD hanya akan menambahkan argument
ENTRYPOINT ["executable", "param", "param"]