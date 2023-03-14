/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function delWithCommentId(CommentId) {

    let choice = confirm("Xác nhận xoá!");
    if (choice === true) {
        window.location = "ManageCommentsController?thread=3&idcommentdel=" + CommentId;
    } else {
        window.location = "ManageCommentsController?thread=1";
    }

}


function confirmWithCommentId(CommentId) {

    let choice = confirm("Xác nhận duyệt!");
    if (choice === true) {
        window.location = "ManageCommentsController?thread=4&idcommentconfirm=" + CommentId;
    } else {
        window.location = "ManageCommentsController?thread=1";
    }

}


