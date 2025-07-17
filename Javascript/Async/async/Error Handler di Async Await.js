/** Error Handler di Async Await 
 * Saat kita menggunakan Promise, kita bisa menggunakan catch() ketika terjadi error
 * Bagaimana dengan kasus Async Await?
 * Pada Async Await, kita bisa menggunakan try catch untuk melakukan penganan error
 */


/**
 * @returns {Promise<JSON>}
 */
function getProduct(){
    return fetch("api/produ ct.json", {
        method: "GET"
    }).then(response => response.json())
}

/**
 * @returns {Promise<string>}
 */
export async function getProductNameAsync(){
    try {
        const product = await getProduct()
        return product.name
    } catch (e) {
        throw "Product Not Found"
    } finally{
        // kita bisa menggunakan finally
    }
}

/**
 * @returns {Promise<string>}
 */ 
export function getProductNamePromise(){
    return new Promise(function(resolve, reject){
        getProduct()
            .then(product => resolve(product.name))
            .catch(error => reject("Product Not Found"))
    })
}

