-- customers
INSERT INTO customer (name) VALUES ('Alice');
INSERT INTO customer (name) VALUES ('Bob');
INSERT INTO customer (name) VALUES ('Chloe');
INSERT INTO customer (name) VALUES ('David');
INSERT INTO customer (name) VALUES ('Edward');


-- books
INSERT INTO rentable ( dtype, author, title) VALUES ( 'Book', 'Jane Austen', 'Pride and Prejudice');
INSERT INTO rentable ( dtype, author, title) VALUES ( 'Book', 'William Shakespeare', 'Romeo and Juliet');
INSERT INTO rentable ( dtype, author, title) VALUES ( 'Book', 'Lewis Carroll', 'Alice''s Adventures in Wonderland');


-- audiobooks
INSERT INTO rentable (dtype, author, title, speaker) VALUES ('AudioBook', 'Washington Irving', 'The Legend of Sleepy Hollow', 'Fiona');
INSERT INTO rentable (dtype, author, title, speaker) VALUES ('AudioBook','F. Scott Fitzgerald', 'The Great Gatsby', 'Gerrit');
INSERT INTO rentable (dtype, author, title, speaker) VALUES ('AudioBook','Bram Stoker', 'Dracula', 'Herman');


-- active borrows
INSERT INTO borrow (rentable_id, customer_id, due_date) VALUES (1, 1, '2024-01-01');
INSERT INTO customer_borrows (borrows_id, customer_id) VALUES (1, 1);

INSERT INTO borrow (rentable_id, customer_id, due_date) VALUES (4, 2, '2024-08-01');
INSERT INTO customer_borrows (borrows_id, customer_id) VALUES (2, 2);


-- returned borrows
INSERT INTO borrow (rentable_id, customer_id, due_date, return_date) VALUES (2, 1, '2024-7-01', '2024-10-01');
INSERT INTO customer_borrows (borrows_id, customer_id) VALUES (3, 1);

INSERT INTO borrow (rentable_id, customer_id, due_date, return_date) VALUES (5, 3, '2024-10-01', '2024-10-03');
INSERT INTO customer_borrows (borrows_id, customer_id) VALUES (4, 3);