import {URL} from 'url'

// url adalah standard library untuk berkerja dengan URL
const jun = new URL('https://github.com/juntralala?belajar=nodeJS')  

console.info(jun.toString())
console.info(jun.protocol)
console.info(jun.host)
console.info(jun.pathname)
console.info(jun.searchParams)

jun.host = 'www.linkedin.com'
jun.pathname = '/in/ujun-muhammadjunaidi'
jun.searchParams.append('name', 'ujun')

console.info(`modified url : ${jun.toString()}`)
console.info(jun.searchParams)