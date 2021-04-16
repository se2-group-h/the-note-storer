import {render} from "@testing-library/react";
import {MemoryRouter} from 'react-router-dom';

import Navbar from './navbar';
it("check register render", ()=>{
    const { queryByTitle } = render(
    <MemoryRouter>
    <Navbar />
    </MemoryRouter>
    );
    const btn = queryByTitle("signupbtn");
    expect(btn).toBeTruthy();
});

it("check signin render", ()=>{
    const { queryByTitle } = render(
    <MemoryRouter>
    <Navbar />
    </MemoryRouter>
    );
    const btn = queryByTitle("signinbtn");
    expect(btn).toBeTruthy();
});

it("button content sign up", ()=>{
    const { queryByTitle } = render(
        <MemoryRouter>
    <Navbar />
    </MemoryRouter>
    );
    const btn = queryByTitle("signupbtn");
    expect(btn).toHaveTextContent("Register");
});

it("button content sign in", ()=>{
    const { queryByTitle } = render(
        <MemoryRouter>
    <Navbar />
    </MemoryRouter>
    );
    const btn = queryByTitle("signinbtn");
    expect(btn).toHaveTextContent("Sign-In");
});