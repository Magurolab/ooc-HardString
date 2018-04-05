import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import createMuiTheme from 'material-ui/styles/createMuiTheme';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Board from './Board/Board.js';
import Login from './Login/Login.js';
import Register from './Register/Register.js';
import './index.css';
import './App.css';


const theme = createMuiTheme();


class App extends Component {

  render() {
    return (
        <MuiThemeProvider theme = { theme }>
            <Router>
                <div className={"hugeBoy"}>
                    <Route exact path="/login" component={ Login } />
                    <Route exact path="/" component={ Board } />
                    <Route exact path="/register" component={ Register } />
                </div>
            </Router>
        </MuiThemeProvider>
    );
  }
}

export default App;
