package com.parcelsize.ParcelSizeService.integration;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parcelsize.ParcelSizeService.IDatabaseHandler;
import com.parcelsize.ParcelSizeService.MySQLDatabaseHandler;
import com.parcelsize.ParcelSizeService.Parcel;
import com.parcelsize.ParcelSizeService.Parcelsize;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ParcelSizeIntegrationTest.class, secure = false)
public class ParcelSizeIntegrationTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		// setup the mvc context for mocking the rest controller and its environment
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void checkStatus() throws Exception {
		
		Parcel p = new Parcel(1, 2, 2, Parcelsize.UNDEFINED);

		//convert parcel to json
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(p);
			
		// perform get request with requestbody containing parcel as json in order to mock service
		mockMvc.perform(get("/size").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isOk());
		
	}
	

	@Test
	public void negativeStatusTest() throws Exception {
		
		Parcel p = new Parcel(-1, -1, -1, Parcelsize.UNDEFINED);

		//convert parcel to json
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(p);
		
		// perform get request with requestbody containing parcel as json in order to mock service
		mockMvc.perform(get("/size").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.size").value("S"));
		
	}

	
	@Test
	public void parcelSizeDBConnection() throws Exception {
		
		IDatabaseHandler databasehandler = new MySQLDatabaseHandler();
		databasehandler.openConnection();
		
		// test if request on db is fulfilled
		assertNotNull(databasehandler.getParceldimensions());
		
	}
	
	@Test
	public void parcelSizeXS() throws Exception {
		
		Parcel p = new Parcel(1, 2, 2, Parcelsize.UNDEFINED);

		//convert parcel to json
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(p);
		
		// perform get request with requestbody containing parcel as json in order to mock service
		mockMvc.perform(get("/size").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.size").value("XS"));
		
	}
	

	@Test
	public void parcelSizeS() throws Exception {
		
		Parcel p = new Parcel(10, 10, 6, Parcelsize.UNDEFINED);

		//convert parcel to json
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(p);
		
		// perform get request with requestbody containing parcel as json in order to mock service
		mockMvc.perform(get("/size").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.size").value("S"));
		
	}
	
	@Test
	public void parcelSizeM() throws Exception {
		
		Parcel p = new Parcel(20, 10, 10, Parcelsize.UNDEFINED);

		//convert parcel to json
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(p);
		
		// perform get request with requestbody containing parcel as json in order to mock service
		mockMvc.perform(get("/size").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.size").value("M"));
		
	}
	
	@Test
	public void parcelSizeL() throws Exception {
		
		Parcel p = new Parcel(30, 10, 10, Parcelsize.UNDEFINED);

		//convert parcel to json
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(p);
		
		// perform get request with requestbody containing parcel as json in order to mock service
		mockMvc.perform(get("/size").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.size").value("L"));
		
	}
	
	@Test
	public void parcelSizeXL() throws Exception {
		
		Parcel p = new Parcel(20, 20, 20, Parcelsize.UNDEFINED);

		//convert parcel to json
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(p);
		
		// perform get request with requestbody containing parcel as json in order to mock service
		mockMvc.perform(get("/size").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.size").value("XL"));
		
	}
	
	@Test
	public void parcelSizeUNDEFINEDLOW() throws Exception {
		
		Parcel p = new Parcel(-1, 10, 10, Parcelsize.UNDEFINED);

		//convert parcel to json
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(p);
		
		// perform get request with requestbody containing parcel as json in order to mock service
		mockMvc.perform(get("/size").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.size").value("UNDEFINED"));
		
	}
	
	@Test
	public void parcelSizeUNDEFINEDHIGH() throws Exception {
		
		Parcel p = new Parcel(1000, 1000, 10, Parcelsize.UNDEFINED);

		//convert parcel to json
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(p);
		
		// perform get request with requestbody containing parcel as json in order to mock service
		mockMvc.perform(get("/size").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.size").value("UNDEFINED"));
		
	}

}
