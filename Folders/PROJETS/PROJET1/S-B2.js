let placeholder=document.getElementById("place")
let price=document.getElementById("prix");
price.addEventListener("click",event1);
price.addEventListener("blur",event1);
price.addEventListener("dbclick",event1);
price.addEventListener("focus",event1);
price.addEventListener("focusout",event1);
price.oninput = function() {event1()};
function event1() {
  let a=price.value
  placeholder.placeholder=a*200
  console.log(a)
}