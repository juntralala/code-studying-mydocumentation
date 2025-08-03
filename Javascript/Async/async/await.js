/** Await
 * Await digunakan untuk mendapatkan value hasil dari promise
 * Await hanya bisa digunakan dalam Async Fucntion
 */

/**
 * @returns {Promise<JSON>}
 */
function getProduct(){
    return fetch("api/product.json", {
        method: "GET"
    }).then(response => response.json())
}

/**
 * @returns {Promise<string>}
 */
export async function getProductNameAsync(){
    const product = await getProduct()
    return product.name
}

/**
 * @returns {Promise<string>}
 */ 
export function getProductNamePromise(){
    return new Promise(function(resolve, reject){
        getProduct()
            .then(product => resolve(product.name))
            .catch(error => reject(error))
    })
}