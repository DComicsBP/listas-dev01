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
                <button class="btn btn-light" onClick={(e) => this.somaMais(0.01)}>0.01</button>
                <button class="btn btn-light" onClick={(e)=> this.somaMais(0.05)}>0.05</button>
                <button class="btn btn-light" onClick={(e)=>this.somaMais(0.1)}>0.1</button>
                <button class="btn btn-light" onClick={(e)=> this.somaMais(0.25)}>0.25</button>
                <button class="btn btn-light" onClick={(e)=> this.somaMais(0.5)}>0.5</button>
                <button class="btn btn-light" onClick={(e)=>this.somaMais(1)}>1</button> 
                <button class="btn btn-light" onClick={(e)=>this.somaMais(2)}>2</button>
                <button class="btn btn-light" onClick={(e)=>this.somaMais(5)}>5</button>
                <button class="btn btn-light" onClick={(e)=>this.somaMais(10)}>10</button>
                <button class="btn btn-light" onClick={(e)=>this.somaMais(20)}>20</button>
                <button class="btn btn-light" onClick={(e)=>this.somaMais(50)}>50</button>
                <button class="btn btn-light" onClick={(e)=>this.somaMais(100)}>100</button>
                <br/>
                <br/>
                <span>Valor: {this.state.value} </span>

            </section>
        )
    }
}
/*
Maximum update depth exceeded. This can happen when a component repeatedly calls setState inside componentWillUpdate or componentDidUpdate. React limits the number of nested updates to prevent infinite loops.
https://stackoverflow.com/questions/48497358/reactjs-maximum-update-depth-exceeded-error
*/