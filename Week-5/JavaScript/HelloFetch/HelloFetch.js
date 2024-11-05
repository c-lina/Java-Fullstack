//PokeAPI base URL - making a variable to hold the base URL to reach pokeAPI. This is for cleaner code
const url = "https://pokeapi.co/api/v2/pokemon/";

//use DOM Selection to select all of the elements I plan to fill with data
let pokename = document.getElementById("pokename");
let poketype = document.getElementById("poketype");
let pokenum = document.getElementById("pokenum");
let pokepic = document.getElementById("pokepic");

//when the user clicks the button, execute the fetchData method (using an eventListener)
document.getElementById("btn").onclick = fetchData;

/*

This function will return some pokemon data from PokeAPI 
It will use fetch objects to return a promise object
The promise object will get filled with the data requests, OR it will fail

*/

async function fetchData() {
    //First, we need to gather the user's input from the input box
    let userInput = document.getElementById("userInput").value;
    //.value will extract whatever value is in the input box

    console.log(userInput); //just to see the value

    //Then, we can use the fetch() method to send a GET request to pokeAPI
    //fetch sends GET requests by default BTW
    await fetch(url + userInput) //http://....pokemon/{whatever the user put in}
    .then((response) => response.json()) //extract the body of the http response and turn it into a Javascript object
    .then((data) => renderHTML(data)) //Send the JS data (in the "data" variable) to our renderHTML function below
    .catch((error) => document.getElementById("header").innerText = "Invalid ID! It got away... Try again")
    .finally(setTimeout(() => document.getElementById("header").innerText = "Find a Pokemon:", 2000))

    //setTimeout() lets us define a function to invoke after some amount of milliseconds (2000 millis or 2 seconds)
}

//Hypothetical POST Request

//In any non-GET request. fetch() needs the configuration object
// await fetch(url, {
//     method: "Post",
//     body: JSON.stringify(newPokemonObject)
// })
// .then() //stuff
// .catch() //error handling stuff
// .finally() //stuff that will always run

//This function will take in the JS Pokemon data and render it
function renderHTML(data) {

    //getting all of the pokemon's types in one string
    //for every type found, append it to the "types" variable
    let types = "";
    for(let element of data.types) {
        types += element.type.name + " "
    }

    console.log(data) //just to see the data in the console

    //populate the table with our Pokemon data
    pokename.innerText = data.name
    poketype.innerText = types
    pokenum.innerText = data.id

    pokepic.setAttribute("src", data.sprites.front_shiny)



}