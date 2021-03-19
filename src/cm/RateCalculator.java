package cm;

import java.math.BigDecimal;

public interface RateCalculator {
    BigDecimal calculate(BigDecimal price);
}
