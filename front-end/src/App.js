import React, { Component } from 'react';
import './App.css';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import  createMuiTheme from 'material-ui/styles/createMuiTheme';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Board from './Board/Board.js';

const theme = createMuiTheme();

class App extends Component {

  render() {
    return (
        <MuiThemeProvider theme = { theme }>
            <Router>
                <Route exact path="/" exact component={ Board } />
            </Router>
        </MuiThemeProvider>
    );
  }
}

export default App;
