import { Container, Table } from "react-bootstrap"

export const TicketTable:React.FC<{tickets:any}> = ({tickets}) => {
    return(
        <Container>
            <Table>
                <thead>
                    <tr>
                        <th>Ticket ID</th>
                        <th>Description</th>
                        <th>Amount</th>
                        <th>Status</th>
                        <th>User ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Username</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    {tickets.map((ticket:any) => (
                        <tr>
                            <td>{ticket.ticketId}</td>
                            <td>{ticket.description}</td>
                            <td>{ticket.amount}</td>
                            <td>{ticket.status}</td>
                            <td>{ticket.user.userId}</td>
                            <td>{ticket.user.firstName}</td>
                            <td>{ticket.user.lastName}</td>
                            <td>{ticket.user.username}</td>
                            <td>{ticket.user.role}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Container>
    )
}