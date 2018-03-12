import React from 'react';
import Box from '../components/box.js';
import {connect} from "react-redux";
import * as actionCreators from "../actions/index.js";

class BoxContainer extends React.Component{
    render(){
        return(
            <Box handleClick={this.props.loadText} content={this.props.content}> </Box>
        )
    }
}


// export default BoxContainer;
const mapStateToProps = (state)=>{return state};

export default connect (mapStateToProps, actionCreators)(BoxContainer)