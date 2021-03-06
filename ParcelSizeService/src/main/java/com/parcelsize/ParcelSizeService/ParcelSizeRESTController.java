package com.parcelsize.ParcelSizeService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ParcelSizeRESTController {
	
	private IDatabaseHandler databasehandler;
	
	public ParcelSizeRESTController() {
		
	}


	@RequestMapping("/size")
	public Parcel calculateSize(@RequestBody Parcel p) {
		databasehandler = new MySQLDatabaseHandler();
		databasehandler.openConnection();
		List<Parceldimension> dimensions = databasehandler.getParceldimensions();
		
		ParcelSizeCalculator calc = new ParcelSizeCalculator();
	
		return calc.calcSizeForParcel(p, dimensions);
	}

	
	public void setDatabasehandler(IDatabaseHandler handler) {
		this.databasehandler = handler;
	}

	
	

}
