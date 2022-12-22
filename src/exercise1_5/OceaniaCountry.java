package exercise1_5;

public class OceaniaCountry extends Country{
    private int population;
    private double area;
    private double gdp;

    public OceaniaCountry(String code, String name, int population, double area, double gdp) {
        super(code, name);
        this.population = population;
        this.area = area;
        this.gdp = gdp;
    }

    @Override
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }
}
