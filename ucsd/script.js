function sayHi(){
    console.log("hi");
}

const swup = new Swup();

function openMenu() {
    // Get the checkbox
    let checkBox = document.getElementById("check");
    // Get the output text
    let listBox = document.getElementById("list");
    // If the checkbox is checked, display the output text
    if (checkBox.checked == true){
      console.log("yes");
      listBox.style.left = 0;
    } else {
      listBox.style.left = '-100%';
    }
  }
