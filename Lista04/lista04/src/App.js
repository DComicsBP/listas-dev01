import React, { Component } from 'react';
import '../../../Lista04/lista04/node_modules/bootstrap/dist/css/bootstrap.min.css';
import Exercicio01 from './exercicio01/Exercicio01';
import Exercicio02 from './exercicio02/Exercicio02';
import Exercicio03 from './exercicio03/Exercicio03';
import Exercicio04 from './exercicio04/Exercicio04';
import Exercicio05 from './exercicio05/Exercicio05';
import Exercicio06 from './exercicio06/Exercicio06';
import Exercicio07 from './exercicio07/Exercicio07';
class App extends Component {
  render() {
    return (
      <div className="App container">
        <h1>Eu funciono</h1>
        <Exercicio07/>
      </div>
    );
  }
}

export default App;
