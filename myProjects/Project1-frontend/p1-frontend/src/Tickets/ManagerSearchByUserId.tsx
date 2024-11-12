import { Button, Container, Form } from "react-bootstrap"
import 'bootstrap/dist/css/bootstrap.css';
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import { TicketTable } from "./TicketTable";

export const ManagerSearchByUserId:React.FC = () => {
    const navigate = useNavigate();

    const [ticket, setTicket] = useState([]);

    const TicketsByUserId = async (value:any) => {
        const response = await axios.get("http://localhost:7878/tickets/user/" + value)
        .then((response) => {
            setTicket(response.data)
        })
        .catch((error) => {})
    }

    const storeValues = (input:any) => {
        const value = input.target.value;
        TicketsByUserId(value);
    }

    return(
        <Container>
            <h3>User ID: </h3>
            <div>
                <Form.Control
                    type="number"
                    name="userId"
                    placeholder="#"
                    onChange={storeValues}
                />
            </div>
            <TicketTable tickets={ticket}></TicketTable>
            <Button onClick={() => {navigate("/Manager")}}>Back</Button>
            <Button onClick={() => {navigate("/")}}>Logout</Button>
        </Container>
    )
}