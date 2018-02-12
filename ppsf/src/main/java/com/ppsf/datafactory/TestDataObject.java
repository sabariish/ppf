package com.ppsf.datafactory;

import java.lang.reflect.Field;
import java.util.List;

public abstract class TestDataObject {

	public TestDataObject (List<Entry<String, String>> l) {
		try {

			for (int i =0; i<l.size(); i++) {
				Field field =this.getClass().getDeclaredField(l.get(i).getKey());
				this.getClass().getDeclaredField(l.get(i).getKey()).setAccessible(true);
				try {
					field.set(this, new String(l.get(i).getValue()));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		} catch (NoSuchFieldException | SecurityException e) {
		}
	}
}
