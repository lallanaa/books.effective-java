package com.book.effectivejava.juu.chapter2.item3.functionalinterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UsageOfFunctions {
	public static void main(String[] args) {
		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(1982, 7, 15));
		dates.add(LocalDate.of(2011, 7, 15));
		dates.add(LocalDate.of(2013, 7, 15));

		Predicate<LocalDate> localDatePredicate = d -> d.isBefore(LocalDate.of(2000, 1, 1));
		Function<LocalDate, Integer> getYear = LocalDate::getYear;
		List<Integer> before2000 = dates.stream()
			.filter(localDatePredicate)
			.map(getYear)
			.collect(Collectors.toList());

	}
}
