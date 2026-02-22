package org.william.dto.varicaoItem;

import org.william.dto.estabelecimento.GetEstabelecimento;
import org.william.entity.TipoUnidade;

public record GetVaricao(
        Integer id,
        TipoUnidade tipoUnidade,
        Double quantidade,
        Integer isPromotion,
        Double valorUnidade,
        GetEstabelecimento  estabelecimento
) {
}
