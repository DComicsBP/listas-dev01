import React, {Component} from 'react'; 
export default class Exercicio04 extends Component{
    constructor(){
        super(); 
        this.state = { consoantes:0, vogais:0, caracteres:0, outros: 0, especial:0 }
    }

    verificaDigito(e){
        this.setState({
            vogais: (e.target.value.match(/[aeiou]/g) || []).length, 
            consoantes: (e.target.value.match(/[b-df-hj-np-tv-z]/g) || []).length,
            especial: (e.target.value.match(/[^0-9A-Za-z]/g) || []).length,
            outros:(e.target.value.match(/\d/g) || []).length,
            caracteres: (e.target.value.match(/\d/g) || []).length+(e.target.value.match(/[b-df-hj-np-tv-z]/g) || []).length+(e.target.value.match(/[aeiou]/g) || []).length
        })
      }

    render(){
        return(
            <section>
                <div class="form-group">
                    <label for="escreva">Escreva alguma coisa</label>
                    <input type="text" class="col-md-4 form-control" id="exampleInputEmail1" onKeyUp={(e)=>this.verificaDigito(e) }/>
                    <br/>
                    <span>total:{this.state.caracteres}</span>
                    <br/>
                    <span>Vogais: {this.state.vogais}</span>
                    <br/>
                    <span>Especiais:{this.state.especial}</span>
                    <br/>
                    <span>Consoante:{this.state.consoantes}</span>
                    <br/>
                    <span>Numeros:{this.state.outros}</span>
                </div>
            </section>
        )
    }
}
/*
https://stackoverflow.com/questions/7657824/count-the-number-of-integers-in-a-string
*/