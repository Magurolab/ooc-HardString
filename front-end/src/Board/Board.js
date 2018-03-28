import React from 'react'
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import {Grid, Paper} from 'material-ui'
// import Card, { CardActions, CardContent } from 'material-ui/Card';


import Drawer from 'material-ui/Drawer';
import AppBar from 'material-ui/AppBar';
import Toolbar from 'material-ui/Toolbar';
import List from 'material-ui/List';
import { MenuItem } from 'material-ui/Menu';
import TextField from 'material-ui/TextField';
import Typography from 'material-ui/Typography';
import Divider from 'material-ui/Divider';

import Field from './Field/Field.js';
import Sidebar from './Sidebar/Sidebar.js';
import Hand from './Hand/Hand.js';
import {mailFolderListItems, otherMailFolderListItems} from "./Sidebar/tileData";

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
        height: 430,
        zIndex: 1,
        overflow: 'hidden',
        position: 'relative',
        display: 'flex',
    },
    appBar: {
        // zIndex: theme.zIndex.drawer + 1,
    },
    drawerPaper: {
        position: 'relative',
        width: drawerWidth,
    },
    content: {
        flexGrow: 1,
        // backgroundColor: theme.palette.background.default,
        // padding: theme.spacing.unit * 3,
        minWidth: 0, // So the Typography noWrap works
    },
    // toolbar: theme.mixins.toolbar,
});


class Board extends React.Component{

    constructor(props){
        super(props);
        this.state = {open: true};
    }

    render(){
        const { classes } = this.props;
        return (
            <div className={classes.root}>
                {/*<AppBar position="absolute" className={classes.appBar}>*/}
                    {/*<Toolbar>*/}
                        {/*<Typography variant="title" color="inherit" noWrap>*/}
                            {/*Clipped drawer*/}
                        {/*</Typography>*/}
                    {/*</Toolbar>*/}
                {/*</AppBar>*/}
                <Drawer
                    anchor='relative-right'
                    variant="permanent"
                    classes={{
                        paper: classes.drawerPaper,
                    }}
                >
                    <div className={classes.toolbar} />
                    <List>{mailFolderListItems}</List>
                    <Divider />
                    <List>{otherMailFolderListItems}</List>
                </Drawer>
                <main className={classes.content}>
                    <div className={classes.toolbar} />


                        <Grid container spacing={12}>
                            <Grid item xs={12} >

                             <Field/>

                            </Grid>
                        </Grid>

                        <div><br/><br/></div>

                        <Grid container spacing={12} className={classes.g}>

                            <Hand/>

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
