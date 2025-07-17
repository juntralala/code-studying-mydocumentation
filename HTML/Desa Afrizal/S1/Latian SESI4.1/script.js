function saklarRuangKeluarga (action,values){
    let lrk1=document.getElementById("lrk1")
    let lrk2=document.getElementById("lrk2")
    let lrk3=document.getElementById("lrk3")

    if (localStorage.getItem("lrk1")) {} else {
        localStorage.setItem("lrk1",0)
    }

    if (localStorage.getItem("lrk2")) {} else {
        localStorage.setItem("lrk2",0)
    }

    if (localStorage.getItem("lrk3")) {} else {
        localStorage.setItem("lrk3",0)
    }

    if ((values==0)-(values==1)) {
        if (localStorage.getItem("lrk1")==0) {
            lrk1.src="assets/images/on.gif"
            localStorage.setItem("lrk1",1)
        } else {
            lrk1.src="assets/images/off.gif"
            localStorage.setItem("lrk1",0)
        }
    }

    if ((values==0)-(values==2)) {
        if (localStorage.getItem("lrk2")==0) {
            lrk2.src="assets/images/on.gif"
            localStorage.setItem("lrk2",1)
        } else {
            lrk2.src="assets/images/off.gif"
            localStorage.setItem("lrk2",0)
        }
    }

    if ((values==0)-(values==3)) {
        if (localStorage.getItem("lrk3")==0) {
            lrk3.src="assets/images/on.gif"
            localStorage.setItem("lrk3",1)
        } else {
            lrk3.src="assets/images/off.gif"
            localStorage.setItem("lrk3",0)
        }
    }
}

function saklarRuangMakan (action,values){
    let lrm=document.getElementById("lrm");

    if (localStorage.getItem("lrm")) {} else {
        localStorage.setItem("lrm",0);
    }

    if (localStorage.getItem("lrm")==0){
        lrm.src="assets/images/on.gif"
        localStorage.setItem("lrm",1);
    } else {
        lrm.src="assets/images/off.gif"
        localStorage.setItem("lrm",0);
    }
}

function saklarRuangTidur (action,values) {
    lrt1 = document.getElementById("lrt1")
    lrt2 = document.getElementById("lrt2")

    if (localStorage.getItem("lrt1")) {} else {
        localStorage.setItem("lrt1",0)
    }

    if (localStorage.getItem("lrt2")) {} else {
        localStorage.setItem("lrt2",0)
    }
    
    if ((values==1)-(values==0)) {
        if (localStorage.getItem("lrt1")==0) {
            lrt1.src="assets/images/on.gif"
            localStorage.setItem("lrt1",1);
        } else {
            lrt1.src="assets/images/off.gif";
            localStorage.setItem("lrt1",0);
        }
    } 

    if ((values==2)-(values==0)) {
        if (localStorage.getItem("lrt2")==0) {
            lrt2.src="assets/images/on.gif";
            localStorage.setItem("lrt2",1);
        } else {
            lrt2.src="assets/images/off.gif"
            localStorage.setItem("lrt2",0)
        }
    } 
}

function saklarRuangTamu (action,values) {
    let lrTamu1 = document.getElementById('lrTamu1')
    let lrTamu2 = document.getElementById('lrTamu2')
    let lrTamu3 = document.getElementById('lrTamu3')
    let lrTamu4 = document.getElementById('lrTamu4')


    if (localStorage.getItem("lrTamu1")) {} else {
        localStorage.setItem("lrTamu1",0)
    }
    if (localStorage.getItem("lrTamu2")) {} else {
        localStorage.setItem("lrTamu2",0)
    }
    if (localStorage.getItem("lrTamu3")) {} else {
        localStorage.setItem("lrTamu3",0)
    }
    if (localStorage.getItem("lrTamu4")) {} else {
        localStorage.setItem("lrTamu4",0)
    }

    if ((values==0)-(values==1)) {
        if (localStorage.getItem("lrTamu1")==0) {
            lrTamu1.src="assets/images/on.gif"
            localStorage.setItem("lrTamu1",1)
        } else {
            lrTamu1.src="assets/images/off.gif"
            localStorage.setItem("lrTamu1",0)
        }
    }

    if ((values==0)-(values==2)) {
        if (localStorage.getItem("lrTamu2")==0) {
            lrTamu2.src="assets/images/on.gif"
            localStorage.setItem("lrTamu2",1)
        } else {
            lrTamu2.src="assets/images/off.gif"
            localStorage.setItem("lrTamu2",0)
        }
    }

    if ((values==0)-(values==3)) {
        if (localStorage.getItem("lrTamu3")==0) {
            lrTamu3.src="assets/images/on.gif"
            localStorage.setItem("lrTamu3",1)
        } else {
            lrTamu3.src="assets/images/off.gif"
            localStorage.setItem("lrTamu3",0)
        }
    }

    if ((values==0)-(values==4)) {
        if (localStorage.getItem("lrTamu4")==0) {
            lrTamu4.src="assets/images/on.gif"
            localStorage.setItem("lrTamu4",1)
        } else {
            lrTamu4.src="assets/images/off.gif"
            localStorage.setItem("lrTamu4",0)
        }
    }
}
