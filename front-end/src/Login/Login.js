import React, { Component } from "react";
import {
    Button, FormGroup, FormControl, ControlLabel, Navbar, Nav, NavItem, NavDropdown,
    MenuItem
} from "react-bootstrap";
// import { Button, FormGroup, Form } from 'reactstrap';
import "./Login.css";
import loginAPI from '../api/LoginAPI.js';
// import 'bootstrap/dist/css/bootstrap.min.css'


const wellStyles = { maxWidth: 400, margin: '0 auto 10px' };
export default class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {
            username: "",
            password: ""
        };
    }



    validateForm() {
        return this.state.username.length > 0 && this.state.password.length > 0;
    }

    handleChangeUsername = event => {
        this.setState({
            username: event.target.value
        });
        // console.log(this.state.username);
    }
    handleChangePassword = event => {
        this.setState({
            password: event.target.value

        });
        // console.log(this.state.password);
    }

    // handleSubmit = event => {
    //     event.preventDefault();
    //
    // }
    onSubmitData = () => {
        console.log("hey about to sned this is  not a trick");
        const {username, password} = this.state;
        loginAPI.login(username, password)
            .then(response => console.log(response))
    }

    render() {
        return (
            <div className="navbar" >
               <div>
                   <Navbar inverse collapseOnSelect >
                       <Navbar.Header>
                           <Navbar.Brand>
                               <a href="#brand">React-Bootstrap</a>
                           </Navbar.Brand>
                           <Navbar.Toggle />
                       </Navbar.Header>
                       <Navbar.Collapse>
                           <Nav>
                               <NavItem eventKey={1} href="#">
                                   Link
                               </NavItem>
                               <NavItem eventKey={2} href="#">
                                   Link
                               </NavItem>

                           </Nav>
                           <Nav pullRight>
                               <NavDropdown eventKey={3} title="contact us" id="basic-nav-dropdown">
                                   <MenuItem eventKey={3.1} href="mailto:kmkanokpon3@gmail.com?subject=I would like to suggest something">suggestion</MenuItem>
                                   <MenuItem eventKey={3.2} href="mailto:kmkanokpon3@gmail.com?subject=I would like to submit a bug report">report bug</MenuItem>
                                   <MenuItem eventKey={3.3} href="mailto:kmkanokpon3@gmail.com?Body=Hello">Something else</MenuItem>
                               </NavDropdown>
                           </Nav>
                       </Navbar.Collapse>
                     </Navbar>


                   </div>
                <div className="login">
                <form >
                    {/*<FormGroup controlId="email" bsSize="large">*/}
                        <ControlLabel>Username</ControlLabel>
                        <br/>
                        <FormControl
                            // autoFocus
                            // type="email"
                            value={this.state.username}
                            onChange={this.handleChangeUsername}
                        />
                    </form>
                    {/*</FormGroup>*/}
                    {/*<FormGroup controlId="password" bsSize="large">*/}
                    <form>
                        <ControlLabel>Password</ControlLabel>
                        <br/>
                        <FormControl
                            value={this.state.password}
                            onChange={this.handleChangePassword}
                            type="password"
                        />
                    {/*</FormGroup>*/}
                    </form>

                        <Button bsStyle="primary" bsSize="large" block
                                disabled={!this.validateForm()}
                                type="submit"
                                onClick={ this.onSubmitData }
                                // onSubmit={ this.onSubmitData }
                        >

                            Login
                        </Button>
                        <Button bsSize="large" block bsStyle="success" onClick={() => this.props.history.push("/register")}>
                            Register
                        </Button>

                </div>
            </div>
        );
    }
}
