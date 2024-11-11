export const store:any = {
    //Let's store loggedInUser info (filled in after successful login)
    loggedInUser:{
        userId:0,
        firstName:"",
        lastName:"",
        username:"",
        role:""
    }, //We could have modeled this after a UserInterface, but I didn't

    //Think about your requirements when it comes to storing global data
    //you only NEED to globally store data you intend to use in multiple components
    baseURL: "http://localhost:7878"
}