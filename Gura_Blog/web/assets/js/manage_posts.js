/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function delWithPostId(postID) {

    let choice = confirm("Xác nhận xoá!");
    if (choice === true) {
        window.location = "ManagePostsController?thread=3&idpostdel=" + postID;
    } else {
        window.location = "ManagePostsController?thread=1";
    }

}

function editWithPostId(postID) {

    let choice = confirm("Xác nhận chỉnh sửa!");
    if (choice === true) {
        window.location = "ManagePostsController?thread=4&idpostedit=" + postID;
    } else {
        window.location = "ManagePostsController?thread=1";
    }

}

