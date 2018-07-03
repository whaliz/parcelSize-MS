package com.parcelsize.ParcelSizeService;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class MySQLDatabaseHandler implements IDatabaseHandler{

	private ConnectionSource connectionSource;
	private String databaseUrl = "jdbc:mysql://172.18.0.2:3306/parcelsizedb?autoReconnect=true&useSSL=false";
	private Dao<Parceldimension, String> pDao; 
	
	public MySQLDatabaseHandler() {
		
	} 
	
	@Override
	public void openConnection() {
//		jdbc:mysql://my-database-host/my-database-name
		try {
			this.connectionSource = new JdbcConnectionSource(databaseUrl, "test", "testme!1517#");
			System.out.println("Connected to Database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void createParcelSizeTable() {
		try {
			TableUtils.createTableIfNotExists(connectionSource, Parceldimension.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Parceldimension> getParceldimensions() {
		try {
			pDao = DaoManager.createDao(connectionSource, Parceldimension.class);
			return pDao.queryForAll();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insertInitialData() {
		try {
			//DAO erstellen und einfügen
			pDao = DaoManager.createDao(connectionSource, Parceldimension.class);
			pDao.create(new Parceldimension(Parcelsize.XS, 35));
		
			pDao.create(new Parceldimension(Parcelsize.S, 50));
			pDao.create(new Parceldimension(Parcelsize.M, 65));
			pDao.create(new Parceldimension(Parcelsize.L, 80));
			pDao.create(new Parceldimension(Parcelsize.XL, 300));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
