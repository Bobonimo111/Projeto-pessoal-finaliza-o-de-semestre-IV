
-- Inserindo dados de para testes
-- criando usuarios
insert into ppfsiv.tb_user(nome,sobrenome) values ('william','rodrigues');


-- Adicionando items
insert into ppfsiv.tb_item(nome,user_id) values ('guarana 1L', 1);
insert into ppfsiv.tb_item(nome,user_id) values ('Bandeija com 12 ovos', 1);
insert into ppfsiv.tb_item(nome,user_id) values ('1k peito de frango sem osso',1);

-- Adcionando estabelecimentos
insert into ppfsiv.tb_estabelecimento(nome,cidade,user_id) 
values ('Mercado avenida','Vitoria de santo antão',1),
('Novo atacarejo','Limoerio',1),
('Qualy mais','Passira',1);

insert into ppfsiv.tb_estabelecimento(nome,cidade,user_id) 
values ('Nido','Passira',1)

-- Adicionando variações
-- ovos
insert into ppfsiv.tb_variacao_item
(tipo_unidade,valor_unidade,quantidade,item_id ,user_id ,estabelecimento_id )
values('un',8.90,1,2,1,1),
('un',8.00,2,2,1,4),
('un',9.30,2,2,1,3);


-- garana 1 L
insert into ppfsiv.tb_variacao_item
(tipo_unidade,valor_unidade,quantidade,item_id ,user_id ,estabelecimento_id )
values('un',6.10,1,1,1,1),
('un',4.50,1,1,1,2),
('un',4.30,1,1,1,3);

-- Inserindo peito de frango
insert into ppfsiv.tb_variacao_item
(tipo_unidade,valor_unidade,quantidade,item_id ,user_id ,estabelecimento_id,data_adicao )
values('un',19.10,1,3,1,1,'2025-01-18 00:00:00.000'),
('un',20.15,1,3,1,1,'2025-03-10 00:00:00.000'),
('un',22.50,1,3,1,1,'2025-06-24 00:00:00.000'),
('un',22.90,1,3,1,1,'2025-10-14 00:00:00.000'),
('un',23.90,1,3,1,1,'2026-01-14 00:00:00.000');
