package com.production.demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PersistanceTest {
	enum Days {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	//Periode
			public static List<Long> periodeCalcul(LocalDateTime times1, LocalDateTime times2) {
				List<Long> r = new ArrayList<>();
				LocalDateTime tempDateTime = LocalDateTime.from(times1);

				long years = tempDateTime.until(times2, ChronoUnit.YEARS);
				tempDateTime = tempDateTime.plusYears(years);

				long months = tempDateTime.until(times2, ChronoUnit.MONTHS);
				tempDateTime = tempDateTime.plusMonths(months);

				long days = tempDateTime.until(times2, ChronoUnit.DAYS);
				tempDateTime = tempDateTime.plusDays(days);

				long hours = tempDateTime.until(times2, ChronoUnit.HOURS);
				tempDateTime = tempDateTime.plusHours(hours);

				long minutes = tempDateTime.until(times2, ChronoUnit.MINUTES);
				tempDateTime = tempDateTime.plusMinutes(minutes);

				long seconds = tempDateTime.until(times2, ChronoUnit.SECONDS);
				Long totalSeconds;
				totalSeconds = seconds + minutes * 60 + hours * 60 * 60 + days * 24 * 60 * 60 + months * 30 * 24 * 60 * 60
						+ years * 365 * 24 * 60 * 60;
				r.add(years);
				r.add(months);
				r.add(days);
				r.add(hours);
				r.add(minutes);
				r.add(seconds);
				r.add(totalSeconds);
				return r;
			}
	public static void main(String[] agrs) {
		LocalDateTime d1 = LocalDateTime.parse("2001-01-20T12:22:15");
		LocalDateTime d2 = LocalDateTime.parse("2001-01-19T12:25:15");
		System.out.println(Duration.between(d1, d2).toMillis());
}
}
