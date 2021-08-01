package com.github.jxen.measure.data;

import com.github.jxen.measure.quantity.impl.Quantities;
import com.github.jxen.measure.spi.SubstanceService;
import com.github.jxen.measure.unit.AbstractUnit;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import javax.measure.MeasurementException;
import javax.measure.Quantity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;

final class YamlUtil {

  private static final Logger LOG = LogManager.getLogger(YamlUtil.class);

  private YamlUtil() {
  }

  static <Q extends Quantity<Q>> Map<Substance<?>, Quantity<Q>> fill(Class<?> type, AbstractUnit<Q> unit) {
    Map<Substance<?>, Quantity<Q>> map = new HashMap<>();
    for (SubstanceService<?> service : ServiceLoader.load(SubstanceService.class)) {
      fill(map, service.getEnumClass(), type, unit);
    }
    return map;
  }

  private static <T extends Enum<T> & Substance<T>, Q extends Quantity<Q>> void fill(Map<? super T, Quantity<Q>> map,
      Class<T> enumClass, Class<?> type, AbstractUnit<Q> unit) {
    String name = enumClass.getSimpleName() + "_" + type.getSimpleName() + ".yaml";
    try (InputStream inputStream = type.getResourceAsStream(name)) {
      if (Objects.isNull(inputStream)) {
        LOG.warn(() -> "No data for " + enumClass);
        return;
      }
      Map<String, Map<String, Number>> data = new Yaml().load(inputStream);
      Map<String, Number> substances = data.get("substances");
      if (Objects.nonNull(substances)) {
        substances.forEach((key, value) -> {
          BigDecimal v = BigDecimal.valueOf(value.doubleValue());
          map.put(Enum.valueOf(enumClass, key), Quantities.of(v, unit));
        });
      }
    } catch (IOException | YAMLException e) {
      throw new MeasurementException("Unable to read data", e);
    }
  }
}
