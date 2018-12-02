import React, {Component} from 'react'; 
export default class Exercicio01 extends Component{
    constructor(){
        super(); 
        this.state = {
            value:0
        }
        
    }
    somaMais(param){
        let stateInterno = this.state.value; 
        this.setState({
            value: stateInterno +param
    })
}

    render(){
        return (
            <section>
                <button class="btn btn-light" onClick={this.somaMais(0.01)}>0.01</button>
               
                <br/>
                <br/>
                <span>Valor: {this.state.value} </span>

            </section>
        )
    }
}