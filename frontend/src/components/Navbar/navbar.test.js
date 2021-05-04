import {render} from "@testing-library/react";
import {MemoryRouter} from 'react-router-dom';

import Navbar from './navbar';
test("check register render", ()=>{
    const { queryByTitle } = render(
    <MemoryRouter>
    <Navbar />
    </MemoryRouter>
    );
    const btn = queryByTitle("signupbtn");
    expect(btn).toBeTruthy();
});

test("check signin render", ()=>{
    const { queryByTitle } = render(
    <MemoryRouter>
    <Navbar />
    </MemoryRouter>
    );
    const btn = queryByTitle("signinbtn");
    expect(btn).toBeTruthy();
});

test("button content sign up", ()=>{
    const { queryByTitle } = render(
        <MemoryRouter>
    <Navbar />
    </MemoryRouter>
    );
    const btn = queryByTitle("signupbtn");
    expect(btn).toHaveTextContent("Register");
});

test("button content sign in", ()=>{
    const { queryByTitle } = render(
        <MemoryRouter>
    <Navbar />
    </MemoryRouter>
    );
    const btn = queryByTitle("signinbtn");
    expect(btn).toHaveTextContent("Sign-In");
});