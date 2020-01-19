package com.ds.shoetype;

import com.ds.shoe.Shoe;

public class BuckledShoes extends ShoeType{
	Shoe shoe;
	
	public BuckledShoes(){
		typeOfShoe="Buckled";
		System.out.println("Buckled");
	}
	
	@Override
	public Shoe createShoes(Shoe shoeType) {
		this.shoe=shoeType;
		
		return this.shoe;
	}

}
