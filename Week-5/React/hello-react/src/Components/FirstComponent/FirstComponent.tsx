/*

Recall how arrow functions work. They can take in values, and execute some code
Our React Components will all just be arrow functions (Functional Components)
In our FirstComponent, we're sending in no arguments hence the empty ()

"export" - We need this so our Component can be imported around the app
"const" - The Component can't be reassigned changed, etc
"React.FC" - This is a React (F)unctional (C)omponent
    -Basically we're defining what datatype this function returns

*/

export const FirstComponent:React.FC = () => {

    //defining a variable - we will "databind" this value into the TSX below
    let words:String = "I am a value stored in the component and rendered in the TSX"

    return(
        <div>
            <h3>Hello from our First Component</h3>
            <p>Data Bound Value: {words}</p>
        </div>
    )
}