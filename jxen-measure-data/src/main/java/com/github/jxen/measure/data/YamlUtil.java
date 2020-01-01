package com.github.jxen.measure.data;

import com.github.jxen.measure.quantity.impl.Quantities;
import com.github.jxen.measure.unit.AbstractUnit;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import javax.measure.MeasurementException;
import javax.measure.Quantity;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;

final class YamlUtil {

	private YamlUtil() {
	}

	static <Q extends Quantity<Q>> Map<Substance, Quantity<Q>> fill(Map<Substance, Quantity<Q>> map, Class<?> type,
			AbstractUnit<Q> unit) {
		try (InputStream inputStream = type.getResourceAsStream(type.getSimpleName() + ".yaml")) {
			Map<String, Map<String, Number>> data = new Yaml().load(inputStream);
			Map<String, Number> substances = data.get("substances");
			if (Objects.nonNull(substances)) {
				substances.forEach((key, value) -> {
					Substance s = Substance.valueOf(key);
					BigDecimal v = BigDecimal.valueOf(value.doubleValue());
					map.put(s, Quantities.of(v, unit));
				});
			}
		} catch (IOException | YAMLException e) {
			throw new MeasurementException("Unable to read data", e);
		}
		return map;
	}
}
