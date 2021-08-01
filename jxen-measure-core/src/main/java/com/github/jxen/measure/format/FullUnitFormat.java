package com.github.jxen.measure.format;

import com.github.jxen.measure.format.UnitNameHelper.Formatter;
import com.github.jxen.measure.format.UnitNameHelper.FullFormatter;
import com.github.jxen.measure.spi.LocaleService;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.ServiceLoader;
import java.util.stream.Stream;

/**
 * {@code FullUnitFormat} class is extension of {@link MeasureUnitFormat}.
 *
 * @author Denis Murashev
 * @since Measure 0.1
 */
public class FullUnitFormat extends MeasureUnitFormat {

  private static final Map<Locale, LocaleAdapter> ADAPTERS = new HashMap<>();

  static {
    ADAPTERS.put(Locale.ROOT, DEFAULT_ADAPTER);
    for (LocaleService service : ServiceLoader.load(LocaleService.class)) {
      ADAPTERS.putIfAbsent(service.getLocale(), service.getAdapter());
    }
  }

  @Override
  protected Formatter getFormatter(List<ResourceBundle> bundles) {
    LocaleAdapter adapter = ADAPTERS.get(Locale.getDefault());
    if (Objects.isNull(adapter)) {
      adapter = stream(Locale.getDefault())
          .filter(ADAPTERS::containsKey)
          .map(ADAPTERS::get).findFirst().orElse(DEFAULT_ADAPTER);
      ADAPTERS.put(Locale.getDefault(), adapter);
    }
    return new FullFormatter(adapter, bundles);
  }

  private static Stream<Locale> stream(Locale locale) {
    return Stream.of(new Locale(locale.getLanguage(), locale.getCountry(), locale.getVariant()),
            new Locale(locale.getLanguage(), locale.getCountry()),
            new Locale(locale.getLanguage()),
            Locale.ROOT)
        .distinct();
  }
}
