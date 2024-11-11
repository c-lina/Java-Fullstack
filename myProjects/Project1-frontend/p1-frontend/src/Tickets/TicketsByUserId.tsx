import axios from "axios";
import { useEffect, useState } from "react";
import { Button, Container } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import { store } from "../globalData/store";
import { TicketTable } from "./TicketTable";
import 'bootstrap/dist/css/bootstrap.css';

export const TicketsByUserId:React.FC = () => {
    const navigage = useNavigate();

    const [ticket, setTicket] = useState([])

    useEffect(() => {
        getTicketsByUserId()
    }, [])

    const getTicketsByUserId = async () => {
        const response = await axios.get("http://localhost:7878/tickets/user/" + store.loggedInUser.userId)
        .then((response) => {
            setTicket(response.data)
        })
    }

    return(
        <Container>
            <Button onClick={() => {navigage("/users/update")}}>Change password</Button>
            <TicketTable tickets={ticket}></TicketTable>
        </Container>
    )
}