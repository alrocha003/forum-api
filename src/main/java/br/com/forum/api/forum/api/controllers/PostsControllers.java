package br.com.forum.api.forum.api.controllers;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostsControllers {
//    @RequestMapping("/posts")
//    @ResponseBody
    public String Get(){
        return "<h2>Hello World</h2>";
    }

}
