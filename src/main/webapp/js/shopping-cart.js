
function bookFlight(id) {
    fetch('BookFlightServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: 'id=' + id
    }).then(function (response) {
        return response.text();
    }).then(function (response) {
        alert(response);
        location.reload();
    }).catch(error => {
        alert(error);
    });
}