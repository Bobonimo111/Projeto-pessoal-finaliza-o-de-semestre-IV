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

-- Visualizar a diferença entre a maior e menor variação por item, e o maior e o menor valor
create or replace view diferenca_da_taxa_de_variacao_de_itens as SELECT ti.nome as 'nome do item',
(max(tvi.valor_unidade) - MIN(tvi.valor_unidade)) as 'Taxa de variação' ,
max(tvi.valor_unidade) as 'Maior valor',
min(tvi.valor_unidade) as 'Menor valor'
from ppfsiv.tb_item ti 
inner join ppfsiv.tb_variacao_item tvi on ti.id = tvi.item_id
group by ti.nome;

select * from diferenca_da_taxa_de_variacao_de_itens;

-- Visualizar a quantidade de variações por estabelecimento,
-- junto a primeira e a ultima data de adição de variação.
create or replace view primeiro_e_ultimo_lancamento_por_estabelecimento as select 
te.nome as 'estabelecimento',
count(tvi.estabelecimento_id) as 'preços cadastrados',
min(tvi.data_adicao) as 'primeiro lançamento',
max(tvi.data_adicao) as 'ultimo lançamento'
from tb_estabelecimento te 
inner join tb_variacao_item tvi on te.id = tvi.estabelecimento_id
group by te.nome;

select * from primeiro_e_ultimo_lancamento_por_estabelecimento;
