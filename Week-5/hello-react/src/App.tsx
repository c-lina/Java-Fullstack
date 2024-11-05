import React from 'react';
import logo from './logo.svg';
import { FirstComponent } from './Components/FirstComponent/FirstComponent';
import { ParentComponent } from './Components/ParentComponent/ParentComponent';
import './App.css';
import { UserComponent } from './Components/UserComponent/UserComponent';

// We put the components we want to render in the div of the return()

//We can render standalone elements within the div as well, but we usually won't do it

function App() {
  return (
    <div className="App">
      <header className="App-header">
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        <h1>Hello React! We'll make great, modern front ends with you :)</h1>
        <p>We are writing in TSX, which is like HTML for React TS</p>
        <h3>React will reload the webpage with every saved change in the App</h3>
        <FirstComponent></FirstComponent>
        <ParentComponent></ParentComponent>
        <UserComponent></UserComponent>
        {/* <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p> */}
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
