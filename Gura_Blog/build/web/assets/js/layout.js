/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//'use strict';
//
//// navbar variables
//const nav = document.querySelector('.mobile-nav');
//const navMenuBtn = document.querySelector('.nav-menu-btn');
//const navCloseBtn = document.querySelector('.nav-close-btn');
//
//
//// navToggle function
//const navToggleFunc = function () { nav.classList.toggle('active'); };
//
//navMenuBtn.addEventListener('click', navToggleFunc);
//navCloseBtn.addEventListener('click', navToggleFunc);
//
//
//
//// theme toggle variables
//const themeBtn = document.querySelectorAll('.theme-btn');
//
//
//for (let i = 0; i < themeBtn.length; i++) {
//
//  themeBtn[i].addEventListener('click', function () {
//
//    // toggle `light-theme` & `dark-theme` class from `body`
//    // when clicked `theme-btn`
//    document.body.classList.toggle('light-theme');
//    document.body.classList.toggle('dark-theme');
//
//    for (let i = 0; i < themeBtn.length; i++) {
//
//      // When the `theme-btn` is clicked,
//      // it toggles classes between `light` & `dark` for all `theme-btn`.
//      themeBtn[i].classList.toggle('light');
//      themeBtn[i].classList.toggle('dark');
//
//    }
//
//  });
//
//}

'use strict';

// navbar variables
const nav = document.querySelector('.mobile-nav');
const navMenuBtn = document.querySelector('.nav-menu-btn');
const navCloseBtn = document.querySelector('.nav-close-btn');


// navToggle function
const navToggleFunc = function () { nav.classList.toggle('active'); };

navMenuBtn.addEventListener('click', navToggleFunc);
navCloseBtn.addEventListener('click', navToggleFunc);

const themeBtn = document.querySelectorAll('.theme-btn');


if ((localStorage.getItem('theme') === 'true' || localStorage.getItem('theme') === '')
  && document.body.classList.contains('dark-theme')) {
  document.body.classList.toggle('light-theme');
  document.body.classList.toggle('dark-theme');
  themeBtn.forEach(item => {
    item.classList.toggle('light');
    item.classList.toggle('dark');
  });
} else if (localStorage.getItem('theme') === 'false' && document.body.classList.contains('light-theme')) {
  console.log('test');
  document.body.classList.toggle('light-theme');
  document.body.classList.toggle('dark-theme');
  themeBtn.forEach(item => {
    item.classList.toggle('light');
    item.classList.toggle('dark');
  });
}


// theme toggle variables


for (let i = 0; i < themeBtn.length; i++) {

  themeBtn[i].addEventListener('click', function () {

    // toggle `light-theme` & `dark-theme` class from `body`
    // when clicked `theme-btn`
    document.body.classList.toggle('light-theme');
    document.body.classList.toggle('dark-theme');

    for (let i = 0; i < themeBtn.length; i++) {

      // When the `theme-btn` is clicked,
      // it toggles classes between `light` & `dark` for all `theme-btn`.
      themeBtn[i].classList.toggle('light');
      themeBtn[i].classList.toggle('dark');

    }

    if (themeBtn[i].classList.contains('light')) {
      localStorage.setItem('theme', 'true');
    } else {
      localStorage.setItem('theme', 'false');
    }

  });

}