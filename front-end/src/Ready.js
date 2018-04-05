import React from 'react';
import './Ready.css';
import { Button } from "react-bootstrap";

const wellStyles = { maxWidth: 400, margin: '0 auto 200px' };


export default (props) => {
    return (
        <div className={'ready'}>
        <Button bsSize="large" block bsStyle="success" onClick={() => this.props.history.push() }>
            Ready
        </Button>
            </div>
    );
};
