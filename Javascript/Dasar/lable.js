loopi:
for (let i=0 ; i<6 ; i++) {
    loopj:
    for (let j=0 ; j<6 ; j++) {
        if (j == 3) {
            continue loopi
        }
        console.log(`${i}  ${j}`)
    }
}