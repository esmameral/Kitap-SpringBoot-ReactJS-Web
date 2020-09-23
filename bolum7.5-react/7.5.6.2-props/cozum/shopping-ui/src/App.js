import React, { Component } from 'react';
import Heading from './components/Heading'
import Table from './components/Table'
import * as data from './data.json';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Heading title="Ürün Listesi"/>
        <Table data={data.productList}/>
      </div>
    );
  }
}

export default App;
