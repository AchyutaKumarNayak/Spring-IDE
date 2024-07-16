package in.ashokit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.ashokit.rest.WelcomeRestController;
import in.ashokit.service.WelcomeService;

@WebMvcTest(value = WelcomeRestController.class)
public class WelcomeRestControllTest {
	@MockBean
	private WelcomeService service;
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void welcomeTest() throws Exception {
		//Defining mock obj behavior
		when(service.getWelcomeMsg()).thenReturn("Welcome to OurApplication");
		//Preparing ReqBuilder
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/welcome");
		//Sending request
		 MvcResult result = mockMvc.perform(builder).andReturn();
		//Get the Response
		MockHttpServletResponse response = result.getResponse();
		//Validate Status Code
		int status = response.getStatus();
		assertEquals(status, 200);	
	}

}
