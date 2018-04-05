import React, {Component} from 'react';
import Board from './Board/Board.js';
import Login from './Login/Login.js';
import Register from './Register/Register.js';
import Ready from './Ready.js';
import './index.css';
import './App.css';
import LoginAPI from "./api/LoginAPI.js";

import {BrowserRouter as Router, Route} from 'react-router-dom';
import {AuthProvider, AuthRoute} from 'react-router-auth-provider'
import {createMuiTheme, MuiThemeProvider} from 'material-ui';


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
    return (
        <MuiThemeProvider theme = { theme }>
            <Router>
                <div className={"hugeBoy"}>
                    <Route exact path="/login" component={ Login } />
                    <Route exact path="/" component={ Board } />
                    <Route exact path="/register" component={ Register } />
                    <Route exact path="/ready" component={ Ready }/>
                </div>
            </Router>
        </MuiThemeProvider>
    );
  }
        <AuthRoute
            loginRoute="/login"
            {...props}
        />

}

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            currentUserID: "",
        };
    }



    render() {
        const { currentUserID } = this.state;
        const functer = this.some_function; // NOTE : No ()
        return (
            <MuiThemeProvider theme={theme}>
                <Router>
                    <div className={"hugeBoy"}>

                        <MyAuthProvider>

                            <Route exact path="/login" component={Login}/>
                            <Route exact path="/" component={Login}/>
                            <Route exact path="/register" component={Register}/>
                            <MyAuthRoute exact path="/board" component={Board}/>

                        </MyAuthProvider>


                    </div>
                </Router>
            </MuiThemeProvider>
        );
    }
}

export default App;
