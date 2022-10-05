package com.forum.app.api.com.forum.app.api.models;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Objeto de Modelo de Usuário utilizado pelo repositório e aplicação
 *
 * @author Alex Rocha
 * @version 1.0
 */
@Entity(name = "tb_user")
public class User {
    @Id
    @Column(name = "id")
    private String Id;
    @Column(name = "name")
    @NotNull
    private String _name;
    @Column(name = "email")
    @NotNull
    private String _email;
    @Column(name = "sexo")
    @NotNull
    private char _sexo;
    @Column(name = "age")
    @NotNull
    private int _age;

    public String getId() {
        return this.Id;
    }

    public String getName() {
        return this._name;
    }

    public String getEmail() {
        return this._email;
    }

    public char getSexo() {
        return this._sexo;
    }

    public int getAge() {
        return this._age;
    }

}
