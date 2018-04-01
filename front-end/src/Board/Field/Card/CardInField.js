import React from 'react';
// import NULL from '../cards_img/cardf.png';
// import GEM from '../cards_img/gem.jpg';
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import Card, { CardActions, CardContent, CardMedia } from 'material-ui/Card';
import Button from 'material-ui/Button';
import Typography from 'material-ui/Typography';
import DemoCards from "../../Hand/DemoCards";

import Menu, { MenuItem } from 'material-ui/Menu';

const styles = theme => ({
    root: {
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'space-around',
        overflow: 'hidden',
        textAlign: 'center',
        backgroundColor: theme.palette.background.paper,
    },
    card: {


        minHeight:'100px',
        minWidth:'100%',



    },
    media: {

        minHeight: '8vw',
        minWidth: ' 4vw',

    },
    text:{
        align: 'center',

    },
    button:{
        align: 'center',
    },
});


class CardField extends React.Component {

    state = {
        anchorEl: null,
    };

    handleClick = event => {
        this.setState({ anchorEl: event.currentTarget });
    };

    handleClose = () => {
        this.setState({ anchorEl: null });
    };
    render(){
        // console.log(this.props);
        const { anchorEl } = this.state;
        const {img, classes, title, empty, enemy} = this.props;

        // console.log("Idex:",idex );
    return (

        <div className={root}>

            {empty ? (
                <Card className={classes.card}>
                    <CardMedia
                        className={classes.media}
                        // image={img}
                        // title={title}
                        // key={title}
                    />
                    <CardContent className = "text">
                        <Typography gutterBottom variant="headline" component="h2">

                        </Typography>
                        <Typography component="p">
                            EMPTY
                            SLOT
                            {/*{title}*/}
                        </Typography>
                    </CardContent>
                    <CardActions className = "button">
                        {/*<Button size="small" color="primary">*/}
                            {/*Attack*/}
                        {/*</Button>*/}

                    </CardActions>
                </Card>
            ):(<Card className={classes.card}>
                <CardMedia
                    className={classes.media}
                    image={img}
                    title={title}
                    key={title}
                />
                <CardContent className = "text">
                    <Typography gutterBottom variant="headline" component="h2">

                    </Typography>
                    <Typography component="p">
                        {title}
                    </Typography>
                </CardContent>
                <CardActions className = "button">
                    {enemy ? (""):(
                        <Button
                            aria-owns={anchorEl ? 'simple-menu' : null}
                            aria-haspopup="true"
                            onClick={this.handleClick}
                        >
                            Attack
                        </Button>


                    )}
                    {/*<Button*/}
                        {/*aria-owns={anchorEl ? 'simple-menu' : null}*/}
                        {/*aria-haspopup="true"*/}
                        {/*onClick={this.handleClick}*/}
                    {/*>*/}
                        {/*Attack*/}
                    {/*</Button>*/}
                    <Menu
                        id="simple-menu"
                        anchorEl={anchorEl}
                        open={Boolean(anchorEl)}
                        onClose={this.handleClose}
                    >
                        // TODO: make it fetch data of attackable monster from enemy board
                        <MenuItem onClick={this.handleClose}>Profile</MenuItem>
                        <MenuItem onClick={this.handleClose}>My account</MenuItem>
                        <MenuItem onClick={this.handleClose}>Logout</MenuItem>
                    </Menu>

                </CardActions>
            </Card>)}
        </div>
        );
    }
}



CardField.propTypes = {
    classes: PropTypes.object.isRequired
};

export default withStyles(styles)(CardField);
