# membuat container
docker compose create
# membuat container dan menjalankannya
docker compose up
docker compose start
docker compose stop
docker compose ps
docker compose ls
# menghapus container dan network pada compose saat ini, volume tidak dihapus
docker compose down
docker compose build
docker compose up --scale app=3 # membuat service dengan nama app dengan 3 replika
# jalankan perintah sekali jalan
docker compose run --rm salahsatu_nama_service php artisan migrate