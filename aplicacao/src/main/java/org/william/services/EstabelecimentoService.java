package org.william.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.william.dto.estabelecimento.GetEstabelecimento;
import org.william.dto.estabelecimento.PostEstabeleciemento;
import org.william.entity.EstabelecimentoEntity;
import org.william.entity.UserEntity;
import org.william.mapper.EstabelecimentoMapper;
import org.william.repository.EstabelecimentoRepository;
import org.william.repository.UserRepository;

import java.util.List;

@ApplicationScoped
public class EstabelecimentoService {
    private final EstabelecimentoRepository  estabelecimentoRepository;
    private final EstabelecimentoMapper estabelecimentoMapper;
    private final UserRepository userRepository;

    @Inject
    EstabelecimentoService(UserRepository userRepository,EstabelecimentoRepository  estabelecimentoRepository,EstabelecimentoMapper estabelecimentoMapper) {
        this.estabelecimentoRepository = estabelecimentoRepository;
        this.estabelecimentoMapper = estabelecimentoMapper;
        this.userRepository = userRepository;
    }

    private EstabelecimentoEntity getEstabelecimento(Integer userId ,Integer estaId){
        return this.estabelecimentoRepository.getByIdAndUserId(userId,estaId)
                .orElseThrow(() -> new RuntimeException("Nenhuma estabelecimento encontrado nesse usuario"));
    }

    @Transactional
    public void deleteEstabelecimentoWithUser(Integer userId, Integer estaId) {
        estabelecimentoRepository.delete(getEstabelecimento(userId,estaId));
    }
@Transactional
    public GetEstabelecimento createNewEstabelecimentoWithUser(Integer userId, PostEstabeleciemento dto) {
        UserEntity userEntity = this.userRepository.findByIdOptional(userId)
                .orElseThrow(() -> new RuntimeException("Usuario não econtrado"));

        EstabelecimentoEntity estabelecimento = this.estabelecimentoMapper.postDtoToEntity(dto);
        estabelecimento.setUser(userEntity);
        estabelecimentoRepository.persist(estabelecimento);
        return this.estabelecimentoMapper.entityToGetDto(estabelecimento);
    }

    public List<GetEstabelecimento> getAllWithUser(Integer userId) {
        return this.estabelecimentoRepository.getAllByUserId(userId).stream()
                .map(this.estabelecimentoMapper::entityToGetDto)
                .toList();
    }

    @Transactional
    public void updateFullWithUser(Integer userId, Integer estaId, PostEstabeleciemento estabelecimento) {
        EstabelecimentoEntity entity = this.getEstabelecimento(userId,estaId);
        entity.setNome(estabelecimento.nome());
        entity.setCidade(estabelecimento.cidade());
    }
}
