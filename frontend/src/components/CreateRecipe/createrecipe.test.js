import {getByTestId, render} from "@testing-library/react";
import RecipeForm from './createrecipe.js';

test("check create button", () => {
    const {queryByTitle} = render(
        <RecipeForm/>
    );
    const btn = queryByTitle("createbtn");
    expect(btn).toBeTruthy();
});