package com.ds.chairtype;

import com.ds.chair.ChairType;

public class HomeChair implements ChairKind{

	ChairType chair;
	   
	public HomeChair(ChairType chair) {
		   this.chair=chair;
		   this.chair.setFoamType("jute");
		   this.chair.setLegType("rubbered");
	   }

	@Override
	public String getTypeofChair() {
		return this.chair.getTypeofChair()+' '+this.chair.getFoamType()+' '+this.chair.getLegType();
	}
	   

}
