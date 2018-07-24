package com.parcelsize.ParcelSizeService;
import static org.junit.Assert.assertEquals;
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


@RunWith(SpringRunner.class)
@WebMvcTest(value = ParcelSizeControllerUnitTest.class, secure = false)
public class ParcelSizeControllerUnitTest {
	 
	private IDatabaseHandler databaseMock;
	private ParcelSizeRESTController controller;
	
	@Before
	public void setup() {
		databaseMock = new DatabaseMock();
		controller = new ParcelSizeRESTController(databaseMock);
	}
	
	@Test
	public void parcelXS() throws Exception {
		
		Parcel p = new Parcel(1, 2, 2, Parcelsize.UNDEFINED);

		assertEquals(Parcelsize.XS, controller.calculateSize(p).getSize());

	}
	
	
	@Test
	public void parcelSizeDBConnection() throws Exception {
		
		IDatabaseHandler databasehandler = new MySQLDatabaseHandler();
		databasehandler.openConnection();
		
		// test if request on db is fulfilled
		assertNotNull(databasehandler.getParceldimensions());
		
	}

}
