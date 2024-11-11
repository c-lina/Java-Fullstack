import axios from "axios";
import { useState } from "react";
import { Button, Container, Form } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import 'bootstrap/dist/css/bootstrap.css';

export const RegisterUser:React.FC = () => {
    const navigate = useNavigate();

    const [user, setUser] = useState({
        firstName: "",
        lastName:"",
        username:"",
        password:""
    })

    const storeValues = (input:any) => {
        const name = input.target.name;
        const value = input.target.value;

        setUser((user) => ({
            ...user, [name]:value
        }))
    }

    const register = async () => {
        const reponse = await axios.post("http://localhost:7878/users", user)
        .then((response) => {alert("Success! Your account has been created. Welcome, " + user.username)})
        .catch((error) => (error.message))
    }

    return(
        <Container className="my-auto mx-auto">
            <h2>Welcome! Create your account here!</h2>
            <div id="text-fields">
                <div>
                    <Form.Control
                        type="text"
                        placeholder="first name"
                        name="firstName"
                        onChange={storeValues}
                    />
                </div>
                <div>
                    <Form.Control
                        type="text"
                        placeholder="last name"
                        name="lastName"
                        onChange={storeValues}
                    />
                </div>
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
            </div>
            <div>
                <select name="role" id="role" onChange={storeValues}>
                    <option defaultValue="" disabled>Choose your role:</option>
                    <option value="Employee">Employee</option>
                    <option value="Manager">Manager</option>
                </select>
            </div>
            <div>
                <Button onClick={() => {navigate("/")}}>Go Back</Button>
                <Button onClick={register}>Submit</Button>
            </div>
        </Container>
    )
}