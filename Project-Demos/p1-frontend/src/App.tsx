import React from 'react';
import './App.css';
import { LoginComponent } from './LoginRegister/LoginComponent';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { RegisterUser } from './LoginRegister/RegisterUser';
import { PetContainer } from './Pet/PetContainer';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          {/* blank path makes this component render first */}
          <Route path="" element={<LoginComponent/>}/>
          <Route path="/register" element={<RegisterUser/>}/>
          <Route path="/pets" element={<PetContainer/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
