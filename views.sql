-- Visualizar todas as variação de itens por estabelecimento deve conter,nomes dos itens e estabelecimentos 
-- e estarem organizados por data da ultima para primeira agrupados por itens e estabelecimentos;
create or replace view variacao_de_itens_por_estabelecimentos_valores as select esta.nome as 'estabelecimento', item.nome as 'item', 
vari.valor_unidade as 'valor unitario',vari.tipo_unidade as 'tipo unidade',
vari.data_adicao as 'Data de adicao'
from ppfsiv.tb_variacao_item vari
inner join ppfsiv.tb_item item on item.id = vari.item_id
inner join ppfsiv.tb_estabelecimento esta on esta.id = vari.estabelecimento_id
order by esta.nome,item.nome,vari.data_adicao asc;

-- Visualizar quantas variações possuem por estabelecimento e item, deve conter nome do estabelecimento, item e quantidade de variações.
create or replace view quantidade_variacoes_de_itens_por_estabelecimentos as select esta.nome as 'estabelecimento', item.nome as 'item',
count(vari.item_id) as "quantidade variações" from 
ppfsiv.tb_variacao_item vari
inner join ppfsiv.tb_item item on item.id = vari.item_id
inner join ppfsiv.tb_estabelecimento esta on esta.id = vari.estabelecimento_id
group by esta.nome,vari.item_id;
