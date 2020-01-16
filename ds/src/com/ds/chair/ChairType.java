package com.ds.chair;

public abstract class ChairType {

	String foamType;
	String legType;
	String typeOfChair="unknown";

	public void setFoamType(String foamType) {
		this.foamType = foamType;
	}

	public void setLegType(String legType) {
		this.legType = legType;
	}

	public String getFoamType() {
		return foamType;
	}

	public String getLegType() {
		return legType;
	}
	
	public String getTypeofChair() {
		return typeOfChair;
	}
	
}
