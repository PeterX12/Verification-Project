package cm;

import java.math.BigDecimal;

public class ManagementCalculator implements RateCalculator {

    @Override
    public BigDecimal calculate(BigDecimal price) {
        BigDecimal min = new BigDecimal(3);

        if(price.compareTo(min) == -1){
            return min;
        }
        else{
            return price;
        }
    }
}
