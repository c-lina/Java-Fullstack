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
        const response = await axios.patch("http://localhost:7878/tickets/status/" + value, decision, {
            headers: {
                "Content-Type": "text/plain" }})
        .then((response) => {
            alert("This ticket is " + decision)
        })
        .catch((error) => {console.log(error)})
    }

    const storeValues = (input:any) => {
        const value = input.target.value;
        setValue(value);
        getTicketById(value);
    }

    const acccepted = () => {
        statusUpdate(value, "Accepted");
    }

    const denied = () => {
        statusUpdate(value, "Denied");
    }

    useEffect(() => {
        getTicketById(value)
    }, [])

    const getTicketById = async(value:any) => {
        const response = await axios.get("http://localhost:7878/tickets/" + value)
        .then((response) => {
            setTicket(response.data)
        })
        .catch((error) => {})
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
            <div>
                <TicketTable tickets={ticket}></TicketTable>
            </div>
            <div>
                <Button onClick={acccepted}>Accepted</Button>
                <Button onClick={denied}>Denied</Button>
                <br></br>
            </div>
            <div>
                <br></br>
                <Button onClick={() => {navigate("/Manager")}}>Back</Button>
                <Button onClick={() => {navigate("/")}}>Logout</Button>
            </div>
        </Container>
    )
}