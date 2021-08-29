package ua.com.alevel.data;

import ua.com.alevel.service.PlanetImpl;

import java.math.BigDecimal;

public class Mercury extends Sphere {

    private final BigDecimal weight = new BigDecimal(3.33E23);
    private final BigDecimal radius = new BigDecimal(2.44E6);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    @Override
    public BigDecimal countAccelerationOfGravity() {
        PlanetImpl planet = new PlanetImpl();
        return planet.accelerationOfGravity(this.getWeight(), this.getRadius());
    }
}
