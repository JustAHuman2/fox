package com.ua.foxminded.domain;

import java.time.LocalTime;

public class LessonTime {

	private LocalTime startTime;
	private LocalTime endTime;

	public LessonTime(LocalTime startTime, LocalTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	@Override
	public String toString() {
		return startTime + "-" + endTime;
	}
}