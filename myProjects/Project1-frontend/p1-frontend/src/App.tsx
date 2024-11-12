import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { WelcomeComponent } from './LoginContainer/WelcomeComponent';
import { RegisterUser } from './LoginContainer/RegisterUser';
import { LoginComponent } from './LoginContainer/LoginComponent';
import { AllUser } from './Users/AllUsers';
import { AllTickets } from './Tickets/AllTickets';
import { TicketsByUserId } from './Tickets/TicketsByUserId';
import { ManagerSearchByUserId } from './Tickets/ManagerSearchByUserId';
import { ChangePassword } from './Users/ChangePassword';
import { AllPendingTicket } from './Tickets/AllPendingTickets';
import { ChangeStatus } from './Tickets/ChangeStatus';
import { CreateTicket } from './Tickets/CreateTicket';
import { PendingTicketsByUserId } from './Tickets/PendingTicketsByUserId';
import { ManagerToC } from './ToC/ManagerToC';
import { EmployeeToC } from './ToC/EmployeeToC';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/Manager" element={<ManagerToC/>}/>
          <Route path="/Employee" element={<EmployeeToC/>}/>
          <Route path="" element={<WelcomeComponent/>}/>
          <Route path="/register" element={<RegisterUser/>}/>
          <Route path="/login" element={<LoginComponent/>}/>
          <Route path="/users" element={<AllUser/>}/>
          <Route path="/tickets/create" element={<CreateTicket/>}/>
          <Route path="/tickets" element={<AllTickets/>}/>
          <Route path="/tickets/user/" element={<TicketsByUserId/>}/>
          <Route path="/tickets/manager/" element={<ManagerSearchByUserId/>}/>
          <Route path="/users/update" element={<ChangePassword/>}/>
          <Route path="/tickets/status/pending" element={<AllPendingTicket/>}/>
          <Route path="/tickets/status/pending/user" element={<PendingTicketsByUserId/>}/>
          <Route path="/tickets/status/update" element={<ChangeStatus/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
