import axios from "axios";
import { useEffect, useState } from "react";
import { Button, Container } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import { TicketTable } from "./TicketTable";

export const AllPendingTicket:React.FC = () => {
    const navigate = useNavigate();

    const [ticket, setTicket] = useState([]);

    useEffect(() => {
        getAllTickets()
    }, [])

    const getAllTickets = async() => {
        const response = await axios.get("http://localhost:7878/tickets/status/pending")
        .then((response) => {
            setTicket(response.data)
        })
    }

    return(
        <Container>
            <TicketTable tickets={ticket}></TicketTable>
            <Button onClick={() => {navigate("/Manager")}}>Back</Button>
            <Button onClick={() => {navigate("/")}}>Logout</Button>
        </Container>
    )
}