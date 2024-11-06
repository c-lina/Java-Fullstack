import { useEffect, useState } from "react"
import { Employee } from "./Employee"

//This will take in data from employeeData.ts (sent as props in App.tsx)
export const EmployeeContainer:React.FC<any> = (incomingData) => {

    //state variable to store an array of the employee data
    const[employees, setEmployees] = useState<any[]>([])

    //useEffect that populates our employees array when the component renders
    //(imagine we get a GET request in this useEffect instead)
    useEffect(() => {

        //set the employees state object with the employee data
        setEmployees(incomingData.incomingData)

        console.log(employees) //just so we can see employees in console


    }, [employees]) //[employees]? This will run and rerender every time employee state changes (PLUS the initial render)
    //previously, with [], the useEffect runs, THEN changes state. So we don't actually get our employee data in time. 


    return(
        <div>
            <h3>Employee Container</h3>

            {/* using map() to render an Employee Component for every employee in the array */}

            <div>
                {employees.map((employee:any) => {
                    return <Employee {...employee} key={employee.id}></Employee>
                })}
            </div>


        </div>
    )

} 