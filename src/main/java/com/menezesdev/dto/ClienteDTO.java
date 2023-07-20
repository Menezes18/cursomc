package com.menezesdev.dto;

import com.menezesdev.models.Cliente;
import com.menezesdev.services.validation.ClienteUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
@ClienteUpdate
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Prenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;
    @NotEmpty(message = "Prenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    public ClienteDTO(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    public ClienteDTO(Cliente clienteobj){
        id = clienteobj.getId();
        nome = clienteobj.getNome();
        email = clienteobj.getEmail();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
