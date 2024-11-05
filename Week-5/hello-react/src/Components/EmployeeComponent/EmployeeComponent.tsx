//This will take in data from employeeData.ts (sent as props in App.tsx)

import { useState } from "react"

export const EmployeeContainer:React.FC<any> = () => {

    //state variables to store an array of the employee data
    const [employee, setEmployee] = useState<any[]>([])

    //useEffect that populates our employees array when the component renders
    //imagine we get a GET request


    return(
        <>
            <h3>Employee Container</h3>
        </>
    )

} 