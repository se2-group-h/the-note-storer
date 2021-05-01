import {getByTestId, render} from "@testing-library/react";
import Signinform from './signinform.js';

test("check sign in button", () => {
    const {queryByTitle} = render(
        <Signinform/>
    );
    const btn = queryByTitle("signinbutn");
    expect(btn).toBeTruthy();
});

it("button content sign in", () => {
    const {queryByTitle} = render(
        <Signinform/>
    );
    const btn = queryByTitle("signinbutn");
    expect(btn).toHaveTextContent("Sign-In");
});

it("image check", () => {
    const {queryByTitle} = render(
        <Signinform/>
    );
    const imge = queryByTitle("imageright");
    expect(imge).toHaveAttribute('width', '400');
    expect(imge).toHaveAttribute('height', '510');
});


