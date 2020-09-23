import React, { Component } from 'react';
import Heading from './components/Heading'
import Table from './components/Table'
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Heading />
        <Table />
      </div>
    );
  }
}

export default App;
