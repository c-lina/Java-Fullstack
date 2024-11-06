/*

In this component, props is of <any> type. What is props?

Props is the data sent in from a parent component (the PROperties the child takes)
ParentComponent will render ChildComponent in it's TSX, and pass its state to the child

ParentComponent will send a state object containing a value color and animal
The props value in the Child will be the EXACT data sent from the paren'ts state

*/
export const ChildComponent:React.FC<any> = ({color, animal}) => {
    return(
        <div>
            <h4>Hello from the child component</h4>
            <h4 style={{color}}>My parent's fav color is: {color}</h4>
            <h5>My parent's favorite animal is: {animal}</h5>
        </div>
    )
}