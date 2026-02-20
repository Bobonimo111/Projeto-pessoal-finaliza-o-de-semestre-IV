package org.william.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.william.entity.EstabelecimentoEntity;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EstabelecimentoRepository implements PanacheRepositoryBase<EstabelecimentoEntity,Integer> {
    public List<EstabelecimentoEntity> getAllByUserId(Integer userId) {
        return find("user.id = ?1",userId).list();
    };

    public Optional<EstabelecimentoEntity> getByIdAndUserId(Integer userId,Integer estaId) {
        return find("id = ?1 AND user.id = ?2",estaId,userId).firstResultOptional();
    }

}
