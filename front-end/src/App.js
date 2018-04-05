import React, {Component} from 'react';
import Board from './Board/Board.js';
import Login from './Login/Login.js';
import Register from './Register/Register.js';
import Ready from './Ready.js';
import './index.css';
import './App.css';
import LoginAPI from "./api/LoginAPI.js";
import withUserId from './UserIdentifier.jsx'
import {BrowserRouter as Router, Route} from 'react-router-dom';
import {AuthProvider, AuthRoute} from 'react-router-auth-provider'
import {createMuiTheme, MuiThemeProvider} from 'material-ui';
import WaitingQueue from "./WaitingQueue";


const theme = createMuiTheme();


function MyAuthProvider(props) {
    return (
        <AuthProvider
            whoami={LoginAPI.whoami}
            logout={LoginAPI.logout}
            {...props}
        />
    )
}

function MyAuthRoute(props) {
    return(
        <AuthRoute
            loginRoute="/login"
            {...props}
        />
    )

}

class App extends Component {


    render() {
        return (
            <MuiThemeProvider theme={theme}>
                <Router>
                    <div className={"hugeBoy"}>

                        <MyAuthProvider>

                            <Route exact path="/login" component={Login}/>
                            <Route exact path="/" component={Login}/>

                            <MyAuthRoute exact path="/board" component={Board}/>
                            <MyAuthRoute exact path="/ready" component={ Ready }/>
                            <MyAuthRoute exact path="/waiting" component={ WaitingQueue }/>

                        </MyAuthProvider>


                    </div>
                </Router>
            </MuiThemeProvider>
        );
    }
}

export default App;
