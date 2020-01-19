package com.ds.shoetype;

import com.ds.shoe.Shoe;

public class SlipOnShoes extends ShoeType {
   Shoe shoes;

   SlipOnShoes(){
		typeOfShoe="SlipOnShoes";
	}
	
	@Override
	public Shoe createShoes(Shoe shoeType) {
		this.shoes=shoeType;
		return this.shoes;
	}

}
