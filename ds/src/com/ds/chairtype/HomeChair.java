package com.ds.chairtype;

import com.ds.chair.Chair;

public class HomeChair implements ChairKind{

	Chair chair;
	   
	public HomeChair(Chair chair) {
		   this.chair=chair;
		   this.chair.setFoamType("jute");
		   this.chair.setLegType("rubbered");
	   }

	@Override
	public String getTypeofChair() {
		return this.chair.getTypeofChair()+' '+this.chair.getFoamType()+' '+this.chair.getLegType();
	}
	   

}
