import { useState } from "react"
import "./Calculation.css"

export const CalculationComponent:React.FC = () => {

    /*

    This component will take in 2 values to calculate a hypothenuse
    We'll store each value and the calculation's result as state variables        

    */

    const [sideA, setSideA] = useState<number>(0)
    const [sideB, setSideB] = useState<number>(0)
    const [result, setResult] = useState<number>(0)

    //This function will store the SideA or SideB input values (depending on which changes)
    //We'll take the name of the input, and assign that value to the appropriate state variable
    const storeValues = (input:any)  => {
        
        //if the name of the changed input is "SideA", then store it in the sideA variable
        //Otherwise, store the input in the sideB state variable

        if(input.target.name === "SideA") {
            setSideA(input.target.value);
        }
        else {
            setSideB(input.target.value);
        }
        //input is going to be the entire event object, which stores our target
        //what is target? it refers to the specific element that was triggered (one of our input boxes)
        //it refers to the input box itself -- element that triggered the event
    }


    //TODO: function to do calculation and render it
    const calculate = () => {
        
        //We can use the Math class to calculate hypothenuse
        let hypontenuse = Math.hypot(sideA, sideB)

        //set the result state
        setResult(hypontenuse);

        //yes, this could have just been one line :)
    }

    return(
        <div className="input-container">
            <h3>Calculation Component</h3>

            <input type="number" name="SideA" onChange={storeValues}></input>
            <input type="number" name="SideB" onChange={storeValues}></input>

            {/* Conditional Rendering! If sideA or sideB are <= 0, render an error message */}
            <p style={{color:"red"}}>
                {/* Are sideA and sideB both > 0? good. otherwise, render an error */}
                {sideA > 0 && sideB > 0 ? "":"please enter positive integers for both sides"}
            </p>

            <div>
                {/* If result is truthy, tell the user the result. otherwise render nothing */}
                {result ? <p>You calculated: {result}</p>:""}
            </div>

            <button onClick={calculate}>Calculate Hypotenuse!</button>

    
        </div>
    )
}