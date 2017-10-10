package br.com.projetoloja.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private Venda venda = new Venda();

    @OneToOne
    private Produto produto;

    private int quant;
    private double valorItens;

    public Item() {
        this.quant = 1;
        this.valorItens = 0;
    }

    public Item(Venda venda, Produto produto, int quant) {
        this.venda = venda;
        this.produto = produto;
        this.quant = quant;
        this.valorItens = quant * produto.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.webloja.model.ItemVenda[ id=" + id + " ]";
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
        this.valorItens = this.quant * produto.getValor();

    }

    public double getValorItens() {
        return valorItens;
    }
    /*
    public void setValorItens(double valorItens) {
        this.valorItens = valorItens;
    }
     */
}
