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
import ImageMapper from '../../ImageMapper';

const styles = theme => ({

    field: {
        padding: 20, marginTop: 10, marginButton: 10, marginLeft: 5, marginRight: 5,

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

function setCard(monster,isEnemy){
    const monsterInfoHolder = {img:null,title:null,empty:null,enemy:null};
    if(monster === null){
        monsterInfoHolder.empty = true;
    }else{
        monsterInfoHolder.img = ImageMapper[monster.name];
        monsterInfoHolder.title = "ATK :"+ monster.atk +"\n HP :"+ monster.hp+"/"+monster.maxHP;
        monsterInfoHolder.empty = false;
        monsterInfoHolder.enemy = isEnemy;
        monsterInfoHolder.index = monster.index;
        monsterInfoHolder.cardId = monster.cardId;
    }
    return monsterInfoHolder;
}


function Field(props){

    const { classes, currentField, enemyField, availableAttackTarget, availableMagicTarget} = props;
    if(currentField === undefined || enemyField === undefined){
        return(<div>Loading..</div>);
    }

    // let  imgHolder,titleHolder,emptyHolder,enemyHolder;
    console.log("CurrentField",currentField);
    const {monster1,monster2,monster3,monster4,monster5,player} = enemyField;
    // console.log("current", props.currentField);


    // console.log("current2", currentField);
    console.log(currentField === undefined ? "Not Working" : "Working");

        return(

            <Paper className={ classes.field } >

                <div className="grid-holder-enemy">
                    <Grid container spacing={12}>
                        <Grid item ys={12} >


                            <div className="flex-container">

                                <div>

                                    <CardInField
                                        monsterInfo = {setCard(player,true)}
                                    classes={classes}


                                /></div>
                                <div><CardInField
                                    monsterInfo = {setCard(monster1,true)}
                                    classes={classes}
                                /></div>
                                <div><CardInField
                                    monsterInfo = {setCard(monster2,true)}
                                    classes={classes}
                                /></div>
                                <div><CardInField
                                    monsterInfo = {setCard(monster3,true)}
                                    classes={classes}
                                /></div>
                                <div><CardInField
                                    monsterInfo = {setCard(monster4,true)}
                                    classes={classes}
                                /></div>
                                <div><CardInField
                                    monsterInfo = {setCard(monster5,true)}
                                    classes={classes}
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
                                    monsterInfo = {setCard(currentField.player,true)}
                                    classes={classes}
                                    availableAttackTarget = {availableAttackTarget}
                                    availableMagicTarget = {availableMagicTarget}
                                /></div>
                                <div><CardInField
                                    monsterInfo = {setCard(currentField.monster1,false)}
                                    classes={classes}
                                    availableAttackTarget = {availableAttackTarget}
                                    availableMagicTarget = {availableMagicTarget}
                                /></div>
                                <div><CardInField
                                    monsterInfo = {setCard(currentField.monster2,false)}
                                    classes={classes}
                                    availableAttackTarget = {availableAttackTarget}
                                    availableMagicTarget = {availableMagicTarget}
                                /></div>
                                <div><CardInField
                                    monsterInfo = {setCard(currentField.monster3,false)}
                                    classes={classes}
                                    availableAttackTarget = {availableAttackTarget}
                                    availableMagicTarget = {availableMagicTarget}
                                /></div>
                                <div><CardInField
                                    monsterInfo = {setCard(currentField.monster4,false)}
                                    classes={classes}
                                    availableAttackTarget = {availableAttackTarget}
                                    availableMagicTarget = {availableMagicTarget}
                                /></div>
                                <div><CardInField
                                    monsterInfo = {setCard(currentField.monster5,false)}
                                    classes={classes}
                                    availableAttackTarget = {availableAttackTarget}
                                    availableMagicTarget = {availableMagicTarget}
                                /></div>

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