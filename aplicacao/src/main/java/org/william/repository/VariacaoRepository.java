package org.william.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.william.entity.VariacaoItemEntity;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class VariacaoRepository implements PanacheRepositoryBase<VariacaoItemEntity,Integer> {
    public Optional<VariacaoItemEntity> getByIdOptional(Integer userId,Integer variId){
        return find("user.id = ?1 AND id = ?2", userId,variId).firstResultOptional();
    }

    public List<VariacaoItemEntity> getAllByUserId(Integer userid){
        return find("user.id = ?1", userid).list();
    }
}
