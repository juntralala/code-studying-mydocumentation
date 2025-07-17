### 
Event bisa terpisah dari kelas entity atau langsung dibuatkan method event listener nya langsung di kelas entity nya

| Event Annotation | Keterangan                                  |
|------------------|---------------------------------------------|
| @PrePersist      | Dieksekusi sebelum melakukan persist entity |
| @PostPersist     | Dieksekusi setelah melakukan persist entity |
| @PreRemove       | Dieksekusi sebelum melakukan remove entity  |
| @PostRemove      | Dieksekusi setelah melakukan remove entity  |
| @PreUpdate       | Dieksekusi sebelum melakukan update entity  |
| @PostUpdate      | Dieksekusi setelah melakukan update entity  |
| @PostLoad        | Dieksekusi setelah melakukan load entity    |