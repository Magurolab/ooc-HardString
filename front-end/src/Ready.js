import React from 'react';
import './Ready.css';
import { Button } from "react-bootstrap";

import ReadyAPI from './api/ReadyAPI';
import loginAPI from "./api/LoginAPI";
import {withStyles} from "material-ui/styles/index";
import {withAuth} from "react-router-auth-provider";

// const wellStyles = { maxWidth: 400, margin: '0 auto 200px' };

const styles = theme => ({

    ready:{
        maxWidth:400,
        margin: '0 auto 200px'
    }


});



class Ready extends React.Component {


    render(){

        return (
            <div className={'ready'}>
                <Button bsSize="large" block bsStyle="success" onClick={() => {

                    ReadyAPI.ready().then(({data}) => {
                        console.log(data);
                        this.props.onLoginSuccess(data,
                            () => this.props.history.push('/waiting'))
                    })
                }}>
                    Ready
                </Button>
            </div>

        );
    }
}


export default withAuth(withStyles(styles)(Ready));



