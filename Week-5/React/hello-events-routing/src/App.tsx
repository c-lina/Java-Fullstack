import React from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { CalculationComponent } from './CalculationComponent/Calculation';
import { EmployeeContainer } from './EmployeeComponent/EmployeeContainer';
import { data } from './employeeData';
/*

In this demo, we'll use react-router dom to establish routes for our components
This is what lets us dynamically render components based on URL components

*/
function App() {
  return (
    <div className="App">
      <h3>Welcome to the Events and Routing Demo</h3>
      <p>Nothing much on the webpage...navigate to different enpoints to see different components</p>

      <BrowserRouter>
        <Routes> 
          <Route path="/calc" element={<CalculationComponent/>}></Route>
          <Route path="/emp" element={<EmployeeContainer incomingData={data}/>}></Route>

        </Routes>
      </BrowserRouter>      

      {/* path = URL endpoint to render a certain endpoint
          element = component to render
      */}

    </div>
  );
}

export default App;
