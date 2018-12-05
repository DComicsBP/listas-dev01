import React, {Component} from 'react'; 

export default class Exercicio06 extends Component{
    constructor(){
        super(); 
    }
    render(){
        return(
            <section>
                
               <span>Nome: </span><input class="form-control" type="text" placeholder="Default input"/>
               <br/>
               <span>Senha: </span><input class="form-control" type="text" placeholder="Default input"/>
               <br/>
               
               <span>Repetir Senha: </span><input class="form-control" type="text" placeholder="Default input"/>
            </section>
        )
    }
}