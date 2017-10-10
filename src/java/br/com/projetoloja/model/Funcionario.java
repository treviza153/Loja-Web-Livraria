package br.com.projetoloja.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String email;
    private String pws;


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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaWEB.model.Funcionario[ id=" + id + " ]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    private String isDados() {
        String erros = "";
        if (nome.equals("")) {
            erros += "Nome em branco.\n";
        }
        if (email.equals("")) {
            erros += "E-mail em branco.\n";
        }
        return erros;
    }

    private String isSenha(String confirmSenha) {
        String erros = "";
        if (pws.equals("")) {
            erros += "Senha em branco.\n";
        } else if (pws.length() < 5) {
            erros += "Senha muito curta. Minimo de 6 caracteres.\n";
        } else if (!pws.equals(confirmSenha)) {
            erros += "Senhas diferentes.\n";
        }

        return erros;
    }

    public boolean isFuncionario(String pws) throws Exception {
        String erros = isDados() + isSenha(pws);
        if (!erros.equals("")) {
            throw new Exception(erros);
        }
        return true;
    }

    public boolean isFuncionario() throws Exception {
        String erros = isDados();
        if (!erros.equals("")) {
            throw new Exception(erros);
        }
        return true;
    }

    public boolean isPassword(String confirmaSenha) throws Exception {
        String erros = isSenha(confirmaSenha);
        if (!erros.equals("")) {
            throw new Exception(erros);
        }
        return true;
    }
}
