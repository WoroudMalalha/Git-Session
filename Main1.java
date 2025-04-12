
package newpackage;

/**
 *
 * @author worod ahmad
 */
 class Country {

    private String name;
    private int populationSize;
    private double area;
    private String capital;
    private String currency;
    private String abbreviation;

  
    public Country(String name, int populationSize, double area, String capital, String currency) {
        this.name = name;
        this.populationSize = populationSize;
        this.area = area;
        this.capital = capital;
        this.currency = currency;
        this.abbreviation = generateAbbreviation(name);
    }

 
    public Country(String name, int populationSize) {
        this.name = name;
        this.populationSize = populationSize;
        this.area = 0;
        this.capital = "";
        this.currency = "";
        this.abbreviation = generateAbbreviation(name);
    }

  
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

   
    public void setArea(double area) {
        this.area = area;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    

   
    @Override
    public String toString() {
        return "Country: " + name + ", Population: " + populationSize + ", Area: " + area + ", Capital: " + capital + ", Currency: " + currency + ", Abbreviation: " + abbreviation;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass()!= obj.getClass()) {
            return false;
        }
        Country other = (Country) obj;
        return name.equals(other.name) && area == other.area;
    }

  
    private String generateAbbreviation(String name) {
        return name.substring(0, 3);
    }
}
public class Main1{

    public static void main(String[] args) {
        Country[] countries = new Country[5];

        countries[0] = new Country("Yemen", 67000000);
        countries[1] = new Country("Yemen", 83000000);
        countries[2] = new Country("Italy", 60000000);
        countries[3] = new Country("Spain", 46000000);
        countries[4] = new Country("Portugal", 10000000);

        for (int i = 0; i < countries.length; i++) {
            for (int j = 0; j < i; j++) {
                if (countries[i].getAbbreviation().equals(countries[j].getAbbreviation())) {
                    System.out.println("Country with similar abbreviation already exists.");
                    return;
                }
            }
        }

        for (Country country : countries) {
            country.setArea(Math.random() * 100000);
            country.setCapital("Capital " + country.getName());
        }

        System.out.println("Countries with area greater than 10000 square Km:");
        for (Country country : countries) {
            if (country.getArea() > 10000) {
                System.out.println(country.toString());
            }
        }
    }
}
    

