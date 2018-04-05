import React from 'react';
import Button from 'material-ui/Button';
import Menu, { MenuItem } from 'material-ui/Menu';
import PropTypes from 'prop-types';

class TargetPointer extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            anchorEl: null,
            type:props.type,
            availableMonsterField: props.availableMonsterField,
            availableMagicTarget: props.availableMagicTarget,

    }
    };

    handleClick = event => {
        this.setState({ anchorEl: event.currentTarget });
    };

    handleClose = () => {
        this.setState({ anchorEl: null });
    };



    render() {
        const { anchorEl, type,availableMonsterField,availableMagicTarget } = this.state;
        const actionText = type === 'Monster' ? 'Summon' : 'use';

        if(type === 'Monster') {
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
                            <MenuItem onClick={this.handleClose}>{each}</MenuItem>
                        ))}


                    </Menu>
                </div>
            );
        }

        else{
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
                            <MenuItem onClick={this.handleClose}>{each}</MenuItem>
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