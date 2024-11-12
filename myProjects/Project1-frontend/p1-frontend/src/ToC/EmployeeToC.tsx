import { Button, Container } from "react-bootstrap"
import { useNavigate } from "react-router-dom"

export const EmployeeToC:React.FC = () => {
    const navigate = useNavigate();

    return(
        <Container>
            <h2>Welcome, what would you like to do today?</h2>
            <br></br>
            <div className="btn-group-vertical" role="group" aria-label="Vertical button group">
                <Button onClick={() => {navigate("/tickets/user")}} className="btn btn-primary btn-lg">Your Tickets</Button>
                <Button onClick={() => {navigate("/tickets/status/pending/user")}} className="btn btn-primary btn-lg">Your Pending Tickets</Button>
                <Button onClick={() => {navigate("/tickets/create")}} className="btn btn-primary btn-lg">Create a Ticket</Button>
                <Button onClick={() => {navigate("/users/update")}} className="btn btn-primary btn-lg">Change Password</Button>
            </div>
        </Container>
    )
}