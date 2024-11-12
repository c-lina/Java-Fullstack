import { useEffect, useState } from "react"
import { Button, Container } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import { UserTable } from "./UserTable";
import axios from "axios";
import { store } from "../globalData/store";

export const AllUser:React.FC = () => {
    const navigate = useNavigate();

    const [user, setUser] = useState([]);

    useEffect(() => {
        getAllUsers()
    }, [])

    const getAllUsers = async() => {
        const response = await axios.get("http://localhost:7878/users")
        .then((response) => {setUser(response.data)})
        .catch((error) => {})
    }

    return(
        <Container>
            <UserTable users={user}></UserTable>
            <Button onClick={() => {navigate("/Manager")}}>Back</Button>
            <Button onClick={() => {navigate("/")}}>Logout</Button>
        </Container>
    )
}