import React from 'react';
import Button from 'material-ui/Button';
import Menu, { MenuItem } from 'material-ui/Menu';
import PropTypes from 'prop-types';

class TargetInFieldPointer extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            anchorEl: null,
            type:props.type,
            availableAttackTarget: props.availableAttackTarget,

        }
    };

    handleClick = event => {
        this.setState({ anchorEl: event.currentTarget });
    };

    handleClose = () => {
        this.setState({ anchorEl: null });
    };



    render() {
        const { anchorEl, availableAttackTarget } = this.state;

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
                            <MenuItem onClick={this.handleClose}>{each}</MenuItem>
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