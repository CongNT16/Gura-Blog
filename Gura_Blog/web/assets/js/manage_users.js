/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function delWithUsercId(UserId) {

    let choice = confirm("Xác nhận xoá!");
    if (choice === true) {
        window.location = "ManageUsersController?thread=3&iduserdel=" + UserId;
    } else {
        window.location = "ManageUsersController?thread=1";
    }

}

function editWithUserId(UserId) {

    let choice = confirm("Xác nhận chỉnh sửa!");
    if (choice === true) {
        window.location = "ManageUsersController?thread=4&iduseredit=" + UserId;
    } else {
        window.location = "ManageUsersController?thread=1";
    }

}

