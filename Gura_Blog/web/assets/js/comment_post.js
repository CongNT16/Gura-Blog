/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function delWithCommentPostId(CommentId, PostId) {

    let choice = confirm("Xác nhận xoá!");
    if (choice === true) {
        window.location = "EditCommentPostController?thread=3&idcommentdel=" + CommentId + "&postid=" + PostId;
    } else {
        window.location = "PostController?postid=" + PostId;
    }

}

function editWithCommentPostId(CommentId, PostId) {

    var editdetail;
    editdetail = prompt("Edit comment ");
    if (editdetail === null || editdetail === "") {
        window.location = "PostController?postid=" + PostId;
    } else {
        let choice = confirm("Xác nhận chỉnh sửa!");
        if (choice === true) {

            window.location = "EditCommentPostController?thread=4&idcommentedit=" + CommentId + "&postid=" + PostId + "&editdetail=" + editdetail;

        } else {
            window.location = "PostController?postid=" + PostId;
        }
    }

}

