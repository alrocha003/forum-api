package com.forum.app.api.com.forum.app.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Objeto de Modelo de Post utilizado pelo repositório e aplicação
 *
 * @author Alex Rocha
 * @version 1.0
 */
@Entity
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "date")
    private LocalDateTime registerDate;
    @Column(name = "enable", nullable = false)
    private Boolean enable;

    public Post(){

    }

    public Post(String title, String content){
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.registerDate = LocalDateTime.now();
        this.enable = true;
    }

    public String getId(){
        return this.id.toString();
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }

    public LocalDateTime getDate(){
        return this.registerDate;
    }

    public Boolean isEnable(){
        return this.enable;
    }
}
