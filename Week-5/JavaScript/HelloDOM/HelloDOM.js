//I want to access the div that has id pf "div1" - DOM SELECTION
let div1 = document.getElementById("div1");

console.log(div1);

//We can also select multiple element by their classname
//This stores them in an HTMLCollection, which is like an Array
let divCollection = document.getElementsByClassName("divClass");

console.log(divCollection)
console.log(divCollection[0])

//We cab set attributes of elements we've DOM selected
//This is called DOM MANIPULATION -> CHANGING ELEMENTS AFTER SELECTING THEM

div1.setAttribute("style", "background-color:lightblue")

/*

Inline  Styling isn't great practice...so why do this?

One possible use case: changing the color of something based on user interactions with the webpage
(green for success? red for failure?)

Maybe there's an header that says "please log in"
    -If the user logs in sucessfully, the header can turn green and say "welcome!"
    -If the user fails to log in, the header can turn red and say "login failed!"
*/


let button1 = document.getElementById("btn1"); 
button1.addEventListener("click", buttonFunction);

function buttonFunction() {
    alert("YOU CLICKED A BUTTON! Great work.");
}

let button2 = document.getElementById("btn2"); //The shorter way
button2.onclick = btn2function

//function to give p1 some text content
function btn2function() {
    p1.textContent = "Now I have content! Thanks"
}

let p1 = document.getElementById("p1");

//some mouseOver/mouseLeave examples for our h2

//need to give DOM select, add event listener, define functions
let header = document.getElementById("header");
header.onmouseover = mouseOverFunction

function mouseOverFunction() {
    header.textContent = "Don't touch me!!!!"
}

header.onmouseleave = mouseLeaveFunction

function mouseLeaveFunction() {
    header.textContent = "Wait come back :("
}