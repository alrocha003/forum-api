package com.forum.app.api.com.forum.app.api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.forum.app.api.com.forum.app.api.models.Post;
import com.forum.app.api.com.forum.app.api.repository.PostRepository;
import com.forum.app.api.com.forum.app.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v2/posts")
public class PostController {

    @Autowired
    private PostRepository _repository;

    @GetMapping()
    public List<Post> GetPosts() throws JsonProcessingException {
        return _repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> GetPostsById(@PathVariable String id) throws JsonProcessingException {
        Optional<Post> returned = _repository.findAll().stream().filter((p) -> p.getId().equals(id)).findAny();
        if (returned.stream().count() > 0)
            return new ResponseEntity<Post>(returned.get(), HttpStatus.OK);

        return new ResponseEntity<Post>((Post) null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/query")
    public ResponseEntity<Post> GetPostsByIdQueryParameter(@RequestParam(value = "id",
            defaultValue = "0") String id) throws JsonProcessingException {
        Optional<Post> returned = _repository.findAll().stream().filter((p) -> p.getId().equals(id)).findAny();
        if (returned.stream().count() > 0)
            return new ResponseEntity<Post>(returned.get(), HttpStatus.OK);

        return new ResponseEntity<Post>((Post) null, HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public ResponseEntity<String> Post(@RequestBody Post post){
        try {
            _repository.save(post);
            return new ResponseEntity(Constants.MSG_POST_INSERIDO, HttpStatus.CREATED);
        }
        catch (JsonParseException exception)
        {
            return new ResponseEntity(String.format("Exception Message: {0} - StackTrace: {1}",
                    exception.getMessage(), exception.getStackTrace()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("?id={id}")
    public ResponseEntity<String> Delete(@RequestParam String id){
        _repository.deleteById(id);
        return ResponseEntity.ok().body(Constants.MSG_POST_EXCLUIDO);

    }
}
