const orang = {
    firstName : "Muhammad",
    lastName  : "Junaidi",
    get fullName() {
        return `${this.firstName} ${this.lastName}`
    },
    set fullName(value) {
        const array = value.split(" ")
        this.firstName = array[0]
        this.lastName = array[1]
    }
}

console.log(orang.fullName)

orang.fullName = "Saipul Bahri"
console.log(orang.fullName)

