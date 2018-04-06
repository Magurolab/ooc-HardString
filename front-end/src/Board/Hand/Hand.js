import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import GridList, { GridListTile, GridListTileBar } from 'material-ui/GridList';
import Card, { CardActions, CardContent, CardMedia } from 'material-ui/Card';
import Button from 'material-ui/Button';
import ImageMapper from '../../ImageMapper';


import TargetPointer from './HandTools/TargetPointer.js';

const styles = theme => ({
    root: {
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'space-around',
        overflow: 'hidden',
        backgroundColor: theme.palette.background.paper,

    },
    gridList: {
        width: 1600,
        height: 450,
        flexWrap: 'nowrap',
        // Promote the list into his own layer on Chrome. This cost memory but helps keeping high FPS.
        transform: 'translateZ(0)',
    },
    card: {
        maxWidth: '15vw',
    },
    media: {
        height: '18vw',
    },
});



function Hand(props) {
    const { classes, hand: currentHand, availableMonsterField, availableMagicTarget } = props;
    // console.log("hand", currentHand.map(e => console.log(e)));
    // this.forceUpdate();
    //console.log('hello', availableMons)
    return (
        <div className={classes.root}>
            <GridList className={classes.gridList} cellHeight={400} cols={5.1}>
                { currentHand.map(tile => (
                    <GridListTile cols={0.8}>

                    <Card className={classes.card}>
                        <CardMedia
                            className={classes.media}
                            // image={"../cards_img/" +tile.name+".png"}
                            image={ImageMapper[tile.name]}
                            title={tile.name+"\nattack "+
                        tile.attack+
                        "\nhealth "
                        + tile.hp
                        }

                        />
                        <CardActions>
                            <TargetPointer
                                cardId={tile.cardId}
                                type={tile.type}
                                availableMonsterField ={availableMonsterField}
                                availableMagicTarget={availableMagicTarget}
                            />
                        </CardActions>
                    </Card>
                    </GridListTile>
                ))}
            </GridList>
        </div>

    );
}

Hand.propTypes = {
    classes: PropTypes.object.isRequired,
    hand: PropTypes.object.isRequired
};

export default withStyles(styles)(Hand);