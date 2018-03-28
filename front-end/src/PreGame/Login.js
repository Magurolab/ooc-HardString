import { withStyles } from 'material-ui/styles';
import PropTypes from 'prop-types';
import React from 'react';

const styles = theme => ({
    root: {
        display: 'flex',
    },

});
class Login extends React.Component {

    render() {
        return (
            <div>
                login
            </div>
        );
    }
}

Login.propType ={
    classes: PropTypes.object.isRequired,
};
export default withStyles(styles)(Login);