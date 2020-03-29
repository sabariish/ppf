package com.ds.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.ds.chair.PlasticChair;
import com.ds.chair.StainlessSteelChair;
import com.ds.chair.WoodenChair;
import com.ds.chairtype.ChairKind;
import com.ds.chairtype.HomeChair;
import com.ds.chairtype.OfficeChair;

//3 types of chair - wooden, plastic, steel
// types of use - office, home
//office - art foam, wheeled legs
//home - jute foam, rubbered legs

// shopping bskedt - 2 office use of different type, 1 home use of jute
public class ShoppingCart {

	/*public List<ChairType> addToCart(ChairType chair) {
		List<ChairType> cart = new ArrayList<ChairType>();
		cart.add(chair);
		
		return cart;
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ChairKind> cart = new ArrayList<ChairKind>();
		
		OfficeChair ofcChair1 = new OfficeChair(new WoodenChair());
		cart.add(ofcChair1);
		
		OfficeChair ofcChair2 = new OfficeChair(new PlasticChair());
		cart.add(ofcChair2);
		
		OfficeChair ofcChair3 = new OfficeChair(new StainlessSteelChair());
		cart.add(ofcChair3);

		HomeChair hm = new HomeChair(new WoodenChair());
		cart.add(hm);
		
		ListIterator<ChairKind> iterator = cart.listIterator(); 
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTypeofChair());
		}
	}

}
