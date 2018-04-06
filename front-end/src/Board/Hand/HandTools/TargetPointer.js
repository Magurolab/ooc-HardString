import React from 'react';
import Button from 'material-ui/Button';
import Menu, { MenuItem } from 'material-ui/Menu';
import PropTypes from 'prop-types';
import HandAPI from '../../../api/HandAPI'
class TargetPointer extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            anchorEl: null,
            selectedIndex: "",
        }
    };

    handleClick = event => {
        this.setState({anchorEl: event.currentTarget});
        console.log("handleClick", this.state.anchorEl);

    };

    handleClose = () => {
        this.setState({anchorEl: null});
        console.log('handle close', this.state.anchorEl);
        // HandAPI.playCard(this.state.cardId, this.state.anchorEl)
    };

    handleMenuItemClick = (event, index) => {
        this.setState({selectedIndex: index, anchorEl: null});
        HandAPI.playCard(this.props.cardId, index)
    };


    render() {
        const {anchorEl, } = this.state;
        const {availableMonsterField, availableMagicTarget, type, index ,cardId} = this.props;

        const actionText = type === 'Monster' ? 'Summon' : 'use';

        if (type === 'Monster') {
            return (
                <div>
                    <Button
                        aria-owns={anchorEl ? 'simple-menu' : null}
                        aria-haspopup="true"
                        onClick={this.handleClick}
                    >
                        Summon
                    </Button>
                    <Menu
                        id="simple-menu"
                        anchorEl={anchorEl}
                        open={Boolean(anchorEl)}
                        onClose={this.handleClose}

                    >
                        {availableMonsterField.map(each => (
                            <MenuItem
                                selected={each === this.state.selectedIndex}
                                onClick={event => this.handleMenuItemClick(event, each)}


                            >{each}</MenuItem>
                        ))}


                    </Menu>
                </div>
            );
        }

        else {
            return (
                <div>
                    <Button
                        aria-owns={anchorEl ? 'simple-menu' : null}
                        aria-haspopup="true"
                        onClick={this.handleClick}
                    >
                        Use
                    </Button>
                    <Menu
                        id="simple-menu"
                        anchorEl={anchorEl}
                        open={Boolean(anchorEl)}
                        onClose={this.handleClose}
                    >


                        {availableMagicTarget.map(each => (
                            <MenuItem
                                selected={each === this.state.selectedIndex}
                                onClick={event => this.handleMenuItemClick(event, each)}


                            >{each}</MenuItem>
                        ))}


                    </Menu>
                </div>
            );
        }

    }
}

// dropDown.propTypes = {
//     classes: PropTypes.object.isRequired
// };
export default TargetPointer;