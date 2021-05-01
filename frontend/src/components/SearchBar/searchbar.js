import React from 'react';
import './searchbar.css';

const SearchBar = () => (
    <form action="/" method="get">
    <div className="container">
        <input
            type="text"
            id="header-search"
            placeholder="Search"
            name="s"
        />
        <button type="submit">Search</button>
    </div>
    </form>
);

export default SearchBar