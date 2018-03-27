import React from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';
import { withStyles } from 'material-ui/styles';
import Drawer from 'material-ui/Drawer';
import AppBar from 'material-ui/AppBar';
import Toolbar from 'material-ui/Toolbar';
import List from 'material-ui/List';
import { MenuItem } from 'material-ui/Menu';
import TextField from 'material-ui/TextField';
import Typography from 'material-ui/Typography';
import Divider from 'material-ui/Divider';
import { mailFolderListItems, otherMailFolderListItems } from './tileData';

const drawerWidth = 240;

const styles = theme => ({
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

function Sidebar(props){

    const { classes } = props;
    return(
            <div className={classes.root}>
              <AppBar position="absolute" className={classes.appBar}>
                <Toolbar>
                  <Typography variant="title" color="inherit" noWrap>
                    Clipped drawer
                  </Typography>
                </Toolbar>
              </AppBar>
              <Drawer
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
                <Typography noWrap>{'You think water moves fast? You should see ice.'}</Typography>
              </main>
              hello world :)
            </div>
          );
}

Sidebar.propTypes = {
    classes: PropTypes.object.isRequired,
  };
  export default withStyles(styles)(Sidebar);