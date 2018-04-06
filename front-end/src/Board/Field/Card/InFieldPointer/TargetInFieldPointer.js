import React from 'react';
import Button from 'material-ui/Button';
import Menu, { MenuItem } from 'material-ui/Menu';
import PropTypes from 'prop-types';
import FieldAPI from "../../../../api/FieldAPI";

class TargetInFieldPointer extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            anchorEl: null,
            // type:props.type,
            // availableAttackTarget: props.availableAttackTarget,

        }
    };

    handleClick = event => {
        this.setState({ anchorEl: event.currentTarget });
    };

    handleClose = () => {
        this.setState({ anchorEl: null });
    };

    handleMenuItemClick = (event, index) => {
        this.setState({selectedIndex: index, anchorEl: null});
        console.log("BEfore axios", this.props.monsterIndex, index);
        FieldAPI.attack(this.props.monsterIndex, index).then(
            // {this.setState(anchorEl: null)}
        );
    };



    render() {
        // const { anchorEl, availableAttackTarget } = this.state;
        const {anchorEl, } = this.state;
        const {availableAttackTarget, cardId} = this.props;

            return (
                <div>
                    <Button
                        aria-owns={anchorEl ? 'simple-menu' : null}
                        aria-haspopup="true"
                        onClick={this.handleClick}
                    >
                        Attack
                    </Button>
                    <Menu
                        id="simple-menu"
                        anchorEl={anchorEl}
                        open={Boolean(anchorEl)}
                        onClose={this.handleClose}
                    >
                        {availableAttackTarget.map(each => (
                            <MenuItem
                                // onClick={this.handleClose}
                                selected={each === this.state.selectedIndex}
                                onClick={event => this.handleMenuItemClick(event, each)}
                            >{each}</MenuItem>
                        ))}


                    </Menu>
                </div>
            );
        }

}

// dropDown.propTypes = {
//     classes: PropTypes.object.isRequired
// };
export default TargetInFieldPointer;