navigator.geolocation.getCurrentPosition(success, failed);

/** @param {GeolocationPosition} pos */
function success(pos) {
    console.log(pos);
    document.getElementById("accuracy").textContent = pos.coords.accuracy + " Meter";
    document.getElementById("longitude").textContent = pos.coords.longitude;
    document.getElementById("latitude").textContent = pos.coords.longitude;
}

function failed() {
    console.error("Gagal mendapatkan lokasi");
}