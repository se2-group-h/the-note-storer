import {getByTestId, render} from "@testing-library/react";
import RegisterForm from './registerform.js';

test("check sign up button", () => {
    const {queryByTitle} = render(
        <RegisterForm/>
    );
    const btn = queryByTitle("signupbutn");
    expect(btn).toBeTruthy();
});

test("button content sign up", () => {
    const {queryByTitle} = render(
        <RegisterForm/>
    );
    const btn = queryByTitle("signupbutn");
    expect(btn).toHaveTextContent("Sign-Up");
});

test("image check", () => {
    const {queryByTitle} = render(
        <RegisterForm/>
    );
    const imge = queryByTitle("imageright");
    expect(imge).toHaveAttribute('width', '400');
    expect(imge).toHaveAttribute('height', '510');
});



