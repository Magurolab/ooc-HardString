import Paper from 'material-ui/Paper';
import { withStyles } from 'material-ui/styles';
import PropTypes from 'prop-types';
import React from 'react';

const styles = theme => ({
    root: {
        flexGrow: 1,
    },
    field: {
        padding: 20, marginTop: 10, marginButton: 10, marginLeft: 5, marginRight:5,
        width: '100%',
        height: '100%',

    }
})


function Field(props){
        const { classes } = props;
        return(
            <Paper className={ classes.field } >
                Field
            </Paper>
        );

}

Field.propType ={
    classes: PropTypes.object.isRequired,
};
export default withStyles(styles)(Field);