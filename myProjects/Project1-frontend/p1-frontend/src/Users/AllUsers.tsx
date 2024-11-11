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
    }

    return(
        <Container>
            <UserTable users={user}></UserTable>
            <Button onClick={() => {navigate("/tickets")}}>All Tickets</Button>
            <Button onClick={() => {navigate("/tickets/status")}}>All Pending Tickets</Button>
            <Button onClick={() => {navigate("/tickets/manager")}}>Ticket By ID</Button>
            <Button onClick={() => {navigate("/users/update")}}>Change Password</Button>
            <Button onClick={() => {navigate("/tickets/status/update")}}>Change Ticket Status</Button>
        </Container>
    )
}