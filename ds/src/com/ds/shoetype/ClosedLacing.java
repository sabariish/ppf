package com.ds.shoetype;

import com.ds.shoe.Shoe;

public class ClosedLacing extends LaceUpShoes{
	Shoe shoes;

	ClosedLacing(){
			typeOfShoe="ClosedLacing";
		}
		


	@Override
	public Shoe createShoes(Shoe shoeType) {
		this.shoes=shoeType;
		return this.shoes;
	}

}
