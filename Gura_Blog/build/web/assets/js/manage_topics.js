/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function delWithTopicId(TopicId) {

    let choice = confirm("Xác nhận xoá!");
    if (choice === true) {
        window.location = "ManageTopicsController?thread=3&idtopicdel=" + TopicId;
    } else {
        window.location = "ManageTopicsController?thread=1";
    }

}

function editWithTopicId(TopicId) {

    let choice = confirm("Xác nhận chỉnh sửa!");
    if (choice === true) {
        window.location = "ManageTopicsController?thread=4&idtopicedit=" + TopicId;
    } else {
        window.location = "ManageTopicsController?thread=1";
    }

}

