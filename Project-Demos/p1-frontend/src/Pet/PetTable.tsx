//This component takes in the pets array as props from the PetContainer

import { Container, Table } from "react-bootstrap"

export const PetTable:React.FC<{pets:any[]}> = ({pets}) => {
    return (
        <Container>
            <Table>
                <thead>
                    <tr>
                        <th>Pet ID</th>
                        <th>Name</th>
                        <th>Species</th>
                    </tr>
                </thead>
                <tbody>
                    {pets.map((pet:any) => (
                        <tr>
                            <td>{pet.pet_id}</td>
                            <td>{pet.name}</td>
                            <td>{pet.species}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Container>
    )
}