package com.zemu.horsesrun.service;

import java.util.List;


import com.zemu.horsesrun.model.Horse;
import com.zemu.horsesrun.model.Race;

public class RaceService {
	private Race race;

	public void configRace(double distance, List<Horse> horses) {
		race = new Race(distance);
		for (Horse h : horses) {
			race.addHorses(h);
		}
		System.out.println(distance);
	}

	public void wasteMovement() {
		if (race != null && !race.isFinish()) {
			race.nextRound();
		}
	}

	public boolean isFinish() {
		return race != null && race.isFinish();
	}

	public Horse getWinner() {
		return race != null ? race.getWinner() : null;
	}

	public List<Horse> getHorses() {
		return race != null ? race.getHorses() : null;
	}
	public double getDistance() {
	    return race != null ? race.getDistance() : 0;
	}
}
