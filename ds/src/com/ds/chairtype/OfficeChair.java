package com.ds.chairtype;

import com.ds.chair.Chair;

public class OfficeChair implements ChairKind{
   Chair chair;
   
   public  OfficeChair(Chair chair) {
	// TODO Auto-generated constructor stub
	   this.chair=chair;
	   this.chair.setFoamType("artificial");
	   this.chair.setLegType("wheeled");
   }
   
	
	
	public String getTypeofChair() {
		return this.chair.getTypeofChair()+' '+this.chair.getFoamType()+' '+this.chair.getLegType();
	}

}
