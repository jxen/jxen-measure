package com.github.jxen.measure.spi;

import com.github.jxen.measure.misc.ApothecariesUnits;
import com.github.jxen.measure.misc.CgsUnits;
import com.github.jxen.measure.misc.ImperialUnits;
import com.github.jxen.measure.misc.LegacyUnits;
import com.github.jxen.measure.misc.RussianUnits;
import com.github.jxen.measure.misc.TemperatureUnits;
import com.github.jxen.measure.misc.TroyUnits;
import com.github.jxen.measure.misc.UsCustomaryUnits;

class MiscSystemOfUnitsService extends DefaultSystemOfUnitsService {

	MiscSystemOfUnitsService() {
		add(ImperialUnits.SYSTEM);
		add(UsCustomaryUnits.SYSTEM);
		add(TroyUnits.SYSTEM);
		add(ApothecariesUnits.SYSTEM);
		add(RussianUnits.SYSTEM);
		add(TemperatureUnits.SYSTEM);
		add(CgsUnits.SYSTEM);
		add(LegacyUnits.SYSTEM);
	}
}
