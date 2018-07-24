package com.parcelsize.ParcelSizeService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ParcelSizeRESTController {
	
	private IDatabaseHandler databasehandler;
	
	public ParcelSizeRESTController(IDatabaseHandler handler) {
		if(handler == null) {
			databasehandler = new MySQLDatabaseHandler();
		}else {
			databasehandler = handler;
		}
	}

	@RequestMapping("/size")
	public Parcel calculateSize(@RequestBody Parcel p) {

		databasehandler.openConnection();
		List<Parceldimension> dimensions = databasehandler.getParceldimensions();
		
		ParcelSizeCalculator calc = new ParcelSizeCalculator();
	
		return calc.calcSizeForParcel(p, dimensions);
	}

	


	
	

}
