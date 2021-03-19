package cm;

import java.math.BigDecimal;

public class StudentCalculator implements RateCalculator{
    @Override
    public BigDecimal calculate(BigDecimal price) {
        BigDecimal mark = new BigDecimal(5.5);
        BigDecimal reduced = new BigDecimal(0.75);

        if(price.compareTo(mark) <= 0){
            return price;
        }
        else{
            return price.subtract(mark).multiply(reduced).add(mark);
        }
    }
}
