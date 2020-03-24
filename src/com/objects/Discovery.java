package com.objects;

import java.util.List;

public class Discovery {
	
	private int flag;
	private String name;

	public Discovery(List<String> disco) {
		this.flag = Integer.parseInt(disco.get(0));
		this.name = disco.get(1);		
	}

	public void printStateShort () {
		System.out.println(name + " - flag=" + flag);
	}
	
}
