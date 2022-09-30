package com.forum.app.api.com.forum.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forum.app.api.com.forum.app.api.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends JpaRepository<Post, String> {

    @Query("select * from post where name = :name")
    public Post FindByName(@Param("name") String name);
}
