import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import createMuiTheme from 'material-ui/styles/createMuiTheme';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Board from './Board/Board.js';
import './index.css';
import './App.css';

const theme = createMuiTheme();


class App extends Component {

  render() {
    return (
        <MuiThemeProvider theme = { theme }>
            <Router>
                <div className={"hugeBoy"}>
                    <Route exact path="/login" exact component={ Board } />
                    <Route exact path="/" exact component={ Board } />
                </div>
            </Router>
        </MuiThemeProvider>
    );
  }
}

export default App;
