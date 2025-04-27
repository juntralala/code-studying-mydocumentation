# MongoDB

```js
db.info();
db.stats();

db.createCollection("users");
db.getCollectionNames();
db.getCollection("users");
db.users; // db.<collectionName>
db.getCollectionInfo();

db.users.drop();
db.users.find();
db.users.count();
db.users.size();

// tipe data di BSON
console.log("String");
console.log("Double");
console.log("Object");
console.log("Array");
console.log("Binary Data");
console.log("ObjectId");
console.log("Boolean");
console.log("Date");
console.log("Null");
console.log("Regular Expression");
console.log("Javascript");
console.log("Javascript With Scope");
console.log("32 Bit Integer", "int");
console.log("Timestamp");
console.log("64 Bit Integer", "long");
console.log("128 Bit Integer", "decimal");
console.log("Min Key");
console.log("Max Key");

// insert data
db.users.insertOne({username: "ujun", password: "rahasia"});
db.products.insertMany([
    {
        _id: 1,
        name: "handphone"
    }, {
        _id: 2,
        name: "laptop"
    }
]);

$eq;
$gt;
$gte;
$lt;
$lte;
$nin;
$ne;

db.products.find({
    price: {
        $gt: 20_000
    }
});

$and;
$or;
$nor;
$not;

$exists;
$type;
```

