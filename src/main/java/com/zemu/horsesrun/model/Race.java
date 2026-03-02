package com.zemu.horsesrun.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Race {
	private List<Horse> horses;
	private double distance;
	private boolean finish;
	private Horse winner;
	public Race(double distance) {
		this.distance = distance;
		horses = new ArrayList<Horse>();
		this.finish = false;
		this.winner = null;
	}
	public void addHorses(Horse horse) {
		horses.add(horse);
	}
	public void nextRound() {
		if(isFinish()) {
			return;
		}else {
			for (Horse horse : horses) {
				horse.moveOn();
			}
			
			
			for (Horse horse : horses) {
				if(horse.getPosition() >= distance) {
					winner = horse;
					finish = true;
					break;
				}
			}
		}
	}
}
