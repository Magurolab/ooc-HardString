import React from 'react';
import './Ready.css';
import { Button } from "react-bootstrap";
import './WaitingQueue.css';
import ReadyAPI from './api/ReadyAPI';
import loginAPI from "./api/LoginAPI";
import {withStyles} from "material-ui/styles/index";
import {withAuth} from "react-router-auth-provider";
import WaitingAPI from "./api/WaitingAPI";
import BoardAPI from "./api/BoardAPI";

import {BeatLoader, HashLoader} from 'react-spinners';

// const wellStyles = { maxWidth: 400, margin: '0 auto 200px' };

const styles = theme => ({

    ready:{
        maxWidth:400,
        margin: '0 auto 200px'
    },

    waitText:{
        fontSize:1000,
    }

});





class WaitingQueue extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            queue: "",
            data:undefined
        };
    }
    componentWillMount(){
        this.readyToPlay();



    }

    componentDidMount(){
        this.state.intervalPointer = setInterval(this.readyToPlay, 3000);


    }

    componentWillUnmount(){
        clearInterval(this.state.intervalPointer);
    }

    readyToPlay = () =>{
        WaitingAPI.wait()
            .then(({data}) => {

                const { queue } = data;
                // console.log(isQueue);
                this.setState(({
                    queue,
                    data

                }), () => console.log("state", this.state));
            })
            .catch((e) => {
                // alert("Shit happens in Show board");
                console.log(e);
            })

        if(this.state.queue === false){
            this.props.onLoginSuccess(this.state.data,
                () => this.props.history.push('/board'))
        }



    };


    render(){

        return (

           <div className='BeatLoader'>

               <HashLoader
                   color={'#36D7B7'}
                   loading={true}
                    size={90}
               />

               </div>

        );
    }
}


export default withAuth(withStyles(styles)(WaitingQueue));



