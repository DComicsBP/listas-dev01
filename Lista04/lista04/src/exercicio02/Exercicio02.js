import React, { Component } from 'react';

export default class Exercicio02 extends Component {
    constructor() {
        super();
        this.state = {
            value01: 100,
            value02: 100,
            value03: 100,
        }
    }

    menosUm01(param) {
        let currentState = this.state.value01;
        this.setState({ value01: currentState - param })
    }
    maisUm01(param) {
        let currentState = this.state.value01;
        this.setState({ value01: currentState + param })
    }
    menosUm02(param) {
        debugger
        let currentState = this.state.value02;
        this.setState({ value02: currentState + param })

    }
    maisUm02(param) {
        let currentState = this.state.value02;
        this.setState({ value02: currentState + param })

    }


    menosUm03(param) {
        let currentState = this.state.value03;
        this.setState({ value03: currentState - param })

    }
    maisUm03(param) {
        let currentState = this.state.value03;
        this.setState({ value03: currentState + param })

    }

    render() {
        return (
            <section>
                <button class="btn btn-light" onClick={(e) => this.maisUm01(1)}> + </button>
                <span style={{ height: '100px', backgroundColor: 'red' }}> {this.state.value01} </span>
                <button class="btn btn-light" onClick={(e) => this.menosUm01(1)}> - </button>

                <button class="btn btn-light" onClick={(e) => this.maisUm02(1)}> + </button>
                <span style={{ height: '100px', backgroundColor: 'blue' }}>   {this.state.value02}   </span>
                <button class="btn btn-light" onClick={(e) => this.menosUm02(1)}> - </button>

                <button class="btn btn-light" onClick={(e) => this.maisUm03(1)}> + </button>
                <span style={{ height: '100px', backgroundColor: 'yellow' }}> {this.state.value03}   </span>
                <button class="btn btn-light" onClick={(e) => this.menosUm03(1)}> - </button>


                <br />
                <br />
                <h1 style={{backgroundColor:`rgb(${this.state.value01},${this.state.value02}, ${this.state.value03})`}}>Cor RGB</h1>

            </section>
        )
    }
}