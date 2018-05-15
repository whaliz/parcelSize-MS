package com.parcelsize.ParcelSizeService;

public class DatabaseCreator {

	public static void main(String[] args) {
		
		IDatabaseHandler db = new MySQLDatabaseHandler();
		db.openConnection();
		db.createParcelSizeTable();
		db.insertInitialData();
		
		
	}

}
