import React from 'react';
import Menu, { MenuItem } from 'material-ui/Menu';
// import MenuItem from 'material-ui/MenuItem';
import { withStyles } from 'material-ui/styles';
import PropTypes from 'prop-types'

// const styles = theme => ({
//     customWidth: {
//         width: 200,
//     },
// });

const styles = theme => ({
    customWidth: {
        width: 200,
    },
    // root: {
    //     display: 'flex',
    //     flexWrap: 'wrap',
    //     justifyContent: 'space-around',
    //     overflow: 'hidden',
    //     backgroundColor: theme.palette.background.paper,
    // },
    // card: {
    //     maxWidth: 345,
    //
    // },
    // media: {
    //     height: 200,
    // },
});

class DropDownIndex extends React.Component {

    constructor(props) {
        super(props);
        this.state = {value: 1};
    }

    handleChange = (event, index, value) => this.setState({value});

    render() {
        return (
            <div>
                <Menu value={this.state.value} onChange={this.handleChange}>
                    <MenuItem value={1} primaryText="Never" />
                    <MenuItem value={2} primaryText="Every Night" />
                    <MenuItem value={3} primaryText="Weeknights" />
                    <MenuItem value={4} primaryText="Weekends" />
                    <MenuItem value={5} primaryText="Weekly" />
                </Menu>
                <br />
                <Menu
                    value={this.state.value}
                    onChange={this.handleChange}
                    style={styles.customWidth}
                    autoWidth={false}
                >
                    <MenuItem value={1} primaryText="Custom width" />
                    <MenuItem value={2} primaryText="Every Night" />
                    <MenuItem value={3} primaryText="Weeknights" />
                    <MenuItem value={4} primaryText="Weekends" />
                    <MenuItem value={5} primaryText="Weekly" />
                </Menu>
            </div>
        );
    }



}


DropDownIndex.propTypes = {
    classes: PropTypes.object.isRequired
};

export default withStyles(styles)(DropDownIndex);