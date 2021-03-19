package cm;

import java.math.BigDecimal;

public class StaffCalculator implements RateCalculator{
    @Override
    public BigDecimal calculate(BigDecimal price) {
        BigDecimal max = new BigDecimal(16);

        if(price.compareTo(max) == 1){
            return max;
        }
        else{
            return price;
        }
    }
}
