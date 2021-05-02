import {getByTestId, render} from "@testing-library/react";
import SignInForm from './signInForm.js';

test("check sign in button", () => {
    const {queryByTitle} = render(
        <SignInForm/>
    );
    const btn = queryByTitle("signinbutn");
    expect(btn).toBeTruthy();
});

it("button content sign in", () => {
    const {queryByTitle} = render(
        <SignInForm/>
    );
    const btn = queryByTitle("signinbutn");
    expect(btn).toHaveTextContent("Sign-In");
});

it("image check", () => {
    const {queryByTitle} = render(
        <SignInForm/>
    );
    const imge = queryByTitle("imageright");
    expect(imge).toHaveAttribute('width', '400');
    expect(imge).toHaveAttribute('height', '510');
});


