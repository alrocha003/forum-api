package com.forum.app.api.com.forum.app.api;

import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.forum.app.api.com.forum.app.api.models.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@BeforeAll
	public void initialize(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void contextLoads() {
		Assertions.fail(LocalDateTime.now() + " - Falhou propositalmente");
	}

	@Test()
	public void testInstancePostObject(){
		Post post = new Post("Post sobre Yu Yu Hakusho", "Yu YU Hakusho é um dos melhores animes");
		Assertions.assertNotNull(post, "Não é nulo");
		Assert.doesNotContain("Naruto", post.getContent(), "Não encontrou");
	}

	@Test()
	public void testInstancePostObjectAndVerifyIfThisIsEnable(){
		Post post = new Post("Post sobre Yu Yu Hakusho", "Yu YU Hakusho é um dos melhores animes");
		Assertions.assertTrue(post.isEnable(), "Passou :D");
	}

	@Test()
	public void testVerifyPostDateFormat(){
		Post post = new Post("Post sobre Yu Yu Hakusho", "Yu YU Hakusho é um dos melhores animes");
		Assertions.assertEquals(2022, post.getDate().getYear(), "Passou :D");
	}

	@Test()
	public void testVerifyPostEndpoint() throws Exception {
		this.mockMvc.perform(get("/v2/posts")).andExpect(status().isOk());
	}
}