## Evaluation Operator
| Operator    | Keterangan                                                      |
|-------------|------------------------------------------------------------------|
| $expr       | Menggunakan aggregation operation                               |
| $jsonSchema | Validasi document sesuai dengan JSON schema : [json-schema.org](https://json-schema.org/) |
| $mod        | Melakukan operasi modulo                                        |
| $regex      | Mengambil document sesuai dengan regular expression (PCRE)      |
| $text       | Melakukan pencarian menggunakan text                            |
| $where      | Mengambil document dengan JavaScript Function                   |

contoh expression:
```js
// insert customers documents
db.customers.insertOne({
    _id: "joko",
    name: "joko",
});

// select * from customers where _id = name
db.customers.find({
    $expr: {
        $eq: ["$_id", "$name"]
    }
});
```
contoh json schema:
```js
// select * from products where name is not null and category is not null
db.products.find({
    $jsonSchema: {
        required: ["name", "category"]
    }
});

// select * from products where name is not null and type(name) = 'string' and type(price) = 'number'
db.products.find({
    $jsonSchema: {
        required: ["name"],
        properties: {
            name: {
                type: "string"
            },
            price: {
                type: "number"
            }
        }
    }
});
```

contoh modulo:
```js
// select * from products where price % 5 = 0
db.products.find({
    price: {
        $mod: [5, 0]
    }
});

// select * from products where price % 1000000 = 0
db.products.find({
    price: {
        $mod: [1000000, 0]
    }
});
```

contoh regex:
```js
// select * from products where name like "%mie%"
db.products.find({
    name: {
        $regex: /mie/,
        $options: "i"
    }
});

// select * from products where name like "Mie%"
db.products.find({
    name: {
        $regex: /^Mie/
    }
});
```

contoh where:
```js
// select * from products where _id = name
db.customers.find({
    $where: function() {
        return this._id === this.name;
    }
});
```

## Array Operator
| Operator   | Keterangan                                                             |
|------------|------------------------------------------------------------------------|
| $all       | Mencocokkan array yang mengandung elemen-elemen tertentu               |
| $elemMatch | Mengambil document jika tiap elemen di array memenuhi kondisi tertentu |
| $size      | Mengambil document jika ukuran array sesuai                            |

```js
// insert products with tags
db.products.insertMany([
  {
    _id: 6,
    name: "Logitech Wireless Mouse",
    price: new NumberLong("175000"),
    category: "laptop",
    tags: ["logitech", "mouse", "accessories"]
  },
  {
    _id: 7,
    name: "Cooler Pad Gaming",
    price: new NumberLong("200000"),
    category: "laptop",
    tags: ["cooler", "laptop", "accessories", "fan"]
  },
  {
    _id: 8,
    name: "Samsung Curved Monitor",
    price: new NumberLong("1750000"),
    category: "computer",
    tags: ["samsung", "monitor", "computer"]
  }
]);

// select * from products where (tags = "samsung" and tags = "monitor")
db.products.find({
  tags: {
    $all: ["samsung", "monitor"]
  }
});

// select * from products where tags in ("samsung", "logitech")
db.products.find({
  tags: {
    $elemMatch: {
      $in: ["samsung", "logitech"]
    }
  }
});

// select * from products where count(tags) = 3
db.products.find({
  tags: {
    $size: 3
  }
});
```

## Projection Operator
- Pada function find, terdapat parameter kedua setelah query, yaitu projection
- Projection adalah memilih field mana yang ingin kita ambil atau hide
- `db.<collection>.find(query, projection)`

```js
// select _id, name, category from products
db.products.find({}, {
    name: 4,
    category: 1
});

// select _id, name, category, price from products
db.products.find({}, {
    tags: 0
});
```

## Prjection operator
| Operator   | Keterangan                                                                    |
|------------|-------------------------------------------------------------------------------|
| $          | Limit array hanya mengembalikan data pertama yang match dengan array operator |
| $elemMatch | Limit array hanya mengembalikan data pertama yang match dengan kondisi query  |
| $meta      | Mengembalikan informasi metadata yang didapat dari setiap matching document   |
| $slice     | Mengontrol jumlah data yang ditampilkan pada array                            |

# Query Modifier
count()
skip()
limit()
sort(query)

# Update Document
updateOne()
updateMany()
replaceOne()

syntax:
```js
// update one syntax
db.customers.updateOne(
    {}, // filter
    {}, // update
    {}  // options
);

// update many syntax
db.customers.updateMany(
    {}, // filter
    {}, // update
    {}  // options
);

// replace one syntax
db.customers.replaceOne(
    {}, // filter
    {}, // update
    {}  // options
);
```

contoh:
```js
// update products set category = "food" where _id = 1
db.products.updateOne({
    _id: 1
},{
    $set: {
        category: "food"
    }
});

// update products set category = "food" where _id = 2
db.products.updateOne({
    _id: 2
},{
    $set: {
        category: "food"
    }
});



// replace example
// insert wrong document
db.products.insertOne(
    {
        _id: 9,
        name: "Ups Salah",
        wrong: "Salah Lagi"
    }
);

// replace document with id 9
db.products.replaceOne(
    { _id: 9 },
    {
        name: "Adidas Sepatu Lari Pria",
        price: new NumberLong("1100000"),
        category: "shoes",
        tags: [
            "adidas", "shoes", "running"
        ]
    }
);
```

## Update Document Function

| Operator     | Keterangan                                                  |
|--------------|-------------------------------------------------------------|
| $set         | Mengubah nilai field di document                            |
| $unset       | Menghapus field di document                                 |
| $rename      | Mengubah nama field di document                             |
| $inc         | Menaikan nilai number di field sesuai dengan jumlah tertentu|
| $currentDate | Mengubah field menjadi waktu saat ini                       |

```js
db.products.updateMany({}, {
    $set: {
        stock: 0
    }
});

db.products.updateMany({}, {
    $inc: {
        stock: 10
    }
});

db.customers.updateMany({}, {
    $rename: {
        name: "full_name"
    }
});

db.customers.updateMany({}, {
    $unset: {
        swrong_field: ""
    }
});

db.products.updateMany({}, {
    $currentDate: {
        lastModifiedDate: {
            $type: $date
        }
    }
})
```


## Array Update Operator
| Operator         | Keterangan                                                   |
|------------------|--------------------------------------------------------------|
| $                | Mengupdate data array pertama sesuai kondisi query           |
| $[]              | Mengupdate semua data array sesuai kondisi query             |
| $[<identifier>]  | Mengupdate semua data array yang sesuai kondisi arrayFilters |
| <index>          | Mengupdate data array sesuai dengan nomor index              |
| $addToSet        | Menambahkan value ke array, dihiraukan jika sudah ada        |
| $pop             | Menghapus element pertama (-1) atau terakhir (1) array       |
| $pull            | Menghapus semua element di array yang sesuai kondisi         |
| $push            | Menambahkan element ke array                                 |
| $pullAll         | Menghapus semua element di array                             |

```js
db.products.updateMany({}, {
    $set: {
        ratings: [90, 80, 70]
    }
});

db.products.updateMany({
    ratings: 90
}, {
    $set: {
        'ratings.$': 100
    }
});

db.products.updateMany({}, {
    $set: {
        'ratings.$[]': 100
    }
});

db.products.updateMany({}, {
    $set: {
        'ratings.$[elemn]': 100
    }
}, {
    arrayFilters: [
        {
            elemn: {
                $gte: 80
            }
        }
    ]
});

db.products.updateMany({}, {
    $set: {
        'ratings.0': 50,
        'ratings.1': 60
    }
});
```

## Array Update Operator Modifier

| Operator   | Keterangan                                                           |
|------------|----------------------------------------------------------------------|
| $each      | Digunakan di $addToSet dan $push, untuk menambahkan multiple element |
| $position  | Digunakan di $push untuk mengubah posisi menambahkan data            |
| $slice     | Digunakan di $push untuk menentukan jumlah maksimal data array       |
| $sort      | Digunakan untuk mengurutkan array setelah operasi $push              |

```js
// add 100, 200, 300 to ratings
db.products.updateMany({}, {
    $push: {
        ratings: {
            $each: [100, 200, 300]
        }
    }
})

// add trending, popular to tags
db.products.updateMany({}, {
    $addToSet: {
        tags: {
            $each: ["trending", "popular"]
        }
    }
})

// add hot in position 1
db.products.updateMany({}, {
    $push: {
        tags: {
            $each: ["hot"],
            $position: 1
        }
    }
})

// add all element, but limit with slice from behind
db.products.updateMany({}, {
    $push: {
        ratings: {
            $each: [100, 200, 300, 400, 500],
            $slice: -3
        }
    }
})

// add all element, and sort desc
db.products.updateMany({}, {
    $push: {
        ratings: {
            $each: [100, 200, 300, 400, 500],
            $sort: -1
        }
    }
})
```

# delete data
db.users.deleteOne({})
db.users.deleteMany({})

# Bulk Write
```js
db.users.bulkWrite();
```
> untuk lengkapnya baca dokumentasi

# Indexes
Indexes default menggunakan BTree

```js
db.products.createIndex({
    category: 1 // index ascending
});

db.products.getIndexes();

db.products.find({
    category: "food"
});

db.products.dropIndex("category_1");
```

debug eksekusi dengan index dan tidak:
```js
// debugging with index
db.products.find({
    category: "food"
}).explain();
db.products.find({}).sort({
    category: 1
}).explain();

// debugging without index
db.products.find({
    "tag": "laptop"
}).explain();
```

### Compound Index
* MongoDB memungkinkan untuk membuat index pada kombinasi dari lebih dari 1 kolom, atau disebut Compound Index
* MongoDB membatasi jumlah maksimal penggabungan kolom dalam CompoundIndex sampai dengan 32 kolom
```js
db.products.createIndex({
    stock: 1,
    tags: 1
});
```

### Index Strategy
- Buat index untuk mendukung performa query  
  - Gunakan single index, jika kita hanya melakukan query terhadap satu field saja  
  - Gunakan compound index, jika kita sering melakukan query ke field pertama, atau kombinasi field pertama dan kedua, atau pertama dan kedua dan seterusnya  
- Buat index untuk mengurutkan hasil query  
- Sering-seringlah menggunakan function `explain()` untuk mengecek apakah query kita sudah di-optimize dengan index atau belum  
- Jika kita buat compound index `(a, b, c)`, artinya kita bisa mencari menggunakan query `a`, `a b`, dan `a b c`  


## Text Indexes
- MongoDB menyediakan text index untuk mendukung pencarian text di tipe data string.  
- Text index tidak hanya bisa digunakan pada field dengan tipe data string, namun juga pada array berisi tipe data string.  
- Text index lebih cepat dibanding menggunakan `$regex`, karena `$regex` akan melakukan pencarian scanning sehingga semakin besar data semakin banyak.  
- Walaupun fitur Text Index bagus, tapi fiturnya tidak secanggih Search Engine, oleh karena itu sangat direkomendasikan menggunakan database khusus Search Engine jika kita butuh membuat fitur pencarian layaknya Search Engine, contohnya database Elasticsearch.
> text index melakukan pencarian perkata seperti fulltext search seperti di Relation Database

```js
// text-index.js
// Create text index
db.products.createIndex({
    name: "text",
    category: "text",
    tags: "text"
}, {
    weights: {
        name: 10,
        category: 5,
        tags: 1
    }
});

// Get index
db.products.getIndexes();

// search.js
// Search products with text "mie"
db.products.find({
    $text: {
        $search: "mie"
    }
});

// Search products with text "mie" OR "laptop"
db.products.find({
    $text: {
        $search: "mie laptop"
    }
});

// Search products with text "mie sedap"
db.products.find({
    $text: {
        $search: "mie sedap"
    }
});

// Search products with text "mie" and NOT "sedap"
db.products.find({
    $text: {
        $search: "mie -sedap"
    }
});


// debug.js
// Debugging query optimization
db.products.find({
    $text: {
        $search: "mie -sedap"
    }
}).explain();
```

### $meta Operator
- Dalam operasi `$text`, `$meta` bisa digunakan untuk mendapatkan text score hasil pencarian
- Ini bermanfaat untuk membantu proses debugging

## Wildcard Indexes
- MongoDB mendukung wildcard index, dimana ini digunakan untuk membuat index terhadap field yang belum diketahui atau field yang sering berubah-ubah.
- Misal contoh kita punya sebuah embedded document dengan tipe field `customFields`, dimana isinya bisa bebas sesuai dengan data yang dimasukkan.
- Agar bisa mendukung proses query yang cepat pada field tersebut, kita bisa menggunakan wildcard index.

```js
// Membuat wildcard index
db.customers.createIndex({
  "customFields.$**": 1
});

// Mengambil daftar indeks yang ada
db.customers.getIndexes();

// Insert banyak pelanggan
db.customers.insertMany([
  {
    _id: "budi",
    full_name: "Budi",
    customFields: {
      hobby: "Gaming",
      university: "Universitas Belum Ada"
    }
  },
  {
    _id: "rully",
    full_name: "Rully",
    customFields: {
      ipk: 3.2,
      university: "Universitas Belum Ada"
    }
  },
  {
    _id: "rudi",
    full_name: "Rudi",
    customFields: {
      motherName: "Tini",
      passion: "Entrepreneur"
    }
  }
]);

// Debug wildcard index
db.customers.find({
  "customFields.passion": "Entrepreneur"
}).explain();

db.customers.find({
  "customFields.ipk": 3.2
}).explain();

db.customers.find({
  "customFields.hobby": "Gaming"
}).explain();
```

## Index Properties
- MongoDB mendukung properties di index.
- Istilah properties di index mungkin agak sedikit membingungkan, sederhananya adalah menambahkan kemampuan tertentu terhadap index yang kita buat.

## TTL Index

- TTL singkatan dari **Time To Live**, yaitu waktu untuk hidup.
- TTL Index digunakan sebagai waktu hidup document di collection, artinya data akan hilang dalam kurun waktu tertentu secara otomatis.
- TTL Index hanya dapat digunakan di field dengan tipe data **Date**.
- Background proses di MongoDB akan secara reguler melakukan penghapusan data secara otomatis.
- Sayangnya, proses background tersebut berjalan setiap **60 detik** sekali.

```js
// Create session collection
db.createCollection("sessions");

// Create TTL index
db.sessions.createIndex(
  { createdAt: 1 },
  { expireAfterSeconds: 10 }
);

// Will expire after 10 seconds, but background job runs every 60 seconds
db.sessions.insertOne({
  _id: 1,
  session: "Session 1",
  createdAt: new Date()
});
```

## Unique Index

- Unique Index memastikan bahwa field-field di index tersebut tidak menyimpan data duplicate.
- Contohnya, di MongoDB, field `_id` secara otomatis merupakan unique index, sehingga kita tidak bisa membuat document dengan field `_id` yang sama.

```js
// Create unique index in email
db.customers.createIndex(
  { email: 1 },
  {
    unique: true,
    sparse: true // <- Index hanya diterapkan pada dokumen yang memiliki field yang di index
  }
);

// update customers set email = ? where _id = ?
db.customers.updateOne(
  { _id: "eko" },
  {
    $set: {
      email: "eko@example.com"
    }
  }
);

// error duplicate email
db.customers.updateOne(
  { _id: "joko" },
  {
    $set: {
      email: "eko@example.com"
    }
  }
);
```

## Case Insensitive
* Secara default, saat kita membuat index, maka data akan disimpan sebagai case sensitive
* Namun, kadang ada kasus kita ingin membuat data yang di index menjadi case insensitive
* Kita bisa mengubah nilai collation strength saat membuat index
```js
// JS case-insensitive.js
// Create unique index in full_name
db.customers.createIndex({
  full_name: 1
}, {
  collation: {
    locale: "en",
    strength: 2
  }
});


// JS debug.js
// not using index
db.customers.find({
  full_name: "Eko Kurniawan Khannedy"
});

// using index
db.customers.find({
  full_name: "EKO KURNIAWAN KHANNEDY"
}).collation({
  locale: "en",
  strength: 2
});
```

## Partial
* Secara default, saat kita membuat jenis query apapun yang menggunakan query ke index, secara otomatis mongodb akan menggunakan index
* Namun kita bisa menambahkan kondisi tertentu agar index hanya digunakan ketika kita menggunakan kriteria tertentu ketika melakukan query
* Fitur ini bernama partial filter
```js
// JS partial-index.js
// create partial index
db.products.createIndex({
  price: 1
}, {
  partialFilterExpression: {
    stock: {
      $gt: 0
    }
  }
});


// JS debug.js
// debug query with partial index
db.products.find({
  price: {
    $gt: 1000
  },
  stock: {
    $gt: 0
  }
}).explain();
```