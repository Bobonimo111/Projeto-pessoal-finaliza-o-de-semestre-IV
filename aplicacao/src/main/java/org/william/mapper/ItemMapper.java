package org.william.mapper;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.william.dto.items.GetitemDTO;
import org.william.dto.items.PostItemDTO;
import org.william.entity.ItemEntity;

@Mapper(componentModel = "jakarta")
public interface ItemMapper {

    @Mapping(target = "userId",source = "user.id")
    GetitemDTO itemEntityToGetitemDTO(ItemEntity item);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "user",ignore = true)
    ItemEntity itemDTOToItemEntity(PostItemDTO item);

}
