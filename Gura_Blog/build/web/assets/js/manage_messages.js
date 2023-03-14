/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function delWithMessageId(MessageId) {

    let choice = confirm("Xác nhận xoá!");
    if (choice === true) {
        window.location = "ManageMessagesController?thread=3&idmessagedel=" + MessageId;
    } else {
        window.location = "ManageMessagesController?thread=1";
    }

}


