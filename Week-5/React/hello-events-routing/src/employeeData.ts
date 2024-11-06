//This file will hold an array of employee data, which contains objects that we'll map through
//(using lists and keys with the map() function in Employee Container)
export const data = [

    {
        id:1,
        name:"Jesse",
        quote:"The bomb"
    },

    {
        id:2,
        name:"Walter",
        quote:"We need to cook"
    },

    {
        id:3,
        name:"Hank",
        quote:"I love minerals Gomey"
    }

]

//Imagine a user wants to get all employees. They'd probably make a GET request
//But we're just going to hardcode data in a global data file for now

//This is a global file! We can store data that is visible to every component
//Imagine a user logs in and we need save their data for future requests. This is a good choice
    //-get reimbursements by logged in user id 
    //-submitting a new reimbursement will also grab the stored user id 
    //-use the users role to redirect them if they access a component they aren't allowed to