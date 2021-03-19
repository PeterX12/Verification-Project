package cm;

import java.math.BigDecimal;

public class VisitorCalculator implements  RateCalculator {

    @Override
    public BigDecimal calculate(BigDecimal price) {
        BigDecimal free = new BigDecimal(8);
        BigDecimal reduced = new BigDecimal(0.50);

        if(price.compareTo(free) == 0 || price.compareTo(free) == -1){
            return new BigDecimal(0);
        }
        else{
            return price.subtract(free).multiply(reduced);
        }
    }
}
