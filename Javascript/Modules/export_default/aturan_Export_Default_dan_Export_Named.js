/** Default Export dan Named Export
 * Dalam satu module, kita bisa menggabungkan export default dan export named
 * yang tidak boleh adalah dalam satu module membuat lebih dari satu export default
 * Cara import default dan named export secara bersamaan dengan menggunakan perintah :
     
    import defaultAlias, {named1, named2, named3} from "./module.js"
    import {defaulr as defaultAlias, named1, named2, named3} from "./module.js"

*/