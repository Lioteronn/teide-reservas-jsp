
jspArray = document.getElementsByClassName("jsp");

function toggleJSP(id) {
    let element = document.getElementById(id);

    for (let i = 0; i < jspArray.length; i++) {
        jspArray[i].style.display = "none";
    }

    element.style.display = "block";
}

function toggleFlightSearch() {
    let flightSearch = document.querySelector(".jsp-flight_search");

    flightSearch.style.display === "none" ? flightSearch.style.display = "block" : flightSearch.style.display = "none";
}