console.log("====================================(Printing/Declaring Variables)")

//JS is LOOSELY TYPED, so I can declare variables without declaring the datatype
let a = 100
a = true
a = null
a = "Now I am a String"

//JavaScript will assign variables to be var by default
b = "I'm a var!"
let b2 = "I am a let! More modern version of var. We typically use these"
const b3 = "I am a const! My name won't change"

//array just for fun -  we can use any datatypes we want!
let arr = [4, "some string", true, {objectVal1:5, objectVal2:"something"}, null]

//.push() will add elements in the array and .pop() will remove the last element - kinda like queues
arr.push("hello there i'm a new value")
//TODO: we can access values by index just like in Java
console.log(arr[3])

console.log("string" / 5) //NaN
console.log(5/0); //"Infinity", which is cool

console.log("==============================(Testing Type Coercion)")

//Let's say what JS declares as the data type for these variables

let test1 = "5" * 5
console.log("String times number is: " + test1 + "\n" + typeof test1 + "\n")
//number - JS assumes we're doing math, since we're using multiplication with the * operator

let test2 = "5" + 5
console.log("String plus number is: " + test2 + "\n" + typeof test2 + "\n")
//string - JS assumes we're using String concatenating, since we're using the + operator

//If we did 5 + "5", it would be the same outcome - order doesn't matter for 2 variables

//Now let's see the + operator with more than 2 variables

let test3 = 5 + 5 + "5"
console.log("number plus number plus String is " + test3 + "\n" + typeof test3 + "\n")

let test4 = "5" + 5 + 5
console.log("String plus number plus number is " + test4 + "\n" + typeof test4 + "\n")
//stirng 555 - JS does "5" + 5 = 55...THEN does "55" + 5 = "555"

console.log("===============================(Truthy/Falsy Values)")

//I want to write a function that compares two values to demonstrate truthy/falsy
//We'll be comparing some value to the booleans true or false
function testTrueFalse(var1, var2) {
    console.log("~~~~")
    console.log(var1 + " compared to " + var2)
    console.log(var1 == var2)
    console.log("~~~~")
}

testTrueFalse(0, false) //true! 0 == false
testTrueFalse(1, true) //true! non-zero number == true
testTrueFalse(" ", false) //true! " " == false
testTrueFalse(2, true) //false

//while any non-zero number is truthy, the boolean true evaluates to the number 1
//so comparing any number besides 1 to the boolean true will return false

if(2) {
    console.log("any non-zero number is truthy!")
}