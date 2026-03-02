package com.zemu.horsesrun.model;

import java.util.Random;

import lombok.Data;

@Data
public class Horse {

	private String name;
	private double position;
	private String color;
	private static final Random random = new Random();
	
	public Horse(String name, String color) {
		this.name = name;
		this.color = color;
		this.position = 0.0;
	}
	public void moveOn() {
		Integer velocity = random.nextInt(4);
		position = position + velocity;
	}
	
	
}
