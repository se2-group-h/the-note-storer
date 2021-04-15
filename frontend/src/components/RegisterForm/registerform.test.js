import {getByTestId, render} from "@testing-library/react";
import RegisterForm from './registerform.js';

test("check sign up button", () => {
    const { queryByTitle } = render(
    <RegisterForm />
    );
    const btn = queryByTitle("signupbutn");
    expect(btn).toBeTruthy();
});

it("button content sign up", ()=>{
    const { queryByTitle } = render(
        <RegisterForm />
    );
    const btn = queryByTitle("signupbutn");
    expect(btn).toHaveTextContent("Sign-Up");
});

it("image check", ()=>{
    const { queryByTitle } = render(
        <RegisterForm />
    );
    const imge = queryByTitle("imageright");
    expect(imge).toHaveAttribute('width','400');
    expect(imge).toHaveAttribute('height','510');
});



