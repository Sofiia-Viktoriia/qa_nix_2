package ua.com.alevel;

import ua.com.alevel.data.*;

public class PlanetReporter {

    private Sphere mercury = new Mercury();
    private Sphere venus = new Venus();
    private Sphere earth = new Earth();
    private Sphere mars = new Mars();
    private Sphere jupiter = new Jupiter();
    private Sphere saturn = new Saturn();
    private Sphere uranus = new Uranus();
    private Sphere neptune = new Neptune();

    public void printAccelerationOfGravity(int i) {
        switch (i) {
            case 1:
                print(mercury);
                break;
            case 2:
                print(venus);
                break;
            case 3:
                print(earth);
                break;
            case 4:
                print(mars);
                break;
            case 5:
                print(jupiter);
                break;
            case 6:
                print(saturn);
                break;
            case 7:
                print(uranus);
                break;
            case 8:
                print(neptune);
                break;
            case 9:
                print(mercury);
                print(venus);
                print(earth);
                print(mars);
                print(jupiter);
                print(saturn);
                print(uranus);
                print(neptune);
                break;
        }
    }

    public void print(Sphere planet) {
        System.out.println(planet.getClass().getSimpleName() + "'s acceleration of gravity is " + planet.countAccelerationOfGravity());
    }
}
