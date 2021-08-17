package ua.com.alevel.practice;

public class B extends Letter {

    private String asdf;

    public B() {}

    public B(String asdf, int sf, String aljed) {
        this.asdf = asdf;
        super.setSf(sf);
        super.setAljed(aljed);
    }

    public String getAsdf() {
        return asdf;
    }

    public void setAsdf(String asdf) {
        this.asdf = asdf;
    }

    @Override
    public String toString() {
        return "A{" +
                "sf='" + super.getSf() + '\'' +
                "aljed='" + super.getAljed() + '\'' +
                "asdf='" + asdf + '\'' +
                '}';
    }
}
