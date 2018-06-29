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
	


	@RequestMapping("/size")
	public Parcel calculateSize(@RequestBody Parcel p) {

		databasehandler = new MySQLDatabaseHandler();
		databasehandler.openConnection();
		List<Parceldimension> dimensions = databasehandler.getParceldimensions();
		
		if(p.getDepth() < 1 | p.getHeight() < 1 | p.getWidth() < 1) {
			return p;
		}
		
		int girth = calculateGirth(p);
		for (Parceldimension parceldimension : dimensions) {
			if(girth <= parceldimension.getMaxGirth()) {
				p.setSize(parceldimension.getSize());
				return p;
			} 
		}
		p.setSize(Parcelsize.UNDEFINED);
		
		return p;
	}


	
	private int calculateGirth(Parcel p) {
		return p.getHeight() + (2 * p.getWidth()) + (2 * p.getDepth());
	}

}
