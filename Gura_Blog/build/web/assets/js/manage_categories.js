/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function delWithCategoryId(CategoryId) {

    let choice = confirm("Xác nhận xoá!");
    if (choice === true) {
        window.location = "ManageCategoriesController?thread=3&idcategorydel=" + CategoryId;
    } else {
        window.location = "ManagePostsController?thread=1";
    }

}

function editWithCategoryId(CategoryId) {

    let choice = confirm("Xác nhận chỉnh sửa!");
    if (choice === true) {
        window.location = "ManageCategoriesController?thread=4&idcategoryedit=" + CategoryId;
    } else {
        window.location = "ManagePostsController?thread=1";
    }

}

