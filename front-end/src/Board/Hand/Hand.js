import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import GridList, { GridListTile, GridListTileBar } from 'material-ui/GridList';
import Button from 'material-ui/Button';

import DemoCards from './DemoCards.js';

const styles = theme => ({
    root: {
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'space-around',
        overflow: 'hidden',
        backgroundColor: theme.palette.background.paper,
    },
    gridList: {
        flexWrap: 'nowrap',
        // Promote the list into his own layer on Chrome. This cost memory but helps keeping high FPS.
        transform: 'translateZ(0)',
    },

});



function Hand(props) {
    const { classes } = props;

    return (
        <div className={classes.root}>
            <GridList className={classes.gridList} cols={2.5}>
                {DemoCards.map( card => (
                    <GridListTile key={card.img}>
                        <img src={card.img} alt={card.title} />
                        <GridListTileBar
                            title={card.title}
                            classes={{
                                root: classes.titleBar,
                                title: classes.title,
                            }}
                            actionIcon={

                                <Button size="small" color="primary">
                                summon!
                                </Button>
                            }
                        />
                    </GridListTile>
                ))}
            </GridList>
        </div>
    );
}

Hand.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(Hand);