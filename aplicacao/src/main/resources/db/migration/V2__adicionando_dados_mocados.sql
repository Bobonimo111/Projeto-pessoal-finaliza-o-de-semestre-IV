-- Inserindo dados de para testes
-- criando usuarios
insert into ppfsiv.tb_user(nome,sobrenome) values ('william','rodrigues');

-- Adcionando estabelecimentos
insert into ppfsiv.tb_estabelecimento(nome,cidade,user_id)
values ('Mercado avenida','Vitoria de santo antão',1),
       ('Novo atacarejo','Limoerio',1);

-- Adicionando items
insert into ppfsiv.tb_item(nome,user_id) values ('guarana 1L', 1);
insert into ppfsiv.tb_item(nome,user_id) values ('Bandeija com 12 ovos', 1);
insert into ppfsiv.tb_item(nome,user_id) values ('1k peito de frango sem osso',1);

-- Adicionando variações
-- ovos
insert into ppfsiv.tb_variacao_item
(tipo_unidade,valor_unidade,quantidade,item_id ,user_id ,estabelecimento_id,data_adicao )
values('un',8.90,1,2,1,1,'2025-02-08 00:00:00.000'),
      ('un',8.00,2,2,1,1,'2025-03-10 00:00:00.000'),
      ('un',9.30,2,2,1,1,'2025-08-18 00:00:00.000');

-- ovos
insert into ppfsiv.tb_variacao_item
(tipo_unidade,valor_unidade,quantidade,item_id ,user_id ,estabelecimento_id,data_adicao)
values('un',9.00,1,2,1,2,'2025-01-18 00:00:00.000'),
      ('un',8.50,2,2,1,2,'2025-05-20 00:00:00.000'),
      ('un',9.30,2,2,1,2,'2025-12-18 00:00:00.000');

-- garana 1 L
insert into ppfsiv.tb_variacao_item
(tipo_unidade,valor_unidade,quantidade,item_id ,user_id ,estabelecimento_id,data_adicao)
values('un',6.10,1,1,1,1,'2023-01-18 00:00:00.000'),
      ('un',4.50,1,1,1,1,'2024-02-18 00:00:00.000'),
      ('un',4.30,1,1,1,1,'2025-12-10 00:00:00.000');

-- Inserindo peito de frango
insert into ppfsiv.tb_variacao_item
(tipo_unidade,valor_unidade,quantidade,item_id ,user_id ,estabelecimento_id,data_adicao )
values('un',19.10,1,3,1,2,'2025-01-18 00:00:00.000'),
      ('un',20.15,1,3,1,2,'2025-03-10 00:00:00.000'),
      ('un',22.50,1,3,1,2,'2025-06-24 00:00:00.000'),
      ('un',22.90,1,3,1,2,'2025-10-14 00:00:00.000'),
      ('un',23.90,1,3,1,2,'2026-01-14 00:00:00.000');

insert into ppfsiv.tb_variacao_item
(tipo_unidade,valor_unidade,quantidade,item_id ,user_id ,estabelecimento_id,data_adicao )
values('un',19.50,1,3,1,2,'2025-01-18 00:00:00.000'),
      ('un',20.15,1,3,1,2,'2025-03-10 00:00:00.000'),
      ('un',15.50,1,3,1,2,'2025-06-24 00:00:00.000'),
      ('un',22.60,1,3,1,2,'2025-10-14 00:00:00.000'),
      ('un',21.90,1,3,1,2,'2026-01-14 00:00:00.000');