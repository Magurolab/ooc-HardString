import React, {Component} from 'react'

export function withUserId(BaseComponent, ...props) {
    return class NewComponent extends Component{

        state = {
            userId: 0,
        }

        render() {
            return (
                <BaseComponent userId={this.state.userId} {...props} />
            )
        }
    }
}