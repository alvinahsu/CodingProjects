let i = 0;
let txt = 'Welcome!';
let speed = 150;

/* Function "for Hello, World!"" opening animation */
function typeWriter() {
  if (i < txt.length) {
    document.getElementById("Hello").innerHTML += txt.charAt(i);
    i++;
    setTimeout(typeWriter, speed);
  }
}

/* Function to determine whether to open up menu or not */
function openMenu(){
  let c = document.getElementById("nrt");
  let menu = document.getElementById('pop-menu');
  c.classList.toggle('opened');
  c.setAttribute('aria-expanded', c.classList.contains('opened'));
  if (c.classList.contains('opened')) {
      document.getElementById('menu').innerHTML = "CLOSE";
      menu.style.top = "0";
      document.body.style.overflow = "hidden";
      document.getElementById("a-education").style.zIndex = "-1";
      document.getElementById('resume').style.zIndex = "-1";
      document.getElementById('blog').style.zIndex = "-1";
  }
  else {
      document.getElementById('menu').innerHTML = "MENU";
      menu.style.top = "-100vh";
      document.body.style.overflow = 'visible';
      setTimeout(appear, 700)
  }
}

/* Function that scrolls to top with smooth animation */
const scrollToTop = function() {
    const c = document.documentElement.scrollTop || document.body.scrollTop;
    if (c > 0) {
      window.requestAnimationFrame(scrollToTop);
      window.scrollTo(0, c - c / 8);
    }
};

/* Make elements with underline have animation again */
function appear(){
  document.getElementById('resume').style.zIndex = "0";
  document.getElementById('blog').style.zIndex = "0"
}


function loadFadeOutEffect() {
  let fadeTarget = document.getElementById("loader-wrap");
  let fadeTarget2 = document.getElementById("loader-inside"); 
  fadeTarget.style.opacity = '0';
  fadeTarget2.style.opacity = '0';
  fadeTarget.addEventListener("transitionend", function(){
    fadeTarget.style.top = "-100vh";
  })
  setTimeout(typeWriter, 200);
}

window.onload = loadFadeOutEffect;

/* Function that brings reload to top */
/*
window.onbeforeunload = setTimeout(function () {
  window.scrollTo(0, 0);
}, 100);
*/
