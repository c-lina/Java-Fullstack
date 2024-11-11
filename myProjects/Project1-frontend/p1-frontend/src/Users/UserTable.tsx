import { Container, Table } from "react-bootstrap"

export const UserTable:React.FC<{users:any[]}> = ({users}) => {
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
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Container>
    )
}