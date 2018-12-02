import React, { Component } from 'react';
import '../../../Lista04/lista04/node_modules/bootstrap/dist/css/bootstrap.min.css';
import Exercicio01 from './exercicio01/Exercicio01';
import Exercicio02 from './exercicio02/Exercicio02';
import Exercicio03 from './exercicio03/Exercicio03';
class App extends Component {
  render() {
    return (
      <div className="App container">
        <h1>Eu funciono</h1>
        <Exercicio03/>
      </div>
    );
  }
}

export default App;
