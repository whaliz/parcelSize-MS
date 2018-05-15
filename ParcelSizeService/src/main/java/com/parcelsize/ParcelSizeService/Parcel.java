package com.parcelsize.ParcelSizeService;

public class Parcel {
	
	private int height;
	private int width;
	private int depth;
	private Parcelsize size;
	
	public Parcel(int height, int width, int depth, Parcelsize size) {
		this.setHeight(height);
		this.width = width;
		this.depth = depth;
		this.size = size;
	}

	public Parcel() {
		
	}
	

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Parcelsize getSize() {
		return size;
	}

	public void setSize(Parcelsize size) {
		this.size = size;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	

}
