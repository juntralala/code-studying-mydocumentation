/** Export Default
 * Sampai saat ini, kita selalu melakukan export dengan nama, baik itu nama variable, function dan lainnya
 * Ada juga nama fitur yang namanya export default, ini adalah fitur yang digunakan untuk mempermudah untuk
   membuat default data di module, dan membantu JavaScript agar kompatible dengan CommonJS dan AMD module system
*/

// default export tidak boleh lebih dari 1 dalam satu file

/** Cara Export Default
 * export default namaVariable;
 * export default namaFunction;
 * export default namaClass;
 * export default namaVariable = value;
 * export default function(){};
 * export default class {};
*/

/** Cara Import Default
 * import aliasVariable from "./module-default.js";
 * import aliasFunction from "./module-default.js";
 * import aliasClass from "./module-default.js";
 * import {default as aliasVariable} from "./module-default.js";
 * import {default as aliasFunction} from "./module-default.js";
 * import {default as aliasClass} from "./module-default.js";
*/