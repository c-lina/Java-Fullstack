//The EmployeeContainer will render one employee component for ebery object found in 
//the incomingData array

export const Employee:React.FC<any> = (employee:any) => {
    //This will return a view of the incoming employee's data
    return(
        <div>
            <div>
                <h3>{employee.id}) {employee.name}</h3>
            </div>
            <div>
                <h3>"{employee.quote}"</h3>
            </div>
        </div>
    )
}