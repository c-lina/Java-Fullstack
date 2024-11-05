//first, we'll make a basic named function
//we'll call a function before it's declared due to something called HOISTING

helloWorld()

function helloWorld() {
    console.log("hola mundo")
}

//here's a anonymous function - it has no name, but we can assign them to values
let anon = function(var1) {
    console.log("Hi, I'm an anonymous function stored in a variable");
    console.log("My variable is " + var1);
}

anon(42)
//NOTE: anonymous functions are not hoisted, we can't successfully call anon() before declaration

//Arrow functions are just like lambdas in Java (value) => (code)
let arrowFunc = (var1, var2) => {
    //let's use this function to test ===
    console.log(var1 + " compared to " + var2);
    console.log(var1 === var2)
}

arrowFunc(null, false); //null is falsy, but a different data type than false
arrowFunc(false, false); //false is false, same data type

console.log(null == false);
console.log(null === false);
console.log(null == undefined); //null is only loosely equal to undefined and nothing else

//callback functions - functions that get passed in as params to other functions
function f1(x) {
    console.log("Inside functions 1")
    console.log("The value passed in from function 2 is: " + x)
    console.log("End of function 1")
}

function f2(x, someFunction) {
    console.log("Inside function 2")
    someFunction(x)
    console.log("End of function 2")
}

//TODO: call f2
f2(1000, f1)

console.log("========================(Scopes)")

//anything that is globally scoped can be accessed anywhere in the script
console.log(a);

//This^ is another example of HOISTING - all functions and vars are hoisted
var a = 5 //a will be undefined because we called it before it was initialized


//console.log(b)
//let b = 5;
//since b is a let, it is not hoisted so it will throw an error because it is ILLEGAL
//this is one of the reasons we use let instead of var now - we don't want to access variables before it is initialized

console.log("================================(Local Scope (method vs block scope))")

//block scope-------------------------/

//any variable within a block that ISN'T a function
if(true) {
    var c = "I am a var in a block - block scope!"
    console.log(c)
    let d = "I am a let in a block - block scope!"
    console.log(d)
}

console.log(c) //vars are globally scoped so they're visible OUTSIDE their block scope
//console.log(d) //lets and consts are NOT VISIBLE outside their block scope

//function scope-------------------------/
function scopeTester() {
    var e = "I am a var in a function - function scoped!"
    console.log(e)
}

scopeTester()
// console.log(e) //FUNCTIONS are the only block that confine vars to their scope
/*

The main difference between block and function scope is:
    -vars are NOT visible outside the function they're declared in
    -BUT... vars are visible outside any non-function block they're declared in

    -lets and consts are only visible within their block, period

    Since we really only use let and const these days, we don't have to worry about these quirks
    (But we should still know them for QC)
*/