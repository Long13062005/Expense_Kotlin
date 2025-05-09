create database expense_database;

CREATE TABLE User (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE Category (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    icon VARCHAR(100)
);

CREATE TABLE Budget (
    id INT PRIMARY KEY,
    username VARCHAR(50),
    category_id INT,
    limit_amount DOUBLE NOT NULL,
    period VARCHAR(50),
    FOREIGN KEY (username) REFERENCES User(username),
    FOREIGN KEY (category_id) REFERENCES Category(id)
);

CREATE TABLE Transaction (
    id INT PRIMARY KEY,
    amount DOUBLE NOT NULL,
    type VARCHAR(50) NOT NULL,
    date_created DATE NOT NULL,
    note TEXT,
    username VARCHAR(50),
    category_id INT,
    FOREIGN KEY (username) REFERENCES User(username),
    FOREIGN KEY (category_id) REFERENCES Category(id)
);

CREATE TABLE Report (
    id INT PRIMARY KEY,
    username VARCHAR(50),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    note TEXT,
    FOREIGN KEY (username) REFERENCES User(username)
);

CREATE TABLE Feedback (
    id INT PRIMARY KEY,
    username VARCHAR(50),
    content TEXT NOT NULL,
    date_created DATE NOT NULL,
    response TEXT,
    FOREIGN KEY (username) REFERENCES User(username)
);

-- Budget
INSERT INTO Budget (id, username, category_id, limit_amount, period) 
VALUES (1, 'johndoe', 3, 5000.00, 'Monthly');

-- Category
INSERT INTO Category (id, name, description, icon) 
VALUES (3, 'Travel', 'Expenses for trips and vacations', '🧳');

-- Transaction
INSERT INTO Transaction (id, amount, type, date_created, note, username, category_Id) 
VALUES (101, 120.50, 'Expense', '2025-03-13', 'Taxi fare', 'johndoe', 3);

-- User
INSERT INTO User (username, password, email, role_name) 
VALUES ('johndoe', '123123', 'johndoe@example.com', 'Regular');

-- Report
INSERT INTO Report (id, username, start_date, end_date, note) 
VALUES (2001, 'johndoe', '2025-03-01', '2025-03-10', 'March Expense Summary');

-- Feedback
INSERT INTO Feedback (id, username, content, date_created, response) 
VALUES (3001, 'johndoe', 'The app needs more intuitive budgeting tools.', '2025-03-13', 'Thank you! We’ll consider this in future updates.');

