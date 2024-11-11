import axios from "axios";
import { useEffect, useState } from "react";
import { Container, Form } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import { TicketTable } from "./TicketTable";
import 'bootstrap/dist/css/bootstrap.css';

export const AllTickets:React.FC = () => {
    const navigate = useNavigate();

    const [ticket, setTicket] = useState([]);

    useEffect(() => {
        getAllTickets()
    }, [])

    const getAllTickets = async () => {
        const response = await axios.get("http://localhost:7878/tickets")
        .then((response) => {
            setTicket(response.data)
        })
    }

    return(
        <Container>
            <TicketTable tickets={ticket}></TicketTable>
        </Container>
    )
}