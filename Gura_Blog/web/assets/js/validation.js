/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function checkLoginAccount() {
//            var acc = "";
//            acc = document.getElementById("account").value;
//            if (acc.match("^[0-9a-zA-Z]+$")) {
//                document.getElementById("account").style.borderBottomColor = "black";
//                document.getElementById("checkSubmit").disabled = false;
////                document.getElementById("account").setCustomValidity(null);
//            } else {
//                document.getElementById("account").style.borderBottomColor = "red";
//                document.getElementById("checkSubmit").disabled = true;
////                document.getElementById("account").setCustomValidity("Không có ký tự đặc biệt");
////                location.reload();
//            }
            var input = document.getElementById('account');
            input.oninvalid = function (event) {
                event.target.setCustomValidity('Username should only contain lowercase letters. e.g. john');
            };
            
            
            
        }