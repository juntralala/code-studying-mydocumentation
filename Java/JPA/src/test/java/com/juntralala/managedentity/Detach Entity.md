# Detatch Entity
* Kadang ada kasus kita ingin membuat Managed Entity menjadi Unmanaged Entity 
* Untuk kasus seperti itu, kita bisa menggunakan EntityManager.detach(entity)
* Jika sudah menjadi Unmanaged Entity, secara otomatis perubahan yang terjadi di Entity tidak akan disimpan secara otomatis pada saat melakukan commit 
* Perubahan yang terjadi di Unmanaged Entity, harus disimpan secara manual menggunakan EntityManager.persist(entity) atau EntityManager.merge(entity)
