drop table if exists cliente CASCADE;
drop table if exists produto CASCADE;
drop table if exists pedido CASCADE;
drop table if exists pedido_produto CASCADE;

CREATE TABLE cliente (
	id serial PRIMARY KEY,
	nome VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL
);

CREATE TABLE produto (
	id serial PRIMARY KEY,
	nome VARCHAR ( 50 ) NOT NULL,
	descricao TEXT NOT NULL,
	quantidade INTEGER NOT NULL,
	data_cadastro DATE,
	preco DECIMAL NOT NULL
);

CREATE TABLE pedido (
	id serial PRIMARY KEY,
	id_cliente INTEGER,
	data_pedido DATE,
	FOREIGN KEY(id_cliente) REFERENCES cliente(id)
);

CREATE TABLE pedido_produto (
	id serial PRIMARY KEY,
	id_pedido INTEGER,
	id_produto INTEGER,
	quantidade INTEGER,
	preco DECIMAL,
	FOREIGN KEY (id_pedido) REFERENCES pedido(id),
	FOREIGN KEY (id_produto) REFERENCES produto(id)
);
INSERT INTO cliente(nome, email)
	VALUES('Danieli', 'Danieli@email.com'), ('Danilo', 'danilo@email.com'), ('Claudia', 'claudia@email.com'), ('Rafaella', 'rafa@email.com');

INSERT INTO produto(nome, descricao, quantidade, data_cadastro, preco)
	VALUES('mesa', 'mesa em MDF (120x70cm)', 14, '2022-05-04', 588.54), ('mouse', 'mouse gamer, cor: preto e vermelho', 24, '2022-05-04', 58.54), ('teclado', 'teclado gamer, cor: preto e azul, com leds', 57, '2022-05-04', 168.45);

INSERT INTO pedido(id_cliente, data_pedido)
	VALUES('2', '2022-05-05'), ('1', '2022-05-06'), ('4', '2022-05-05'), ('2', '2022-05-07'), ('3', '2022-05-05');

INSERT INTO pedido_produto(id_pedido, id_produto, quantidade, preco)
	VALUES(1, 2, 1, 58.54), (1, 3, 1, 168.45), (2, 1, 1, 588.54), (2, 3, 1, 168.45), (3, 1, 1, 588.54), (3, 2, 1, 58.54), (3, 3, 1, 168.45), (4, 2, 1, 58.54), (5, 1, 1, 588.54), (5, 3, 1, 168.45);