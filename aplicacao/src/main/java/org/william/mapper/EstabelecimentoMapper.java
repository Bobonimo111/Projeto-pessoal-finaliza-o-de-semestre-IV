package org.william.mapper;

import jakarta.ws.rs.POST;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.william.dto.estabelecimento.GetEstabelecimento;
import org.william.dto.estabelecimento.PostEstabeleciemento;
import org.william.entity.EstabelecimentoEntity;

@Mapper(componentModel = "jakarta")
public interface EstabelecimentoMapper {

    GetEstabelecimento entityToGetDto(EstabelecimentoEntity estabelecimentoEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user",ignore = true)
    EstabelecimentoEntity postDtoToEntity(PostEstabeleciemento getEstabelecimento);
}
