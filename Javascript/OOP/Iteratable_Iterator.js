/** Iterable Dan Iterator
 * Salah satu fitur terbaru di ES6 alalah iterable
 * Iterable adalah spescial object yang memiliki standarisasi
 * Dengan mengikuti standarisasi Iterable, secara otomatis kita bisa melakukan iterasi terhadap data
   tersebut dengan menggunakan perulangan for_of
 * contoh yang sudah mengikuti standarisasi Iterable adalah string, Array, Object, dll
*/

class CounterIteratorResult{
    constructor(value, done){
        this.value = value
        this.done = done
    }
}

class CounterIterator{
    constructor(value, max){
        this.value = value
        this.max = max
    }

    next() {
        try{
            if(this.value > this.max){
                return new CounterIteratorResult(this.value, true)
            }else {
                return new CounterIteratorResult(this.value, false)
            }
        } finally {
            this.value++
        }
    }
}

class Counter{
    constructor(value, max){
        this.value = value
        this.max = max
    }

    [Symbol.iterator]() {
        return new CounterIterator(this.value, this.max)
    }
}

const counter = new Counter(1, 10)
for(let value of counter){
    console.log(value)
}

// <<==========================================================>>
console.log("\n\nContoh Buat sendiri\n\n")

class PersonIteratorResult{
    constructor(done, value) {
        this.done = done
        this.value = value
    }
}

class PersonIterator{
    constructor(value){
        this.value = value
    }

    next() {
        if(this.value.name !== null) {
            try {
                return new PersonIteratorResult(false, this.value.name) 
            } finally {
                this.value.name = null
            }
        } else if(this.value.age !== null){
            try {
                return new PersonIteratorResult(false, this.value.age)
            } finally {
                this.value.age = null
            }
        }else if(this.value.address !== null){
            try{
                return new PersonIteratorResult(true, this.value.address)
            } finally {
                this.value.address = null
            }
        }
    }
}

class Person {
    constructor(name, age, address){
        this.name = name
        this.age = age
        this.address = address
    }

    [Symbol.iterator]() {
        return new PersonIterator(this)
    }
}

const ujun = new Person("UJUN", 19, "Handil Labuan Amas")
for(let value of ujun){
    console.log(value)
}