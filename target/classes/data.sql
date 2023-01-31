create table post
(
    id varchar(50) not null,
    title varchar(100) not null,
    content varchar(max) not null,
    date datetime null,
    enable bit not null
);

create table tb_user
(
    id varchar(50) not null,
    name varchar(150) not null,
    email varchar(150) not null,
    sexo varchar(1) not null,
    age integer not null
);

insert into post values ('7c7c8b2f-6858-40cc-9fce-8133690df5c0', 'Hello World', 'teste', '2022-09-26', 1);
insert into post values ('a311c01-e544-4e14-9940-b1d3c30c97a4', 'O TEDIOSO MITO DO ROCK ESTÁ MORTO?', 'teste', '2022-09-10', 1);
insert into post values ('e676c087-ab6b-441b-951a-a4ed7f4f9b62', 'Comment/uncomment current line', 'teste', '2022-09-25', 1);
insert into post values ('53daeccf-7845-kd94-b5bb-0c4816fdddb9', 'Hello World', 'teste', '2022-09-27', 1);
insert into post values ('94jbceif-6858-40cc-9fce-8133690df5c0', 'Search for next occurrence', 'Um post para falar do Hello World', '2022-09-26', 1);
insert into post values ('a311c01-ee49f-4e14-3894-b1d3c30c97a4', 'Canal Barbônico?', '61 964 visualizações  13/09/2018  A frase “o rock morreu” deixa muita gente puta. Se você disser isso sozinho no topo do Himalaia, 30 pessoas com a camiseta do CBGB vão se materializar pra dizer, “Veja bem...” O assunto é uma isca de cliques muito comum na internet, e defender …', '2022-09-10', 1);
insert into post values ('9048276-ab6b-441b-951a-a4ed7f4f9b62', 'Projeto Lombok', 'ou can annotate any field with @Getter and/or @Setter, to let lombok generate the default getter/setter automatically.', '2022-09-25', 1);
insert into post values ('47859374-7845-4c63-b5bb-0c4816fdddb9', '#2 Projeto Lombok', 'teste', '2022-09-27', 1);

insert into tb_user values ('7c7c838hd-6858-40cc-9fce-88943kshdjc0', 'Alex Rocha', 'alrocha003@gmail.com', 'M', 31);
insert into tb_user values ('a311c01-ejd84-4e14-9940-jihfdu83hkdj4', 'Tais Tavares Virissimo Rocha?', 'taverissimo@gmail.com','F', 28);
