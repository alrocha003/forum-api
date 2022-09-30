package com.forum.app.api.com.forum.app.api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.forum.app.api.com.forum.app.api.models.Post;
import com.forum.app.api.com.forum.app.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
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

    public PostController() {
    //        _posts = Arrays.asList(
//                new Post("Hello World", "Um post para falar do Hello World"),
//                new Post("O TEDIOSO MITO DO \"ROCK ESTÁ MORTO?\"\n", "Barbônico"),
//                new Post("Search for next occurrence", "Um post para falar do Hello World"),
//                new Post("Comment/uncomment current line", "Um post para falar do Hello World"),
//                new Post("Canal Barbônico", "61 964 visualizações  13/09/2018  A frase “o rock morreu” deixa muita gente puta. Se você disser isso sozinho no topo do Himalaia, 30 pessoas com a camiseta do CBGB vão se materializar pra dizer, “Veja bem...” O assunto é uma isca de cliques muito comum na internet, e defender …\n" +
//                        "...mais\n"),
//                new Post("Projeto Lombok", "ou can annotate any field with @Getter and/or @Setter, to let lombok generate the default getter/setter automatically.\n" +
//                        "A default getter simply returns the field, and is named getFoo if the field is called foo (or isFoo if the field's type is boolean). A default setter is named setFoo if the field is called foo, returns void, and takes 1 parameter of the same type as the field. It simply sets the field to this value.")
//        );
    }

    @GetMapping()
    public List<Post> GetPosts() throws JsonProcessingException {
        return _repository.findAll();
    }

    @GetMapping("?id={id}")
    public ResponseEntity<Post> GetPostsById(@RequestParam String id) throws JsonProcessingException {
        Optional<Post> returned = _repository.findAll().stream().filter((p) -> p.getId().equals(id)).findAny();
        if (returned.stream().count() > 0)
            return new ResponseEntity<Post>(returned.get(), HttpStatus.OK);

        return new ResponseEntity<Post>((Post) null, HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public ResponseEntity<String> Post(@RequestBody Post post){
        try {
            _repository.save(post);
            return new ResponseEntity<String>("Post inserido com sucesso", HttpStatus.CREATED);
        }
        catch (JsonParseException exception)
        {
            return new ResponseEntity<String>(String.format("Exception Message: {0} - StackTrace: {1}",
                    exception.getMessage(), exception.getStackTrace()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("?id={id}")
    public ResponseEntity<String> Delete(@RequestParam String id){
        _repository.deleteById(id);
        return new ResponseEntity<String>("Post excluido com sucesso", HttpStatus.OK);

    }
}
