package com.parcelsize.ParcelSizeService;

import java.util.List;

public class ParcelSizeCalculator {
	
	public ParcelSizeCalculator() {
		
	}
	
	
	public Parcel calcSizeForParcel(Parcel p, List<Parceldimension> dimensions) {
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
