import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import createMuiTheme from 'material-ui/styles/createMuiTheme';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Board from './Board/Board.js';
import Login from './PreGame/Login';
const theme = createMuiTheme();


class App extends Component {

  render() {
    return (

        <MuiThemeProvider theme = { theme }>
            <Router>
                <div>
                    <Route exact path="/board" exact component={ Board } />
                    <Route exact path="/login" exact component={Login} />
                    <Route exact path="/" exact component={Login} />
                    {/*<Route exact path="/lobby" exact compoent={Lobby} />*/}
                </div>

            </Router>
        </MuiThemeProvider>

    );
  }
}

export default App;
