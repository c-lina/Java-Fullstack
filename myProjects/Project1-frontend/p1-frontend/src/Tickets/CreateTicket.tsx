import { useState } from "react";
import { Button, Container, Form } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import { store } from "../globalData/store";
import axios from "axios";

export const CreateTicket:React.FC = () => {
    const navigate = useNavigate();

    const [ticket, setTicket] = useState({
        amount:0,
        userIdFK:store.loggedInUser.userId
    })

    const storeValues = (input:any) => {
        const name = input.target.name;
        const value = input.target.value;

        setTicket((ticket) => ({
            ...ticket, [name]:value
        }))
    }
    
    const createTicket = async() => {
        console.log(ticket)
        const response = await axios.post("http://localhost:7878/tickets", ticket)
        .then((response) => {
            alert("Success! Your ticket has been created")
        })
        .catch((error) => {"Error! Something went wrong"})
    }
    
    return(
        <Container>
            <h2>Reimbursement Ticket</h2>
            <div>
                <Form.Control
                    type="text"
                    name="description"
                    placeholder="description"
                    onChange={storeValues}
                />
                <Form.Control
                    type="number"
                    name="amount"
                    placeholder="amount"
                    onChange={storeValues}
                />
            </div>
            <Button onClick={createTicket}>Submit</Button>
            <br></br>
            <div>
                <br></br>
                <Button onClick={() => {navigate("/" + store.loggedInUser.role)}}>Back</Button>
                <Button onClick={() => {navigate("/")}}>Logout</Button>
            </div>
        </Container>
    )
}