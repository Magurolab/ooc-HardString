import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import injectTapEventPlugin from 'react-tap-event-plugin';
import 'bootstrap/dist/css/bootstrap.min.css'

// Needed for onTouchTap
// http://stackoverflow.com/a/34015469/98894
injectTapEventPlugin();

const sty = {

};


function Main() {
    return (<App style={sty}/>)
}
ReactDOM.render(<Main />, document.getElementById('root'));
registerServiceWorker();