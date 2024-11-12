import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';
import { log } from 'console';
import { useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { store } from '../globalData/store';

export const LoginComponent:React.FC = () => {
    const navigate = useNavigate();

    const [user, setUser] = useState({
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

    const login = async () => {
        const response = await axios.post("http://localhost:7878/login", user)
        .then(
            (response) => {
                store.loggedInUser = response.data;
                (alert("Login Succesful! Welcome back, " + user.username))

                if(store.loggedInUser.role === "Manager") {
                    navigate("/Manager")
                }
                else {
                    navigate("/Employee")
                }

        })
        .catch((error) => {alert("Error! Your username or password is incorrect")})
    }

    return(
        <Container>
            <h3>Welcome back, sign in here</h3>
            <div>
                <Form.Control
                    type='text'
                    name='username'
                    placeholder='username'
                    onChange={storeValues}
                />
            </div>
            <div>
                <Form.Control
                    type='password'
                    name='password'
                    placeholder='password'
                    onChange={storeValues}
                />
            </div>
            <Button onClick={() => {navigate("/")}}>Go Back</Button>
            <Button onClick={login}>Submit</Button>
        </Container>
    )
}