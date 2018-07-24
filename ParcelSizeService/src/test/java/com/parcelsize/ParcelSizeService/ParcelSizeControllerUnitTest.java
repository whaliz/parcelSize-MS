package com.parcelsize.ParcelSizeService;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ParcelSizeControllerUnitTest {
	 
	private IDatabaseHandler databaseMock;
	
	private ParcelSizeCalculator calc;
	
	@Before
	public void setup() {
		databaseMock = new DatabaseMock();
		calc = new ParcelSizeCalculator();
	}
	
	@Test
	public void parcelXS() throws Exception {
		
		Parcel p = new Parcel(1, 2, 2, Parcelsize.UNDEFINED);

		assertEquals(Parcelsize.XS, calc.calcSizeForParcel(p, databaseMock.getParceldimensions()).getSize());

	}


}
