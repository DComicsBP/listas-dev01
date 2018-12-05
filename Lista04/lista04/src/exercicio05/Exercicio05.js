import React, {Component} from 'react'; 

export default class Exercicio05 extends Component{
    constructor(){
        super(); 
    }

    render(){
        return(
            <section>
              <span>Entre 2 e 10: </span>  <input class="form-control col-md-4 form-control-lg" type="text" placeholder=".form-control-lg"/>
                <br/>
                <span>Entre 10 e 20: </span> <input class="form-control col-md-4 form-control-lg" type="text" placeholder=".form-control-lg"/>
                <br/>
                <span>Entre 4 e 8: </span> <input class="form-control col-md-4 form-control-lg" type="text" placeholder=".form-control-lg"/>
                <br/>
                <span>Entre 5 e 6: </span> <input class="form-control col-md-4 form-control-lg" type="text" placeholder=".form-control-lg"/>
            </section>
        )
    }
}