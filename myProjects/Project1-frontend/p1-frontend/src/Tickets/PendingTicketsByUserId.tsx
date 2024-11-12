import axios from "axios";
import { Button, Container } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import { store } from "../globalData/store";
import { useEffect, useState } from "react";
import { TicketTable } from "./TicketTable";

export const PendingTicketsByUserId:React.FC = () => {
    const navigate = useNavigate();

    const [ticket, setTicket] = useState([]);

    useEffect(() => {
        PendingTicketsById()
    }, [])

    const PendingTicketsById = async() => {
        console.log(ticket)
        const response = await axios.get("http://localhost:7878/tickets/status/pending/" + store.loggedInUser.userId)
        .then((response) => {
            setTicket(response.data)
        })
        .catch((error) => {})
    }

    return(
        <Container>
            <TicketTable tickets={ticket}></TicketTable>
            <Button onClick={() => {navigate("/" + store.loggedInUser.role)}}>Back</Button>
            <Button onClick={() => {navigate("/")}}>Logout</Button>
        </Container>
    )
}