import axios from "axios"
import { useEffect, useState } from "react";
import { Button, Container, Table } from "react-bootstrap"

export const UserTable:React.FC<{users:any[]}> = ({users}) => {
    const [user, setUser] = useState([]);

    useEffect(() => {
        getAllUsers()
    }, [])

    const getAllUsers = async() => {
        const response = await axios.get("http://localhost:7878/users")
        .then((response) => {setUser(response.data)})
        .catch((error) => {})
    }

    const deleteUserById = async(value:any) => {
        const response = await axios.delete("http://localhost:7878/users/" + value)
        .then((response) => {
            alert("Success! User ID: " + value + " has been deleted");
            getAllUsers()
        })
        .catch((error) => {
            alert("Error! Something went wrong")
        })
    }

    return(
        <Container>
            <Table>
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Username</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((user:any) => (
                        <tr>
                            <td>{user.userId}</td>
                            <td>{user.firstName}</td>
                            <td>{user.lastName}</td>
                            <td>{user.username}</td>
                            <td>{user.role}</td>
                            <td><Button onClick={() => {deleteUserById(user.userId)}}>Delete</Button></td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Container>
    )
}