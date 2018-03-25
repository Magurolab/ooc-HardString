import React from 'react'
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import {Grid, Paper} from 'material-ui'

import Field from './Field/Field.js';


const styles = theme => ({
    root: {
        flexGrow: 1,
    },
    paper: {
        padding: 20, marginTop: 10, marginButton: 10, marginLeft: 5, marginRight:5,
    }
})


class Board extends React.Component{

    constructor(props){
        super(props)
    }

    render(){
        const { classes } = this.props;
        return(
            <div className={classes.root}>
                <Grid container spacing={16} >

                    <Grid item md >
                        <Field />

                        <Paper className= {classes.paper}>
                            Hand
                        </Paper>

                    </Grid>

                    <Grid item xs={3}>

                        <Paper className= {classes.paper}>
                            Status
                        </Paper>



                    </Grid>

                </Grid>
            </div>
        );
    }
}

Board.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(Board);
