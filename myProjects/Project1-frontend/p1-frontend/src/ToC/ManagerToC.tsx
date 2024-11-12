import { Button, Container } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import 'bootstrap/dist/css/bootstrap.css';

export const ManagerToC:React.FC = () => {
    const navigate = useNavigate();
    
    return(
        <Container>
            <h1>Welcome! What would you like to do today?</h1>
            <br></br>
            <div className="btn-group-vertical" role="group" aria-label="Vertical button group">
                <Button onClick={() => {navigate("/users")}} className="btn btn-primary btn-lg">All Users</Button>
                <Button onClick={() => {navigate("/tickets")}} className="btn btn-primary btn-lg">All Tickets</Button>
                <Button onClick={() => {navigate("/tickets/manager")}} className="btn btn-primary btn-lg">Ticket By ID</Button>
                <Button onClick={() => {navigate("/tickets/status/pending")}} className="btn btn-primary btn-lg">All Pending Tickets</Button>
                <Button onClick={() => {navigate("/tickets/user")}} className="btn btn-primary btn-lg">Your Tickets</Button>
                <Button onClick={() => {navigate("/tickets/status/pending/user")}} className="btn btn-primary btn-lg">Your Pending Tickets</Button>
                <Button onClick={() => {navigate("/tickets/create")}} className="btn btn-primary btn-lg">Create a Ticket</Button>
                <Button onClick={() => {navigate("/users/update")}} className="btn btn-primary btn-lg">Change Password</Button>
                <Button onClick={() => {navigate("/tickets/status/update")}} className="btn btn-primary btn-lg">Change Ticket Status</Button>
            </div>
        </Container>
    )
}