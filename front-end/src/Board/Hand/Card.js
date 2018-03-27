import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import Card, { CardActions, CardContent, CardMedia } from 'material-ui/Card';
import Button from 'material-ui/Button';
import Typography from 'material-ui/Typography';

import gem from '../../cards_img/gem.jpg'

const styles = {
    card: {
        maxWidth: 60,
    },
    media: {
        height: 100,
    },
};

function SimpleMediaCard(props) {
    const { classes } = props;
    return (
        <div>
            <Card className={classes.card}>
                <CardMedia
                    className={classes.media}
                    // image="http://shortlink.in/themes/v3/styles/img/url-link.png"
                    image={ gem }
                    title="Contemplative Reptile"
                />
                <CardContent>
                    <Typography gutterBottom variant="headline" component="h2">

                    </Typography>
                    <Typography component="p">
                        GEM
                    </Typography>
                </CardContent>
                <CardActions>

                    <Button size="small" color="primary">
                        Summon
                    </Button>
                </CardActions>
            </Card>
        </div>
    );
}

SimpleMediaCard.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(SimpleMediaCard);