package org.william.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "tb_variacao_item")
@Entity
public class VariacaoItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_unidade",nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUnidade tipoUnidade;

    @Column(nullable = false)
    private Double quantidade;

    @Column(name ="is_promotion",columnDefinition = "tinyInt(4)",nullable = false)
    private Integer isPromotion;

    @Column(name = "valor_unidade",nullable = false)
    private Double valorUnidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id",nullable = false)
    private ItemEntity item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estabelecimento_id")
    private EstabelecimentoEntity estabelecimento;

    @Column
    private LocalDateTime data_adicao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoUnidade getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(TipoUnidade tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Integer isPromotion) {
        this.isPromotion = isPromotion;
    }

    public Double getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(Double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public EstabelecimentoEntity getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoEntity estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public LocalDateTime getData_adicao() {
        return data_adicao;
    }

    public void setData_adicao(LocalDateTime data_adicao) {
        this.data_adicao = data_adicao;
    }
}
