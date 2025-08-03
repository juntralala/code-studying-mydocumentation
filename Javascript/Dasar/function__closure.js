function createAdder(param) {
    const owner = "UJUN"
    function add(value) {
        console.log(owner)
        return param + value
    }
    return add
}

const addTwo = createAdder(2)

console.info(addTwo(10))
console.info(addTwo(20))
console.info(addTwo(30))