/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function delWithTagId(TagId) {

    let choice = confirm("Xác nhận xoá!");
    if (choice === true) {
        window.location = "ManageTagsController?thread=3&idtagdel=" + TagId;
    } else {
        window.location = "ManageTagsController?thread=1";
    }

}

function editWithTagId(TagId) {

    let choice = confirm("Xác nhận chỉnh sửa!");
    if (choice === true) {
        window.location = "ManageTagsController?thread=4&idtagedit=" + TagId;
    } else {
        window.location = "ManageTagsController?thread=1";
    }

}

