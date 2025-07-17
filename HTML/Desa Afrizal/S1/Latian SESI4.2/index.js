
let rKeluargaLampu1 = document.getElementById("rKeluargaLampu1")
let rKeluargaLampu2 = document.getElementById("rKeluargaLampu2")
let rKeluargaLampu3 = document.getElementById("rKeluargaLampu3")
let rMakanLampu1 = document.getElementById("rMakanLampu1")
let rTidurLampu1 = document.getElementById("rTidurLampu1")
let rTidurLampu2 = document.getElementById("rTidurLampu2")
let rTamuLampu1 = document.getElementById("rTamuLampu1")
let rTamuLampu2 = document.getElementById("rTamuLampu2")
let rTamuLampu3 = document.getElementById("rTamuLampu3")
let rTamuLampu4 = document.getElementById("rTamuLampu4")

const hidupMati = () => {
    if (localStorage.getItem("rKeluargaLampu1")==1) {
        rKeluargaLampu1.src="./assets/images/on.gif"
    } else {
        rKeluargaLampu1.src="./assets/images/off.gif"
    }
    if (localStorage.getItem("rKeluargaLampu2")==1) {
        rKeluargaLampu2.src="./assets/images/on.gif"
    } else {
        rKeluargaLampu2.src="./assets/images/off.gif"
    }
    if (localStorage.getItem("rKeluargaLampu3")==1) {
        rKeluargaLampu3.src="./assets/images/on.gif"
    } else {
        rKeluargaLampu3.src="./assets/images/off.gif"
    }
    if (localStorage.getItem("rMakanLampu1")==1) {
        rMakanLampu1.src="./assets/images/on.gif"
    } else {
        rMakanLampu1.src="./assets/images/off.gif"
    }
    if (localStorage.getItem("rTidurLampu1")==1) {
        rTidurLampu1.src="./assets/images/on.gif"
    } else {
        rTidurLampu1.src="./assets/images/off.gif"
    }
    if (localStorage.getItem("rTidurLampu2")==1) {
        rTidurLampu2.src="./assets/images/on.gif"
    } else {
        rTidurLampu2.src="./assets/images/off.gif"
    }
    if (localStorage.getItem("rTamuLampu1")==1) {
        rTamuLampu1.src="./assets/images/on.gif"
    } else {
        rTamuLampu1.src="./assets/images/off.gif"
    }
    if (localStorage.getItem("rTamuLampu2")==1) {
        rTamuLampu2.src="./assets/images/on.gif"
    } else {
        rTamuLampu2.src="./assets/images/off.gif"
    }
    if (localStorage.getItem("rTamuLampu3")==1) {
        rTamuLampu3.src="./assets/images/on.gif"
    } else {
        rTamuLampu3.src="./assets/images/off.gif"
    }
    if (localStorage.getItem("rTamuLampu4")==1) {
        rTamuLampu4.src="./assets/images/on.gif"
    } else {
        rTamuLampu4.src="./assets/images/off.gif"
    }
}

function saklar(buttonRuang,no) {
    if (buttonRuang=="bRKeluarga") {
        if (no==1 || no==0) {
            if (localStorage.getItem("rKeluargaLampu1")==1) {
                localStorage.setItem("rKeluargaLampu1",0)
            } else {
                localStorage.setItem('rKeluargaLampu1',1)
            }
        }
        if (no==2 || no==0) {
            if (localStorage.getItem("rKeluargaLampu2")==1) {
                localStorage.setItem("rKeluargaLampu2",0)
            } else {
                localStorage.setItem('rKeluargaLampu2',1)
            }
        }
        if (no==3 || no==0) {
            if (localStorage.getItem("rKeluargaLampu3")==1) {
                localStorage.setItem("rKeluargaLampu3",0)
            } else {
                localStorage.setItem('rKeluargaLampu3',1)
            }
        }
    }
    if (buttonRuang=="bRMakan") {
        if (no==1) {
            if (localStorage.getItem("rMakanLampu1")==1) {
                localStorage.setItem("rMakanLampu1",0)
            } else {
                localStorage.setItem('rMakanLampu1',1)
            }
        }
    }
    if (buttonRuang=="bRTidur") {
        if (no==1 || no==0) {
            if (localStorage.getItem("rTidurLampu1")==1) {
                localStorage.setItem("rTidurLampu1",0)
            } else {
                localStorage.setItem('rTidurLampu1',1)
            }
        }
        if (no==2 || no==0) {
            if (localStorage.getItem("rTidurLampu2")==1) {
                localStorage.setItem("rTidurLampu2",0)
            } else {
                localStorage.setItem('rTidurLampu2',1)
            }
        }
    }
    if (buttonRuang=="bRTamu") {
        if (no==1 || no==0) {
            if (localStorage.getItem("rTamuLampu1")==1) {
                localStorage.setItem("rTamuLampu1",0)
            } else {
                localStorage.setItem('rTamuLampu1',1)
            }
        }
        if (no==2 || no==0) {
            if (localStorage.getItem("rTamuLampu2")==1) {
                localStorage.setItem("rTamuLampu2",0)
            } else {
                localStorage.setItem('rTamuLampu2',1)
            }
        }
        if (no==3 || no==0) {
            if (localStorage.getItem("rTamuLampu3")==1) {
                localStorage.setItem("rTamuLampu3",0)
            } else {
                localStorage.setItem('rTamuLampu3',1)
            }
        }
        if (no==4 || no==0) {
            if (localStorage.getItem("rTamuLampu4")==1) {
                localStorage.setItem("rTamuLampu4",0)
            } else {
                localStorage.setItem('rTamuLampu4',1)
            }
        }
    }

hidupMati()

}

hidupMati()