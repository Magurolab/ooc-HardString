import React from 'react'
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import {Grid, Paper} from 'material-ui'
import Card, { CardActions, CardContent } from 'material-ui/Card';

import Field from './Field/Field.js';


const styles = theme => ({
    root: {
        flexGrow: 1,
    },
    paper: {
        padding: 20, marginTop: 10, marginButton: 10, marginLeft: 5, marginRight:5,
    },
    card: {
        height: "50%",
        width: "80%",
        margin: "0 auto",
    },
    g: {
        display: "inline-block",
    }
});


class Board extends React.Component{

    constructor(props){
        super(props)
    }

    render(){
        const { classes } = this.props;
        return (
            <div className={classes.root}>
                <Grid container spacing={12}>
                    <Grid item xs={12} >
                        <Field/>
                    </Grid>
                </Grid>

                <div><br/><br/></div>

                <Grid container spacing={12} className={classes.g}>
                    <Grid item xs={4}>
                        <Card>Hi Poon</Card>
                    </Grid>
                    <Grid item xs={4}>
                        <Card>YOLO</Card>
                    </Grid>
                    <Grid item xs={4}>
                        <Card>Eazy</Card>
                    </Grid>
                </Grid>
            </div>
        );
    }
}

Board.propTypes = {
    classes: PropTypes.object.isRequired
};

export default withStyles(styles)(Board);
