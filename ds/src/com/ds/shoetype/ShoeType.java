package com.ds.shoetype;

import com.ds.shoe.Shoe;

public abstract class ShoeType {
	String typeOfShoe="unknown";
	public Shoe orderShoes(Shoe shoeType) {
		
		Shoe shoe;
		shoe = createShoes(shoeType);
		
		return shoe;
		
	}
	
	public abstract Shoe createShoes (Shoe shoeType);
}
