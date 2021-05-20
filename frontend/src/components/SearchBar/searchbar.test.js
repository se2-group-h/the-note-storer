import {getByTestId, render} from "@testing-library/react";
import SearchBar from './searchbar.js';

test("check search button", () => {
    const {queryByTitle} = render(
        <SearchBar/>
    );
    const btn = queryByTitle("searchbtn");
    expect(btn).toBeTruthy();
});

test("check searchbar", () => {
    const { queryByTitle } = render(<SearchBar />);
    
    const searchInput = queryByTitle("Searcher");
    expect(searchInput).toBeTruthy();
});