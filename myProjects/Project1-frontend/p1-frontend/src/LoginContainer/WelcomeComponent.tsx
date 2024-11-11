import { Button, Container } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
export const WelcomeComponent:React.FC = () => {
    
    const navigate = useNavigate();

    return(
        <Container>
            <h1>Welcome! Are you a new or existing employee?</h1>
            <h2>If you are a new employee, please sign up now; otherwise login!</h2>
            <Button onClick={()=>{navigate("/login")}}>Login</Button>
            <Button onClick={()=>{navigate("/register")}}>Register Now</Button>
        </Container>
    )
}