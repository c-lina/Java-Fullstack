import { Button, Container, Form } from "react-bootstrap"
import 'bootstrap/dist/css/bootstrap.css';
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import axios from "axios";

export const RegisterUser:React.FC = () => {
    const navigate = useNavigate()

    //a state object that holds username and password
    const [user, setUser] = useState({
        username: "",
        password: ""
    })

    //function that stores user input
    const storeValues = (input:any) => {
        const name = input.target.name //the name of the input box that has changed
        const value = input.target.value //the value of the input box

        //input is the entire event (which got passed in as an argument)
        //target is the specific input box that triggered the event
        //name/value is the name/value of the input box

        //annoying syntax - we need to send the entire user object to make a change to one field
        //"Take whatever input was changed, and set the matching field in user to the value
        //in the input"

        //square brackets takes the name fo the input box and changes the according value
        //without it, it creates a new field called name
        setUser((user) => ({...user, [name]:value}))

        //Remember the spread operator (...) lets us access the values of the object individually
        // console.log(user)
        // console.log("setUser: ", setUser)
    }

    //TODO: function that sends username/password to the backend
    const register = async () => {
        
        //TODO: make sure the username/password is present

        //POST REQUEST - send the new user into the backend
        const reponse = await axios.post("http://localhost:7777/users", user)
        .then(()=>{alert("success!")})
        .catch((error)=>{alert("Failed! " + error.message)})
    }

    return(
        //what's my and mx? this is margin for y and x axis
        //we set my-5 so that we have a decement amount of space away from the top 
        //of the page
        //mx-auto centers the content horizontally
        <Container className="my-auto mx-auto">
            <div>
                <h1>New here? Create an Account for free!</h1>
                <div>
                    <Form.Control
                        type="text"
                        placeholder="username"
                        name="username"
                        onChange={storeValues}
                    />
                </div>
                <div>
                    <Form.Control
                        type="password"
                        placeholder="password"
                        name="password"
                        onChange={storeValues}
                    />
                </div>
                <div>
                {/*TODO: buttons*/}
                    <Button className="btn-success m-1" onClick={register}>Register</Button>
                    <Button className="btn-dark" onClick={() => navigate("../")}>Back</Button>
                </div>
            </div>
        </Container>
    )
}