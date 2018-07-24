package com.parcelsize.ParcelSizeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseMock implements IDatabaseHandler{
	
	public List<Parceldimension>  parceldimensions;

	public DatabaseMock() {
		createParcelSizeTable();
		insertInitialData();
	}

	@Override
	public void openConnection() {
		// do nothing since it is locally 
	}

	@Override
	public void createParcelSizeTable() {
		parceldimensions = new ArrayList<Parceldimension>();
	}

	@Override
	public List<Parceldimension> getParceldimensions() {
		return parceldimensions;
	}

	@Override
	public void insertInitialData() {
		parceldimensions.add(new Parceldimension(Parcelsize.XS, 35));
		parceldimensions.add(new Parceldimension(Parcelsize.S, 50));
		parceldimensions.add(new Parceldimension(Parcelsize.M, 65));
		parceldimensions.add(new Parceldimension(Parcelsize.L, 80));
		parceldimensions.add(new Parceldimension(Parcelsize.XL, 300));
	}

}
