/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const date = new Date();
const monthArr = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
const dateCurr = document.querySelector('#dateCurr');
const monthCurr = document.querySelector('#monthCurr');
const yearCurr = document.querySelector('#yearCurr');

dateCurr.textContent = date.getDate();
monthCurr.textContent = monthArr[date.getMonth()];
yearCurr.textContent = date.getFullYear();
