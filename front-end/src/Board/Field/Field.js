import { withStyles } from 'material-ui/styles';
import PropTypes from 'prop-types';
import React from 'react';
import './Field.css';
import {Grid, Paper} from 'material-ui'
import CardInField from './Card/CardInField.js';
import DemoCardsInField from './DemoCardInField.js';
import DemoCardsInFieldE from './DemoCardInFieldE';
import NULL from './cards_img/cardf.png';
import GEM from './cards_img/gem.jpg';
import Card, { CardActions, CardContent, CardMedia } from 'material-ui/Card';
import Button from 'material-ui/Button';
import Typography from 'material-ui/Typography';
import GridList, { GridListTile } from 'material-ui/GridList';
// import tileData from './tileData';

const styles = theme => ({

    field: {
        padding: 20, marginTop: 10, marginButton: 10, marginLeft: 5, marginRight:5,

        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'space-around',
        overflow: 'hidden',
        // backgroundColor: theme.palette.background.paper,
        // minhight: 330,
        // minwidth: 600,
        // display: "flex",
    },







});



function Field(props){

    const { classes } = props;
        return(

            <Paper className={ classes.field } >


                {/*{DemoCardsInField[1].img}*/}
                {/*<img src={DemoCardsInField[1].img}/>*/}
                <div className="grid-holder-enemy">
                    <Grid container spacing={12}>
                        <Grid item ys={12} >


                            <div className="flex-container">
                                <div><CardInField
                                    img = {DemoCardsInField[0].img}
                                    title = {"ATK :"+ DemoCardsInField[0].atk +"\n HP :"+ DemoCardsInField[0].hp}
                                    classes={classes}
                                    empty = {DemoCardsInField[0].img == null}
                                /></div>
                                <div><CardInField
                                    img = {DemoCardsInField[1].img}
                                    title = {"ATK :"+ DemoCardsInField[1].atk +"\n HP :"+ DemoCardsInField[1].hp}
                                    classes={classes}
                                    empty = {DemoCardsInField[1].img == null}
                                /></div>
                                <div><CardInField
                                    img = {DemoCardsInField[2].img}
                                    title = {"ATK :"+ DemoCardsInField[2].atk +"\n HP :"+ DemoCardsInField[2].hp}
                                    classes={classes}
                                    empty = {DemoCardsInField[2].img == null}
                                /></div>
                                <div><CardInField
                                    img = {DemoCardsInField[3].img}
                                    title = {"ATK :"+ DemoCardsInField[3].atk +"\n HP :"+ DemoCardsInField[3].hp}
                                    classes={classes}
                                    empty = {DemoCardsInField[3].img == null}
                                /></div>
                                <div><CardInField
                                    img = {DemoCardsInField[4].img}
                                    title = {"ATK :"+ DemoCardsInField[4].atk +"\n HP :"+ DemoCardsInField[4].hp}
                                    classes={classes}
                                    empty = {DemoCardsInField[4].img == null}
                                /></div>
                                <div><CardInField
                                    img = {DemoCardsInField[5].img}
                                    title = {"ATK :"+ DemoCardsInField[5].atk +"\n HP :"+ DemoCardsInField[5].hp}
                                    classes={classes}
                                    empty = {DemoCardsInField[5].img == null}
                                /></div>

                            </div>

                        </Grid>
                    </Grid>
                </div>
                <br/> <br/> <br/>
                <div className = "grid-holder-friendly">
                    <Grid container spacing={12}>
                        <Grid item ys={12} >

                            <div className="flex-container">
                                <div><CardInField
                                    img = {DemoCardsInFieldE[0].img}
                                    title = {"ATK :"+ DemoCardsInFieldE[0].atk +"\n HP :"+ DemoCardsInFieldE[0].hp}
                                    classes={classes}
                                    empty = {DemoCardsInFieldE[0].img == null}
                                /></div>
                                <div><CardInField
                                    img = {DemoCardsInFieldE[1].img}
                                    title = {"ATK :"+ DemoCardsInFieldE[1].atk +"\n HP :"+ DemoCardsInFieldE[1].hp}
                                    classes={classes}
                                    empty = {DemoCardsInFieldE[1].img == null}
                                /></div>
                                <div><CardInField
                                    img = {DemoCardsInFieldE[2].img}
                                    title = {"ATK :"+ DemoCardsInFieldE[2].atk +"\n HP :"+ DemoCardsInFieldE[2].hp}
                                    classes={classes}
                                    empty = {DemoCardsInFieldE[2].img == null}
                                /></div>
                                <div><CardInField
                                    img = {DemoCardsInFieldE[3].img}
                                    title = {"ATK :"+ DemoCardsInFieldE[3].atk +"\n HP :"+ DemoCardsInFieldE[3].hp}
                                    classes={classes}
                                    empty = {DemoCardsInFieldE[3].img == null}
                                /></div>
                                <div><CardInField
                                    img = {DemoCardsInFieldE[4].img}
                                    title = {"ATK :"+ DemoCardsInFieldE[4].atk +"\n HP :"+ DemoCardsInFieldE[4].hp}
                                    classes={classes}
                                    empty = {DemoCardsInFieldE[4].img == null}
                                /></div>
                                <div><CardInField
                                    img = {DemoCardsInFieldE[5].img}
                                    title = {"ATK :"+ DemoCardsInFieldE[5].atk +"\n HP :"+ DemoCardsInFieldE[5].hp}
                                    classes={classes}
                                    empty = {DemoCardsInFieldE[5].img == null}
                                /></div>

                            </div>

                        </Grid>
                    </Grid>
                </div>


                {/*<Grid container spacing={12}>*/}
                    {/*<Grid item xs={12} >*/}

                        {/*<div className="flex-container">*/}
                            {/*<div>1</div>*/}
                            {/*<div>2</div>*/}
                            {/*<div>3</div>*/}
                            {/*<div>4</div>*/}
                            {/*<div>5</div>*/}

                        {/*</div>*/}

                    {/*</Grid>*/}
                {/*</Grid>*/}


                {/*<Grid Grid item xs={12}>*/}

                    {/*<div className="flex-container">*/}
                        {/*<div>1</div>*/}
                        {/*<div>2</div>*/}
                        {/*<div>3</div>*/}
                        {/*<div>4</div>*/}
                        {/*<div>5</div>*/}

                    {/*</div>*/}

                {/*</Grid>*/}

            </Paper>
        );

}

Field.propType ={
    classes: PropTypes.object.isRequired,
};
export default withStyles(styles)(Field);