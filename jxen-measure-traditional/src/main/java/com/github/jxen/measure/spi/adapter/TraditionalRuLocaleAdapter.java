package com.github.jxen.measure.spi.adapter;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Set;

class TraditionalRuLocaleAdapter extends RuLocaleAdapter {

	private static final String[] FEMININE = {
			"bochka",
			"bottle",
			"chain",
			"charka",
			"dessyatina",
			"dolya",
			"dram",
			"fathom",
			"league",
			"line",
			"mile",
			"ounce",
			"part",
			"point",
			"quarter",
			"span",
			"spoon",
			"ton",
			"verst",
	};

	private static final Set<String> FEMININE_NAMES = new HashSet<>(asList(FEMININE));

	@Override
	public boolean isFeminine(String name) {
		return FEMININE_NAMES.contains(name) || super.isFeminine(name);
	}
}
