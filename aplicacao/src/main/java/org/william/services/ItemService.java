package org.william.services;

import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.william.dto.items.GetitemDTO;
import org.william.dto.items.PostItemDTO;
import org.william.entity.ItemEntity;
import org.william.entity.UserEntity;
import org.william.mapper.ItemMapper;
import org.william.repository.ItemRepository;

import java.util.List;

@ApplicationScoped
public class ItemService {
    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;
    private final EntityManager em;

    @Inject
    public ItemService(ItemMapper itemMapper, ItemRepository itemRepository, EntityManager em) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
        this.em = em;
    }
    @CacheResult(cacheName = "cache_bolado_2")
    public List<GetitemDTO> getitems(Integer userId) {
        return itemRepository.findAllByUserId(userId)
                .stream()
                .map(this.itemMapper::itemEntityToGetitemDTO)
                .toList();
    }

    @Transactional
    public GetitemDTO createNewItem(PostItemDTO item,Integer userid){
        ItemEntity itemEntity = itemMapper.itemDTOToItemEntity(item);
        itemEntity.setUser(em.getReference(UserEntity.class,userid));
        itemRepository.persist(itemEntity);
        return itemMapper.itemEntityToGetitemDTO(itemEntity);
    }

    @Transactional
    public void UpdateFullItem(PostItemDTO newItem,Integer id){
        ItemEntity dbEntity = this.itemRepository.findById(id);
        dbEntity.setName(newItem.name());
    }

    @Transactional
    public void deleteItem(Integer id) throws Exception{
        this.itemRepository.deleteById(id);
    }
}
