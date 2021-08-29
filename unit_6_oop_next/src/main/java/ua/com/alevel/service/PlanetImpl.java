package ua.com.alevel.service;

import java.math.BigDecimal;

public class PlanetImpl implements Planet {

    private final BigDecimal gConstant = new BigDecimal("6.67E-11");

    @Override
    public BigDecimal accelerationOfGravity(BigDecimal weight, BigDecimal radius) {
        return gConstant.multiply(weight.divide(radius.pow(2), 5)).setScale(2, BigDecimal.ROUND_CEILING);
    }
}
