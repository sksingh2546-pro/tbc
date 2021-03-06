function getUpdateLicence() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);

            Toastify({
                text: "Data Fetched Successfully",
                duration: 3000,
                gravity: "top",
                position: 'right',
                backgroundColor: "#01cf68",
                close: true
            }).showToast();

            var result = JSON.parse(this.responseText);

            for (var i = 0; i < result.totalData.length; i++) {
                document.getElementById("todayStockTable").innerHTML +=
                    "<tr>" +
                    '<td>' + (i + 1) + '</td>' +
                    '<td>' + result.totalData[i].license_code + '</td>' +
                    '<td>' + result.totalData[i].frequency + '</td>' +
                    '<td>' + result.totalData[i].no_of_devices + '</td>' +
                    '<td>' + result.totalData[i].status + '</td>' +
                    '<td>' + result.totalData[i].stage + '</td>' +
                    '<td>' + result.totalData[i].user_name + '</td>' +
                    '<td class="text-center"> <input type="radio" id="radio" onclick="openPopup(this)"></td>'+


                    '</tr>';
            }
        }
    };
    xhttp.open("GET", "http://localhost:9090/getTotalLicencingList", true);
     xhttp.setRequestHeader("Authorization", "Bearer "+localStorage.getItem("token"));
    xhttp.send();
}
