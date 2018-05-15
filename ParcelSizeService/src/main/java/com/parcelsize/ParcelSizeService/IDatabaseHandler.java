package com.parcelsize.ParcelSizeService;

import java.util.List;

public interface IDatabaseHandler {

	public void openConnection();
	public void createParcelSizeTable();
	public List<Parceldimension> getParceldimensions();
	public void insertInitialData();
	
}
