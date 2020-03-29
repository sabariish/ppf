package com.ds.shoetype;

import com.ds.shoe.Shoe;

public class OpenLacing extends LaceUpShoes{

	Shoe shoes;

	public OpenLacing(){
			typeOfShoe="OpenLacing";
			System.out.println("Open Lace");
		}
		

	@Override
	public Shoe createShoes(Shoe shoeType) {
		this.shoes=shoeType;
		return this.shoes;
	}

}
