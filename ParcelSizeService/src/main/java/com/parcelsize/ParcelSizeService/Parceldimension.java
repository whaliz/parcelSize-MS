package com.parcelsize.ParcelSizeService;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Parceldimension {
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(canBeNull=false)
	private Parcelsize size;
	
	@DatabaseField(canBeNull=false)
	private int maxGirth;
	
	public Parceldimension (Parcelsize size, int maxGirth) {
		this.size = size;
		this.maxGirth = maxGirth;
	}
	
	public Parceldimension() {
		
	}

	public Parcelsize getSize() {
		return size;
	}

	public void setSize(Parcelsize size) {
		this.size = size;
	}

	public int getMaxGirth() {
		return maxGirth;
	}

	public void setMaxGirth(int maxGirth) {
		this.maxGirth = maxGirth;
	}
	
	

}
