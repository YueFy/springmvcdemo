package usts.pojoj;

public class Country {
    private String location;
    private String population;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "location='" + location + '\'' +
                ", population='" + population + '\'' +
                '}';
    }
}
