INSERT INTO users VALUES
  (1, false, 'roma@gmail.com', 'Hookah Man', 'Roman', '$2y$05$v9LrcchS62lVfTHcYZEzjOU/AZkWku9uScnCciH5irIoH9puqZVrq', 'Shevchuk', false ),
  (2, true, 'john@gmail.com', 'John007', 'John', '$2y$05$v9LrcchS62lVfTHcYZEzjOU/AZkWku9uScnCciH5irIoH9puqZVrq', 'Brown', true );

INSERT INTO recipes VALUES
    (1, 1, 'Directions. Preheat oven to 350 degrees F (175 degrees C)...', 'Delicious homemade cookies', 4.4, 'homemade'),
    (2, 2, 'Kill one cow', 'Steak', 5.0, 'fast');

INSERT INTO users_saved_recipes VALUES
    (1,1),
    (2, 2);