package org.william.services;

import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.william.dto.varicaoItem.GetVaricao;
import org.william.dto.varicaoItem.PostVariacao;
import org.william.entity.VariacaoItemEntity;
import org.william.mapper.VariacaoMapper;
import org.william.repository.EstabelecimentoRepository;
import org.william.repository.ItemRepository;
import org.william.repository.UserRepository;
import org.william.repository.VariacaoRepository;

import java.util.List;

@ApplicationScoped
public class VariacaoService {
    private final VariacaoMapper variacaoMapper;
    private final VariacaoRepository variacaoRepository;
    private final UserRepository userRepository;
    private final EstabelecimentoRepository estabelecimentoRepository;
    private final ItemRepository itemRepository;

    @Inject
    public VariacaoService(VariacaoMapper variacaoMapper, VariacaoRepository variacaoRepository, UserRepository userRepository, EstabelecimentoRepository estabelecimentoRepository, ItemRepository itemRepository) {
        this.variacaoMapper = variacaoMapper;
        this.variacaoRepository = variacaoRepository;
        this.userRepository = userRepository;
        this.estabelecimentoRepository = estabelecimentoRepository;
        this.itemRepository = itemRepository;
    }

    @CacheResult(cacheName = "redis_cache")
    public List<GetVaricao> getAll(Integer userId){
        return this.variacaoRepository.getAllByUserId(userId)
                .stream()
                .map(this.variacaoMapper::EntityToGetVaricao)
                .toList();
    }

    @Transactional
    public GetVaricao createNew(Integer userid,PostVariacao postVariacao){
        VariacaoItemEntity variacao = this.variacaoMapper.PostVaricaoToEntity(postVariacao);

        variacao.setItem(this.itemRepository.findByIdOptional(postVariacao.itemId())
                .orElseThrow(()-> new RuntimeException("Item id->"+ postVariacao.itemId() +" não encontrado")));

        variacao.setUser(this.userRepository.findByIdOptional(userid).orElseThrow(
                ()->new RuntimeException("User id->"+userid+" não encontrado")
        ));

        if(postVariacao.estabelecimentoId() != null){
            variacao.setEstabelecimento(this.estabelecimentoRepository.findByIdOptional(postVariacao.estabelecimentoId())
                    .orElseThrow(()-> new RuntimeException("Estabelecimento id->"+ postVariacao.estabelecimentoId() +" naõ encontrado")));
        }

        this.variacaoRepository.persist(variacao);

        return this.variacaoMapper.EntityToGetVaricao(variacao);

    }

    @Transactional
    public void updateFull(Integer userId,Integer variaId,PostVariacao postVariacao){
        VariacaoItemEntity entity = this.variacaoRepository.getByIdOptional(userId,variaId)
                .orElseThrow(()-> new RuntimeException("variacao Id->"+variaId+" naõ econtrado"));

        entity.setTipoUnidade(postVariacao.tipoUnidade());
        entity.setValorUnidade(postVariacao.valorUnidade());
        entity.setIsPromotion(postVariacao.isPromotion());
        entity.setQuantidade(postVariacao.quantidade());
    }

    @Transactional
    public void delete(Integer userId,Integer variaId){
        VariacaoItemEntity entity = this.variacaoRepository.getByIdOptional(userId,variaId)
                .orElseThrow(()-> new RuntimeException("variacao Id->"+variaId+" naõ econtrado"));

        this.variacaoRepository.delete(entity);
    }
}
