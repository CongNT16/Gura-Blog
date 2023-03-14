/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function delWithSubscribeId(id) {

    let choice = confirm("Xác nhận xoá!");
    if (choice === true) {
        window.location = "SubscribesController?thread=3&idsubscribedel=" + id;
    } else {
        window.location = "SubscribesController?thread=1";
    }

}


