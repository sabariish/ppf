package com.ds.test;

import com.ds.shoe.FormalShoe;
import com.ds.shoe.Shoe;
import com.ds.shoe.SportsShoe;
import com.ds.shoetype.BuckledShoes;
import com.ds.shoetype.LaceUpShoes;
import com.ds.shoetype.OpenLacing;
import com.ds.shoetype.ShoeType;

public class ShoeCart {

	public static void main(String[] args) {

		ShoeType shoeType = new BuckledShoes();
		
		Shoe shoe = shoeType.createShoes(new SportsShoe());
		System.out.println(shoe.getClassOfShoe());
		
		shoe = shoeType.createShoes(new FormalShoe());
		System.out.println(shoe.getClassOfShoe());
		
		shoeType = new OpenLacing();
		
		shoe= shoeType.createShoes(new SportsShoe());
		System.out.println(shoe.getClassOfShoe());
		
		shoe= shoeType.createShoes(new FormalShoe());
		System.out.println(shoe.getClassOfShoe());
	}

}
