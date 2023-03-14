

'use strict';

function $(selector) {
  return document.querySelector(selector);
}

function find(el, selector) {
  let finded;
  return (finded = el.querySelector(selector)) ? finded : null;
}

function siblings(el) {
  const siblings = [];
  for (let sibling of el.parentNode.children) {
    if (sibling !== el) {
      siblings.push(sibling);
    }
  }
  return siblings;
}



// dropdown menu in the side nav
var slideNavDropdown = $('.sidebar-dropdown');

$('.sidebar .categories').addEventListener('click', function (event) {
  event.preventDefault();

  const item = event.target.closest('.has-dropdown');

  if (! item) {
    return;
  }

  item.classList.toggle('opened');

  siblings(item).forEach(sibling => {
    sibling.classList.remove('opened');
  });

  if (item.classList.contains('opened')) {
    const toOpen = find(item, '.sidebar-dropdown');

    if (toOpen) {
      toOpen.classList.add('active');
    }

    siblings(item).forEach(sibling => {
      const toClose = find(sibling, '.sidebar-dropdown');

      if (toClose) {
        toClose.classList.remove('active');
      }
    });
  } else {
    find(item, '.sidebar-dropdown').classList.toggle('active');
  }
});

$('.sidebar .close-aside').addEventListener('click', function () {
  $(`#${this.dataset.close}`).classList.add('show-sidebar');
  wrapper.classList.remove('margin');
});


document.querySelectorAll('.sidebar ul .sidebar-dropdown > li > a').forEach(item => {
  item.addEventListener('click',(e)=> {
      e.stopPropagation();
  });
});



document.querySelectorAll('.manage-asidetohome').forEach(item => {
  item.addEventListener('click',(e)=> {
      e.stopPropagation();
  });
});