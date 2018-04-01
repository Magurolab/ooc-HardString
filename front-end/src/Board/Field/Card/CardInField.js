import React from 'react';
// import NULL from '../cards_img/cardf.png';
// import GEM from '../cards_img/gem.jpg';
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import Card, { CardActions, CardContent, CardMedia } from 'material-ui/Card';
import Button from 'material-ui/Button';
import Typography from 'material-ui/Typography';
import DemoCards from "../../Hand/DemoCards";


const styles = theme => ({
    root: {
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'space-around',
        overflow: 'hidden',
        backgroundColor: theme.palette.background.paper,
    },
    card: {
        maxWidth: 345,

    },
    media: {
        height: 200,
    },
});


class CardField extends React.Component {

    // const { classes } = props;
    // const {hp} = {hp:this.prop.hp};
    render(){
        // console.log(this.props);
        const {img, classes, title, empty} = this.props;

        // console.log("Idex:",idex );
    return (

        <div className={root}>
            {empty ? (""):(<Card className={classes.card}>
                <CardMedia
                    className={classes.media}
                    image={img}
                    title={title}
                    key={title}
                />
                <CardContent>
                    <Typography gutterBottom variant="headline" component="h2">

                    </Typography>
                    <Typography component="p">
                        {title}
                    </Typography>
                </CardContent>
                <CardActions>
                    <Button size="small" color="primary">
                        Attack
                    </Button>

                </CardActions>
            </Card>)}
        </div>
        );
    }
}



// class CardInField extends React.Component{
//     constructor(props){
//         super();
//         this.state = {
//             index: 0,
//             img: NULL,
//             title:"EMPTY",
//             atk: '',
//             hp: '',
//         };
//         // this.handelChange = this.handelChange.bind(this);
//     }
//     render(){
//         return (
//
//
//                 < CardInField  img = {this.state.img} title ={this.state.title} hp={this.state.hp} atk = {this.state.atk} />
//
//
//         )
//     }
//
//
//
//
// }

CardField.propTypes = {
    classes: PropTypes.object.isRequired
};

export default withStyles(styles)(CardField);
