package ua.com.alevel.data;

import ua.com.alevel.service.PlanetImpl;

import java.math.BigDecimal;

public class Earth extends Sphere {

    private final BigDecimal weight = new BigDecimal(5.97E24);
    private final BigDecimal radius = new BigDecimal(6.37E6);

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
