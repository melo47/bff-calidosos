INSERT INTO users (id, username, password, role) VALUES (1, 'userName1', 'asdfiojwerSDDF1', 'admin');
INSERT INTO users (id, username, password, role) VALUES (2, 'userName2', 'adsfgsdferw', 'user');
INSERT INTO users (id, username, password, role) VALUES (3, 'userName3', 'dsfdsfew2', 'user');
INSERT INTO users (id, username, password, role) VALUES (4, 'userName4', 'dsfsdfxfvc', 'user');
INSERT INTO users (id, username, password, role) VALUES (5, 'userName5', 'sadfas3erd', 'user');

INSERT INTO basic_data (id, username_id, full_name, identification_id) VALUES (1, 1, 'Daniela Rojas Fuentes', '1020392834');

INSERT INTO cards (id, username_id, product_name, card_number, expiration_date, ccv) VALUES (1, 1, 'American express Card', '3778 1098345 50098', '10/27', '233');
INSERT INTO cards (id, username_id, product_name, card_number, expiration_date, ccv) VALUES (2, 1, 'American express Card', '3998 9748345 10898', '11/24', '133');

INSERT INTO cdts (id, username_id, product_name, amount, init_date, end_date, rate) VALUES (1, 1, 'Cdt 12 months', '86.000.000', '01/01/2023', '01/01/2024', '0.11');