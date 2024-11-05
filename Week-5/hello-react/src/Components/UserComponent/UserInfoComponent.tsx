//This component will display user data
//It takes props of UserInterface type, so it only accepts UserInterface objects from a 
//parent

import { useEffect, useState } from "react"
import { UserInterface } from "../../Interfaces/UserInterface"

export const UserInfoComponent:React.FC<UserInterface> = (user:UserInterface) => {

    /*

    Destructuring - accomplished with {}

    Destructuring lets us break up a props object into individual variables
    The name in the curly brace must match the name of the prop attribute you're extracting

    */
   const {userName} = user
   const {firstName} = user
   const {lastName} = user
   const {email} = user

   //So now, we don't have to dig into the user object, we have variables

   //Let's practice useState and useEffect again

   //State object that stores the user profile bio

   const [bio, setBio] = useState<string>("")

   //useEffect to assign a value to the useState bio object

   useEffect(() => {
        
        //Hypothetical GET request, or maybe the bio is already stored in the user info

        setBio("Thanks to useEffect, this info is set to component rendering")

   })

   //Obviously, we didn't have to do all this^ (useState and useEffect)
   //We could have just had a "bio" variable. But we should practice syntax

    return(
        <div>
            <div className="info-container">

                <div className="profile-container">
                    <img className="profile-pic" src="https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg" alt="PROFILE PIC"/>
                    <h4>{userName}</h4>
                </div>

                <div className="content-container">
                    <h5>{firstName} {lastName}</h5>
                <h5>{email}</h5>
                    <p>{bio}</p>
                </div>

            </div>
        </div>
    )
}