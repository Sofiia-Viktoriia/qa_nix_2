package ua.com.alevel.practice;

public class A extends Letter {

    private String lshb;

    public A() {}

    public A(String lshb, int sf, String aljed) {
        this.lshb = lshb;
        super.setSf(sf);
        super.setAljed(aljed);
    }

    public String getLshb() {
        return lshb;
    }

    public void setLshb(String lshb) {
        this.lshb = lshb;
    }

    @Override
    public String toString() {
        return "A{" +
                "sf='" + super.getSf() + '\'' +
                "aljed='" + super.getAljed() + '\'' +
                "lshb='" + lshb + '\'' +
                '}';
    }
}
