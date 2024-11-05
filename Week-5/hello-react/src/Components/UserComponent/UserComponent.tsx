//This component will gather User info (from a hypothetical HTTP request)
//And use the data to render a user-info component

import { useEffect, useState } from "react"
import { UserInterface } from "../../Interfaces/UserInterface"
import { UserInfoComponent } from "./UserInfoComponent"
 
export const UserComponent:React.FC = () => {
    /*

    Remember state hold values related to the Component that we can pass to Child Components

    We use the useState hook to define state (variable, mutator, and actual hook)

    This time, we set the state to be STRICTLY userInterface type. Enforcing type safety
    */
    const [user, setUser] = useState<UserInterface>({
        firstName: "",
        lastName: "",
        userName: "",
        email: ""
    })

    /*

    useEffect hook here - 

    The useEffect hook is often used to execute some logic when the components renders
    but it can pretty much can be used for any tupe of event (button clicks, etc)

    Assume we send a HTTP request for login, and we saved the user info on the front end
    We can then use that user info and populate the UserComponent

    */

    useEffect(() =>{
        //assume the user logged in and their data got stored on the front endd
        //and then it takes us to this component
        //this useEffect will trigger and populate the state object with the user data
        //(but of course, instead of extracting data from HTTP, we'll just hard code it here)
        setUser({
            firstName: "Reggie",
            lastName: "Sparks",
            userName: "BigReactGuy",
            email:"ILuvReact999@gmail.com"
        })
    }, []) //Empty array means this useEffect runs once the component renders

    //In our TSX, we'll databind some info to render directly
    //But we'll also send the entire user state object to the Child UserInfoComponent

    return(
        <div> 
            <h3>Welcome, {user.userName}</h3>
            <UserInfoComponent{...user}></UserInfoComponent>  
        </div>
        //To send entire state objects as props, you can use "..."
        //This is called the "spread operator"
    )
}