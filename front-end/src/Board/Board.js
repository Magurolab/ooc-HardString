import React from 'react'
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import {Grid} from 'material-ui'
import Drawer from 'material-ui/Drawer';
import List, {ListItem, ListItemIcon, ListItemText} from 'material-ui/List';
import InboxIcon from 'material-ui-icons/MoveToInbox';
import Divider from 'material-ui/Divider';
import BoardAPI from '../api/BoardAPI'; // import
import Field from './Field/Field.js';
import Hand from './Hand/Hand.js';
import {otherMailFolderListItems} from "./Sidebar/tileData";

const drawerWidth = 240;
const styles = theme => ({

    paper: {
        padding: 20, marginTop: 10, marginButton: 10, marginLeft: 5, marginRight:5,
    },

    g: {
        display: "inline-block",
    },
    root: {
        flexGrow: 1,
        // height: 430,
        height:'100%',
        zIndex: 1,
        overflow: 'hidden',
        position: 'relative',
        display: 'flex',
    },

    drawerPaper: {
        position: 'relative',
        width: drawerWidth,
    },
    content: {
        flexGrow: 1,
        minWidth: 0, // So the Typography noWrap works
    },
    field_holder: {
        display: 'flex',
        flexWrap: 'nowrap',
        flexGrow: 1,
    },

});
function TurnBar(props){
    const {turn} = props;
    return (
        <ListItem text >
            {turn ? "Your Turn" : "Other Turn"}
        </ListItem>
    )
}

function DeckBar(props){
    const {deck, maxDeck} = props;
    return (
        <ListItem text>
            DECK: {deck}/{maxDeck}
        </ListItem>
    )
}

function ManaBar(props){
    const {mana, maxMana} = props;
    return (
        <ListItem text>
            MANA : {mana}/{maxMana}
        </ListItem>
    )
}

function HealthBar(props) {
    const {health, maxHealth} = props;
    return (
        <ListItem text>
            HEALTH: {health}/{maxHealth}
        </ListItem>
    )
}

function EndTern(props) {
    const { onClick } = props;
    return (
        <ListItem button onClick={onClick}>
            <ListItemIcon>
                <InboxIcon />
            </ListItemIcon>
            <ListItemText primary="ENDTURN" />
        </ListItem>
    )
}

function StatusBar(props){
    const {endTurn, deck, maxDeck, health, maxHealth, mana, maxMana, turn} = props;
    return (
        <div>
            <TurnBar turn={turn}/>
            <DeckBar deck={deck} maxDeck={maxDeck}/>
            <ManaBar mana={mana} maxMana={maxMana} />
            <HealthBar health={health} maxHealth={maxHealth} />
            <EndTern onClick={endTurn} />
        </div>
    )
}


class Board extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            open: true,
            id: undefined,
            name: "",
            deck: 0,
            maxDeck: 30,
            mana: 0,
            maxMana: 10,
            health: 0,
            maxHealth: 10,
            currentHand: [],
            intervalPointer: undefined,
            dead: undefined,
            currentField: undefined,
            enemyField: undefined,
            availableMagicTarget:[],
            availableMonsterField:[],
            availableAttackTarget:[],


        };
    }

    onRageQuit = () => {

    };

    onEndTurn = () => {

    };

    initBoard = () => {
        // BoardAPI.fakeGame().catch(e => {alert("init Baord failed"); console.log(e); } )
    };

    componentWillMount(){
        this.getBoard();
    }

    componentDidMount(){
        this.state.intervalPointer = setInterval(this.getBoard, 3000);
    }

    componentWillUnmount(){
        clearInterval(this.state.intervalPointer);
    }

    getBoard = () =>{
        BoardAPI.showBoard()
            .then(({data, status}) => {
                // console.log(data);
                // a, b = [aa, bb]
                // const mana = data.currentPlayerMana
                const { availableMagicTarget,
                    availableMonsterField,
                    currentField,
                    currentHand: hand ,
                    turn:turn ,
                    currentPlayerMana: mana,
                    currentDeck,
                    enemyField,
                    availableAttackTarget
                } = data;

                const { player: { maxHP, name, dead, hp } } = currentField;

                this.setState(({
                    mana,
                    health: hp,
                    maxHealth: maxHP,
                    name: name,
                    dead: dead,
                    deck: currentDeck,
                    turn: turn,
                    currentHand: hand,
                    enemyField,
                    currentField,
                    availableMagicTarget,
                    availableMonsterField,
                    availableAttackTarget,


                }), () => console.log("state", this.state));
            })
            .catch((e) => {
                // alert("Shit happens in Show board");
                console.log(e);
            })
    };

    render(){
        const { classes } = this.props;
        console.log("Field",this.state.currentField);
        return (
            <div className={classes.root}>
                <Drawer
                    anchor='relative-right'
                    variant="permanent"
                    classes={{
                        paper: classes.drawerPaper,
                    }}
                >
                    <div className={classes.toolbar} />

                    <List>
                        <StatusBar endTurn={this.onEndTurn()} {...this.state}  />
                    </List>
                    <Divider />
                    <List>{otherMailFolderListItems}</List>
                </Drawer>
                <main className={classes.content}>
                    <div className={classes.toolbar} />


                        <Grid className = "field_holder" container spacing={12} >

                            <Grid item xs={12} >

                            <Field currentField={this.state.currentField}
                                   enemyField = {this.state.enemyField}
                                   availableAttackTarget = {this.state.availableAttackTarget}
                                   availableMagicTarget = {this.state.availableMagicTarget}

                            />

                            </Grid>
                        </Grid>

                        <div><br/><br/></div>

                        <Grid container spacing={12} className={classes.g}>

                            {/*{console.log(this.state.currentHand)}*/}
                            <Hand
                                hand={this.state.currentHand}
                                availableMagicTarget={this.state.availableMagicTarget}
                                availableMonsterField={this.state.availableMonsterField}
                            />

                        </Grid>
                </main>
            </div>


        );
    }
}

Board.propTypes = {
    classes: PropTypes.object.isRequired
};

export default withStyles(styles)(Board);
