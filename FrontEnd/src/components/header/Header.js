import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faFilm } from "@fortawesome/free-solid-svg-icons";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import NavBar from "react-bootstrap/Navbar";
import { NavLink } from "react-router-dom";

const Header = () => {
  return (
    <NavBar bg="dark" variant="dark" expand="lg">
      <Container fluid>
        <NavBar.Brand href="/" style={{ color: "whitesmoke" }}>
          <FontAwesomeIcon icon={faFilm}>So-so movies</FontAwesomeIcon>
        </NavBar.Brand>
        <NavBar.Toggle aria-controls="navbarScrloll" />
        <NavBar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-2 my-lg-0"
            style={{ maxHeight: "100px" }}
            navbarScroll
          >
            <NavLink className="nav-link" to="/">
              Home
            </NavLink>
          </Nav>
        </NavBar.Collapse>
      </Container>
    </NavBar>
  );
};

export default Header;
