package org.william.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.william.dto.varicaoItem.GetVaricao;
import org.william.dto.varicaoItem.PostVariacao;
import org.william.entity.VariacaoItemEntity;

@Mapper(componentModel = "jakarta",uses = EstabelecimentoMapper.class)
public interface VariacaoMapper {

    @Mapping(target = "estabelecimento",source = "estabelecimento")
    GetVaricao EntityToGetVaricao(VariacaoItemEntity variacaoItem);

    @Mapping(target = "estabelecimento",ignore = true)
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "item",ignore = true)
    @Mapping(target = "user",ignore = true)
    VariacaoItemEntity PostVaricaoToEntity(PostVariacao postVariacao);
}
