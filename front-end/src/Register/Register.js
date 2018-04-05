import React, { Component } from "react";
import {
    Button, FormGroup, FormControl, ControlLabel, Navbar, Nav, NavItem, NavDropdown,
    MenuItem, ProgressBar
} from "react-bootstrap";
import "./Register.css";

const wellStyles = { maxWidth: 400, margin: '0 auto 10px' };
export default class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: "",
            password: ""
        };
    }

    validateForm() {
        return this.state.email.length > 0 && this.state.password.length > 0;
    }

    handleChange = event => {
        this.setState({
            [event.target.id]: event.target.value
        });
    }

    handleSubmit = event => {
        event.preventDefault();
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
                <div className="register">
                    <ProgressBar now={60} />
                    <form onSubmit={this.handleSubmit}>
                        <FormGroup controlId="email" bsSize="large">
                            <ControlLabel>Username</ControlLabel>
                            <br/>
                            <FormControl
                                autoFocus
                                // type="email"
                                value={this.state.email}
                                onChange={this.handleChange}
                            />
                        </FormGroup>
                        <FormGroup controlId="password" bsSize="large">
                            <ControlLabel>Password</ControlLabel>
                            <br/>
                            <FormControl
                                value={this.state.password}
                                onChange={this.handleChange}
                                type="password"
                            />
                        </FormGroup>

                        <Button bsStyle="primary" bsSize="large" block
                                disabled={!this.validateForm()}
                                type="submit">

                            Login
                        </Button>
                        <Button bsSize="large" block bsStyle="success">
                            Register
                        </Button>
                    </form>
                </div>

            </div>
        );
    }
}
