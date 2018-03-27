import React from 'react';
import SimpleMediaCard from './Card';




class Hand extends React.Component{
    state = {
        direction: 'row',
        justify: 'center',
        alignItems: 'center',
    };


    render(){
        return(
            <div>
                Hello form hand
                {/*<SimpleMediaCard/>*/}
                {/*<SimpleMediaCard/>*/}
                {/*<SimpleMediaCard/>*/}
            </div>
        )
    }
}
export default Hand;