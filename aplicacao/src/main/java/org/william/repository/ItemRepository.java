package org.william.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import org.william.entity.ItemEntity;
import org.william.mapper.ItemMapper;

import java.util.List;

@ApplicationScoped
public class ItemRepository implements PanacheRepositoryBase<ItemEntity,Integer> {

    public List<ItemEntity> findAllByUserId(Integer userId) {
        return find("user.id = ?1", userId).list();
    }

}
