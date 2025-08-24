docker version

docker pull imageName:tag
docker run --rm imageName # => docker container create + docker container start 
--rm => auto remove container 

docker images
docker image ls
docker image ls -a
docker image rm _imageId_
docker image rm imageName:tag

docker container ls
docker container ls -a
docker container create --name namacontainer imageName:tag
docker container start id/namacontainer
docker container stop id/namacontainer
docker container rm id/namacontainer

# melihat log aplikasi dalam container
docker logs -f id/containername

#
docker container exec -i -t _namacontainer/idcontainer_ /bin/bash

# publish port: --publish atau -p
docker container create --name namacontainer --publish/-p 80:8080 imageName:tag

# inject varEnv: 
docker container create --name namacontainer --publish/-p 80:8080 imageName:tag --env KEY1="value1" --env KEY2="value2"

docker container logs namacontainer # melihat logs yang berasal dari stdout dan stderr

docker container stats  # melihat penggunaan memory dan cpu

# contoh pembuatan lengkap lebih lengkap dengan berbagai parameter
docker container create --name namacontainer -p 80:8080 imageName:tag --name ENVKEY1="value" --memory 800m --cpus 4 --mount “type=bind,source=folder,destination=folder,readonly” --network _namanetwork_
--memory number => membatasi RAM # ram dan cpu defaultnya tidak ada batasan
--cpus number => batasan cpu, bisa decimal (misalnya 1.5 atau 0.5)
--mount => melakukan mount ke folder host OS
--network => menggunakan network yang sudah dibuat

docker volume ls
docker volume create nama_volume
docker volume rm nama_volume
# pakai volume saat create container => --mount “type=volume,source=nama_volume,destination=folder,readonly”
# tidak ada cara yang disediakan docker untuk backup atau menyalin volume ke folder di os, harus masuk manual ke bash container dan melakukan zip dan salin ke bind mount disk os

docker network ls
docker network create --driver none/bridge/host namanetwork
docker network rm namanetwork
docker network disconnect namanetwork namacontainer # menghapus container dari network
docker network connect namanetwork namacontainer # menambah container ke network

docker image inspect namaimage
docker container inspect namacontainer
docker volume inspect namavolume
docker network inspect namanetwork

docker image prune
docker container prune
docker volume prune
docker network prune