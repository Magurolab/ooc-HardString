import React from 'react';
// import NULL from '../cards_img/cardf.png';
// import GEM from '../cards_img/gem.jpg';
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import Card, { CardActions, CardContent, CardMedia } from 'material-ui/Card';
import Button from 'material-ui/Button';
import Typography from 'material-ui/Typography';
import TargetInFieldPointer from './InFieldPointer/TargetInFieldPointer.js'
// import DemoCards from "../../Hand/DemoCards";

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
        height: '196px', //The size is fixed.
        // height:'4vw', //Resizable but look shity when does.
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
        field: null,
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
        const {monsterInfo , classes, availableAttackTarget, availableMagicTarget} = this.props;
        if(monsterInfo === undefined){
            return(<div>Card Loading..</div>);
        }
        const {img, title, empty, enemy} = monsterInfo;
        console.log("MonsterInfo", monsterInfo);
        console.log(img);
        // console.log("Idex:",idex );
    return (

        <div className={root}>

            {/*boolean ? (true) : (false)*/}
            {empty ? (
                <Card className={classes.card}>
                    <CardMedia
                        className={classes.media}
                        image={""}
                        title={""}
                        key={""}
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

                        <TargetInFieldPointer
                            availableAttackTarget ={availableAttackTarget}
                        />


                    )}


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
