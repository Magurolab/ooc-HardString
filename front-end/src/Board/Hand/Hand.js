import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import GridList, { GridListTile, GridListTileBar } from 'material-ui/GridList';

import Card, { CardActions, CardContent, CardMedia } from 'material-ui/Card';

import Button from 'material-ui/Button';
import Typography from 'material-ui/Typography';

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
    card: {
        maxWidth: '8vw',
    },
    media: {
        height: '12vw',
    },
});



function Hand(props) {
    const { classes } = props;

    return (
        <div className={classes.root}>
            <GridList className={classes.gridList} cols={2.5}>
                {DemoCards.map(tile => (
                    <GridListTile key={tile.img}>
                        <img src={tile.img} alt={tile.title} />
                        <GridListTileBar
                            title={tile.title}
                            classes={{
                                root: classes.titleBar,
                                title: classes.title,
                            }}
                            actionIcon={

                                <Card className={classes.card}>
                                    <CardMedia
                                        className={classes.media}
                                        image={tile.img}
                                        title={tile.title + "\nattack " +
                                        tile.attack + "\nhealth " +
                                        tile.health}

                                    />
                                    <CardActions>
                                        <Button size="small" color="primary">
                                            Summon
                                        </Button>

                                    </CardActions>
                                </Card>
                            }
                        >
                        </GridListTileBar>
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