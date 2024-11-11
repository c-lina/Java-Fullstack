import axios from "axios";
import { useEffect, useState } from "react";
import { Button, Container, Form } from "react-bootstrap"
import { useNavigate, useSearchParams } from "react-router-dom"
import { TicketTable } from "./TicketTable";
import { TicketsByUserId } from "./TicketsByUserId";
import { store } from "../globalData/store";

export const ChangeStatus:React.FC = () => {
    const navigate = useNavigate();

    const [value, setValue] = useState(0);
    const [ticket, setTicket] = useState([]);

    const statusUpdate = async(value:any, decision:String) => {
        console.log(value)
        console.log(decision)
        const response = await axios.patch("http://localhost:7878/tickets/status/" + value, decision, {
            headers: {
                "Content-Type": "text/plain" }})
        .then((response) => {
            console.log(response)
        })
        .catch((error) => {console.log(error)})
    }

    const storeValues = (input:any) => {
        const value = input.target.value;
        setValue(value);
    }

    const acccepted = () => {
        statusUpdate(value, "Accepted");
    }

    const denied = () => {
        statusUpdate(value, "Denied");
    }

    return(
        <Container>
            <div>
                <Form.Control
                    type="number"
                    name="ticketId"
                    placeholder="#"
                    onChange={storeValues}
                />
            </div>
            {/* <TicketTable tickets={ticket}></TicketTable> */}
            <Button onClick={acccepted}>Accepted</Button>
            <Button onClick={denied}>Denied</Button>
        </Container>
    )
}