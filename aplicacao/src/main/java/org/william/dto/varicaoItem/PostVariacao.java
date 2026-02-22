package org.william.dto.varicaoItem;

import org.william.entity.TipoUnidade;

public record PostVariacao (
    TipoUnidade tipoUnidade,
    Double quantidade,
    Integer isPromotion,
    Double valorUnidade,
    Integer estabelecimentoId,
    Integer itemId
){}
