function addBarcode(){

        var frequency=document.getElementById("frequency").value;
        var devices = document.getElementById("devices").value;

        if(frequency!=""&&devices!=""){
         var temp = {
                "frequency":frequency,
                "no_of_devices":devices,
                "user_name":localStorage.getItem("user_id"),
                "user_type":localStorage.getItem("user_type",Admin)


            }

            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    console.log(this.responseText);
                    if(this.responseText == "Successful" ){
                        Toastify({
                            text: "Devices ADDED ",
                            duration: 3000,
                            gravity: "top",
                            position: 'center',
                            backgroundColor: "#01cf68",
                            close : true
                          }).showToast();
                        document.getElementById("frequency").value = "";
                        document.getElementById("devices").value = "";


                      }
                      else{
                        Toastify({
                           text: "Server ERROR !! ",
                           duration: 3000,
                           gravity: "top",
                           position: 'center',
                           backgroundColor: "#ff0000",
                           close : true
                        }).showToast();
                      }
                 }
            };
            xhttp.open("POST","http://localhost:9090/insertUserCredentials", true);
            xhttp.setRequestHeader("Content-type", "application/json");
            XHR.setRequestHeader("Authorization", "Bearer "+localStorage.getItem("token"));
            xhttp.send(JSON.stringify(temp));

        }else{
        Toastify({
                                   text: "Please Enter Data ",
                                   duration: 3000,
                                   gravity: "top",
                                   position: 'center',
                                   backgroundColor: "#ff0000",
                                   close : true
                                }).showToast();
        }
console.log("working");
}