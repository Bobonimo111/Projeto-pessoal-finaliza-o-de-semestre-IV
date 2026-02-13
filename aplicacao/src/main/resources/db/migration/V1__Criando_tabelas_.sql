-- Começo do script de crição de tabelas

-- Tabela user 
create table if not exists tb_user(
	nome varchar(50) not null,
	sobrenome varchar(50) not null,
	data_criacao datetime default NOW()
);

alter table tb_user 
	add id int auto_increment not null,
	add primary key(id);

-- ---- ----- ----- ----- ----- ----- ----- -----

-- Tabela item
create table if not exists   tb_item(
	nome varchar(50) not null
);

-- Adicionando chave primaria
alter table tb_item 
add id int not null auto_increment,
add primary key (id);

-- Adicionando columan user_id e linkando tabelas
alter table   tb_item
add user_id int not null,
add constraint fk_item_user
foreign key (user_id) 
references   tb_user(id);


-- Criando tabela de variação
create table if not exists   tb_variacao_item(
	tipo_unidade enum("un","kg") not null,
	quantidade double(6,3) not null,
	data_adicao datetime default NOW() ,-- a data a atual do sistema mysql,
	is_promotion tinyint not null default false COMMENT 'Esse valor define se o item estava ou não em promoção',
	valor_unidade double(4,2) not null
);

-- Adicionando primary key
alter table tb_variacao_item
add id int not null auto_increment,
add primary key (id);

-- adicionando chaves de refencia estrangeira
-- item -> varaição
alter table tb_variacao_item
add item_id int,
add constraint fk_item 
foreign key (item_id)
references tb_item(id);

-- Users -> variação
alter table   tb_variacao_item 
add user_id int not null,
add constraint fk_user
foreign key (user_id)
references   tb_user(id);

-- Criando tabela de estabelecimentos
create table if not exists   tb_estabelecimento(
	nome varchar(50) not null,
	cidade varchar(50) not null
);

-- adicionando id 
alter table   tb_estabelecimento 
add id int not null auto_increment,
add primary key (id);

-- adicionando chave de estabelecimento usuario 
alter table   tb_estabelecimento
add user_id int not null,
add constraint fk_user_id
foreign key (user_id)
references   tb_user(id);

-- Adcinando relação de item contendo um estabelecimento pra não dar erro
alter table   tb_variacao_item 
add estabelecimento_id int,
add constraint fk_estabe 
foreign key (estabelecimento_id)
references   tb_estabelecimento(id);
