import { Button, Container, Form } from "react-bootstrap"
import 'bootstrap/dist/css/bootstrap.css';
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import { store } from "../globalData/store";

export const ChangePassword:React.FC = () => {
    const navigate = useNavigate();

    const [password, setPassword] = useState({
        currentPassword:"",
        newPassword:"",
        confirmPassword:""
    });

    const storeValues = (input:any) => {
        const name = input.target.name;
        const value = input.target.value;

        setPassword((password) => ({
            ...password, [name]:value
        }))
    }

    const Change = async () => {
        const response = await axios.patch("http://localhost:7878/users/update/password/" + store.loggedInUser.userId, password)
        .then((response) => {
            alert("Success! Your password has been changed!")
        })
        .catch((error) => {alert(error.message)})
    }
    return(
        <Container>
            <div>
                <h2>User Settings</h2>
            </div>
            <Form.Control
                type="password"
                name="currentPassword"
                placeholder="current password"
                onChange={storeValues}
            />
            <Form.Control
                type="password"
                name="newPassword"
                placeholder="new password"
                onChange={storeValues}
            />
            <Form.Control
                type="password"
                name="confirmPassword"
                placeholder="confirm password"
                onChange={storeValues}
            />
            <Button onClick={Change}>Submit</Button>
            <br></br>
            <div>
                <br></br>
                <Button onClick={() => {navigate("/" + store.loggedInUser.role)}}>Back</Button>
                <Button onClick={() => {navigate("/")}}>Logout</Button>
            </div>
        </Container>
    )
}