package com.github.jxen.measure.format;

import com.github.jxen.math.common.Adapters;
import com.github.jxen.math.common.ArithmeticAware;

/**
 * {@code RuLocaleAdapter} class is Locale adapter for Russian locale.
 *
 * @author Denis Murashev
 * @since Measure 0.1
 */
class RuLocaleAdapter implements LocaleAdapter {

	@Override
	public String getSuffix(Number number) {
		ArithmeticAware<?> adapter = Adapters.lookup(number);
		if (!adapter.isIntegral()) {
			return ".part";
		}
		final long ten = 10;
		long value = number.longValue();
		long rem10 = value % ten;
		long rem100 = value % (ten * ten);
		final long eleven = 11;
		if (rem10 == 1 && rem100 != eleven) {
			return "";
		}
		final long five = 5;
		final long fifteen = 15;
		if (rem10 == 0 || rem10 >= five || rem100 >= eleven && rem100 < fifteen) {
			return ".plural5";
		}
		return ".plural";
	}
}
