import React from 'react';
import BoxContainer from "../containers/box-container";

class Box extends React.Component{
    render(){
        return(
            <div className="wrapper">
                <div className='box'>
                    {/*<button> getHello  </button>*/}
                    <button onClick={()=>{this.props.handleClick()}}>Hello</button>
                    {this.props.content + "\n"}
                </div>
            </div>
        )
    }

}
export default Box;