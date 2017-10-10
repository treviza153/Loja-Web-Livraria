package br.com.projetoloja.model;

import java.io.FileInputStream;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String descricao;
    private int quantMin;
    private int quantMax;
    private int quantAtual;

    @Column(nullable = true)
    private boolean ativo;

    private double valor;
    private String foto1;
    private String foto2;
    private String foto3;

    public Produto() {

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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.webloja.model.Produto[ "
                + "id = " + id + ", "
                + "Descricao = " + getNome() + ", "
                + "Descricao = " + getDescricao() + ", "
                + "Quant.Min = " + getQuantMin() + ", "
                + "Quant.Max = " + getQuantMax() + ", "
                + "Quant.Atual = " + getQuantAtual() + ", "
                + "Foto 1 = " + getFoto1().toString() + ", "
                + "Foto 2 = " + getFoto2().toString() + ", "
                + "Foto 3 = " + getFoto3().toString() + ", "
                + "Ativo =  " + isAtivo() + "]";
    }

    //Gets e Sets
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantMin() {
        return quantMin;
    }

    public void setQuantMin(int quantMin) {
        this.quantMin = quantMin;
    }

    public int getQuantMax() {
        return quantMax;
    }

    public void setQuantMax(int quantMax) {
        this.quantMax = quantMax;
    }

    public int getQuantAtual() {
        return quantAtual;
    }

    public void setQuantAtual(int quantAtual) {
        this.quantAtual = quantAtual;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    //Validação de Dados
    public boolean isProduto() throws Exception {
        String erros = "";
        if (getDescricao().equals("")) {
            erros += "Nome em branco.\n";
        }
        if (getQuantMin() <= 0) {
            erros += "Quantidade Minima invalida.\n";
        }
        if (getQuantMax() <= 0) {
            erros += "Quantidade Maxima invalida.\n";
        } else if (getQuantMin() > getQuantMax()) {
            erros += "Quantidade Maxima inferior a quantidade minimaF.\n";

        }
        if (getQuantAtual() <= 0) {
            erros += "Quantidade Atual invalida.\n";
        }
        if (getValor() <= 0) {
            erros += "Valor invalido.\n";
        }
        if (getFoto1().equals("")) {
            erros += "Selecione ao menos uma foto para o produto.\n";
        }

        if (!erros.equals("")) {
            throw new Exception(erros);
        }

        return true;
    }

}
