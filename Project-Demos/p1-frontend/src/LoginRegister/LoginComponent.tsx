import { Container } from "react-bootstrap"
import { useNavigate } from "react-router-dom"

export const LoginComponent:React.FC = () => {

    //we need a useNavigate hook to navigate between components programatically
        //(which means we don't have to manually switch the URL!)
        const navigate = useNavigate()

    return(
        // Bootstrap gives us this Container elements that does some default padding
        <Container> 
            <h3>Login inputs etc. pending</h3>
            <button>Login</button>
            <button onClick={() => navigate("/register")}>Register</button>
        </Container>
    )
}