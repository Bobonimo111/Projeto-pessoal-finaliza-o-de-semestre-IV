-- trigers de log
-- pelo visto vou ter de criar 9 triggers 3 para cada tabela
-- Delete

use ppfsiv;
DELIMITER $$
create trigger tg_log_delete_item_variacao
before delete
on tb_variacao_item for each row
begin
	
	insert into tb_logs(tb_name, tb_id, tipo)
	VALUES('tb_variacao_item', old.id, 'delete');

end $$
DELIMITER ;

use ppfsiv;
DELIMITER $$
create trigger tg_log_delete_item 
before delete
on tb_item for each row
begin
	insert into tb_logs(tb_name, tb_id, tipo)
	VALUES('tb_item', old.id, 'delete');
end $$
DELIMITER ;

use ppfsiv;
DELIMITER $$
create trigger tg_log_delete_estabelecimento
before delete
on tb_estabelecimento for each row
begin 
	insert into tb_logs(tb_name, tb_id, tipo)
	VALUES('tb_estabelecimento', old.id, 'delete');
end $$
DELIMITER ;

-- use ppfsiv;
-- delete from tb_variacao_item where id = 1;


-- Update 
use ppfsiv;
DELIMITER $$
create trigger tg_log_update_variacao_item
after update on tb_variacao_item for each row
begin
	insert into tb_logs(tb_name, tb_id, tipo)
	VALUES('tb_variacao_item', new.id, 'update');
end $$
DELIMITER ;

use ppfsiv;
DELIMITER $$
create trigger tg_log_update_item
after update on tb_item for each row
begin
	insert into tb_logs(tb_name, tb_id, tipo)
	VALUES('tb_item', new.id, 'update');
end $$
DELIMITER ;

use ppfsiv;
DELIMITER $$
create trigger tg_log_update_estabelecimento
after update on tb_estabelecimento for each row
begin 
	insert into tb_logs(tb_name, tb_id, tipo)
	VALUES('tb_estabelecimento', new.id, 'update');
end $$
DELIMITER ;


-- Insert
use ppfsiv;
DELIMITER $$
create trigger tg_log_insert_variacao_item
after insert 
on tb_variacao_item for each row
begin
	insert into tb_logs(user_id,tb_name, tb_id, tipo)
	VALUES(new.user_id,'tb_variacao_item', new.id, 'insert');
end
DELIMITER ;

use ppfsiv;
DELIMITER $$
create trigger tg_log_insert_item
after insert 
on tb_item for each row
begin
	insert into tb_logs(user_id,tb_name, tb_id, tipo)
	VALUES(new.user_id,'tb_item', new.id, 'insert');
end
DELIMITER ;


DELIMITER $$
create trigger tg_log_insert_estabelecimento
after insert on tb_estabelecimento for each row
begin
	insert into tb_logs(user_id,tb_name, tb_id, tipo)
	VALUES(new.user_id,'tb_estabelecimento', new.id, 'insert');
end
DELIMITER ;
