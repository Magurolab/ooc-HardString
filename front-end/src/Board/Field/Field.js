import { withStyles } from 'material-ui/styles';
import PropTypes from 'prop-types';
import React from 'react';
import './Field.css';
import {Grid, Paper} from 'material-ui'

const styles = theme => ({

    field: {
        padding: 20, marginTop: 10, marginButton: 10, marginLeft: 5, marginRight:5,
        // display: "flex",
    },

})


function Field(props){
        const { classes } = props;
        return(
            <Paper className={ classes.field } >

                <div>
                    <Grid container spacing={12}>
                        <Grid item ys={12} >

                            <div className="flex-container">
                                <div>1</div>
                                <div>2</div>
                                <div>3</div>
                                <div>4</div>
                                <div>5</div>
                                <div>6</div>

                            </div>

                        </Grid>
                    </Grid>
                </div>
                <br/> <br/> <br/>
                <div>
                    <Grid container spacing={12}>
                        <Grid item ys={12} >

                            <div className="flex-container">
                                <div>1</div>
                                <div>2</div>
                                <div>3</div>
                                <div>4</div>
                                <div>5</div>
                                <div>6</div>

                            </div>

                        </Grid>
                    </Grid>
                </div>

            </Paper>

        );

}

Field.propType ={
    classes: PropTypes.object.isRequired,
};
export default withStyles(styles)(Field);