package com.testboot;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class AppTest {
	
	@Autowired
	WebApplicationContext wac;
	MockMvc mockMvc;
	
	@Before
	public void before() {
	    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();	
	}

	@Test
	public void  welcomeTest() throws Exception{
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders
				.get("/")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))
			.andExpect(MockMvcResultMatchers.status().isOk())
//			.andDo(MockMvcResultHandlers.print())
			.andReturn();
		System.out.println("\n" + mvcResult.getResponse().getContentAsString() + "\n");
	}
}
