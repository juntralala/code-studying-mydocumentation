# Hierarki
```text
Resource (Interface)
├── AbstractResource (Abstract Class)
│   ├── AbstractFileResolvingResource
│   │   ├── UrlResource
│   │   └── FileUrlResource
│   ├── BeanDefinitionResource
│   ├── ByteArrayResource
│   ├── ClassPathResource
│   ├── ContextResource
│   ├── DescriptiveResource
│   ├── FileSystemResource
│   ├── InputStreamResource
│   ├── OriginTrackedResource
│   ├── PathResource
│   ├── VfsResource
│   └── WritableResource
├── ClassRelativeResourceLoader
├── DefaultResourceLoader
├── FileSystemResourceLoader
├── FilteredFeatureWebContextResource
├── ResourceDecoder

Resource (Interface)
├── AbstractResource (Abstract Class)
│   ├── AbstractFileResolvingResource
│   │   ├── UrlResource
│   │   ├── FileUrlResource
│   │   ├── PathResource
│   │   ├── VfsResource
│   │   └── FileSystemResource
│   ├── BeanDefinitionResource
│   ├── ByteArrayResource
│   ├── ClassPathResource
│   ├── ContextResource (Interface)
│   │   ├── ClassPathContextResource
│   │   ├── ClassRelativeContextResource
│   │   ├── FileSystemContextResource
│   ├── DescriptiveResource
│   ├── EncodedResource
│   ├── FilteredReactiveWebContextResource
│   ├── HttpResource
│   ├── InputStreamResource
│   ├── ModuleResource
│   ├── MultipartFileResource
│   ├── OriginTrackedResource
│   │   ├── OriginTrackedWritableResource
│   ├── TransformedResource
│   ├── WritableResource (Interface)
│   │   ├── FileSystemResource
│   │   ├── FileUrlResource
│   │   ├── PathResource
│   │   ├── VfsResource
│   │   ├── OriginTrackedWritableResource
│   │   ├── MultipartFileResource
│   │   └── HttpResource
├── ApplicationResource in ApplicationResourceLoader
├── FileNameVersionedResource in VersionResourceResolver
├── HeadMethodResource in ResourceHandlerFunction
├── ClassRelativeResourceLoader
├── DefaultResourceLoader
├── FileSystemResourceLoader

```

# Datfar Implementasi Resource

| **Class**                            | **Keterangan**                                                       |
|--------------------------------------|----------------------------------------------------------------------|
| `Resource` (Interface)               | Interface utama untuk semua jenis resource.                          |
| `AbstractResource` (Abstract Class)  | Implementasi dasar dari `Resource`, memberikan beberapa metode umum. |
| `AbstractFileResolvingResource`      | Subkelas `AbstractResource` yang menangani resource berbasis file.   |
| `UrlResource`                        | Mengakses resource melalui URL.                                      |
| `FileUrlResource`                    | Resource berbasis URL file (`file://`).                              |
| `PathResource`                       | Resource berbasis `java.nio.file.Path`.                              |
| `VfsResource`                        | Resource berbasis Virtual File System (VFS).                         |
| `FileSystemResource`                 | Resource berbasis sistem file.                                       |
| `BeanDefinitionResource`             | Resource yang digunakan untuk definisi bean dalam Spring.            |
| `ByteArrayResource`                  | Resource berbasis byte array.                                        |
| `ClassPathResource`                  | Resource yang diambil dari classpath.                                |
| `ContextResource` (Interface)        | Interface untuk resource yang memiliki konteks tertentu.             |
| `ClassPathContextResource`           | Resource dari classpath dalam konteks tertentu.                      |
| `ClassRelativeContextResource`       | Resource yang relatif terhadap suatu kelas tertentu.                 |
| `FileSystemContextResource`          | Resource berbasis sistem file dalam konteks tertentu.                |
| `DescriptiveResource`                | Resource untuk memberikan deskripsi tanpa lokasi nyata.              |
| `EncodedResource`                    | Resource dengan encoding tertentu.                                   |
| `FilteredReactiveWebContextResource` | Resource dalam konteks web reaktif dengan filtering.                 |
| `HttpResource`                       | Resource yang diperoleh melalui HTTP.                                |
| `InputStreamResource`                | Resource berbasis `InputStream`.                                     |
| `ModuleResource`                     | Resource yang terkait dengan modul Java 9+.                          |
| `MultipartFileResource`              | Resource yang mewakili file multipart dalam upload HTTP.             |
| `OriginTrackedResource`              | Resource dengan informasi asal.                                      |
| `OriginTrackedWritableResource`      | Resource yang dapat ditulis dengan informasi asal.                   |
| `TransformedResource`                | Resource hasil transformasi dari resource lain.                      |
| `WritableResource` (Interface)       | Interface untuk resource yang dapat ditulis.                         |
| `ApplicationResource`                | Resource yang digunakan dalam `ApplicationResourceLoader`.           |
| `FileNameVersionedResource`          | Resource dengan versi berbasis nama file.                            |
| `HeadMethodResource`                 | Resource yang mendukung metode HTTP HEAD.                            |
| `ClassRelativeResourceLoader`        | Loader untuk resource yang terkait dengan kelas tertentu.            |
| `DefaultResourceLoader`              | Loader default untuk resource dalam Spring.                          |
| `FileSystemResourceLoader`           | Loader untuk resource berbasis sistem file.                          |
