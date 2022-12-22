package exercise1_5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CountryArrayManager {
    private Country[] countries;
    private int length;
    private int increment;

    public CountryArrayManager() {
        this.increment = 10;
        countries = new Country[this.increment];
        this.length = 0;
    }

    public CountryArrayManager(int maxLength) {
        this.increment = 10;
        countries = new Country[maxLength];
        this.length = 0;
    }

    public Country[] getCountries() {
        return countries;
    }

    public int getLength() {
        return this.length;
    }

    private void correct() {
        int nullFirstIndex = 0;
        for (int i = 0; i < this.countries.length; i++) {
            if (this.countries[i] == null) {
                nullFirstIndex = i;
                break;
            }
        }

        if (nullFirstIndex > 0) {
            this.length = nullFirstIndex;
            for (int i = nullFirstIndex; i < this.countries.length; i++) {
                this.countries[i] = null;
            }
        }
    }

    public void allocatedMore() {
        Country[] newArray = new Country[this.countries.length + this.increment];
        System.arraycopy(this.countries, 0, newArray, 0, this.countries.length);
        this.countries = newArray;
    }

    public void append(Country country) {
        if (this.length > this.countries.length) {
            allocatedMore();
        }
    }

    public boolean add(Country country, int index) {
        if ((index < 0) || (index > this.countries.length)) {
            return false;
        }

        if (this.length >= this.countries.length) {
            allocatedMore();
        }

        for (int i = this.length; i > index; i--) {
            this.countries[i] = this.countries[i - 1];
        }

        this.countries[index] = country;
        this.length++;
        return true;
    }

    public boolean remove(int index) {
        if ((index < 0) || (index >= countries.length)) {
            return false;
        }

        for (int i = index; i < length - 1; i++) {
            this.countries[i] = this.countries[i + 1];
        }

        this.countries[this.length - 1] = null;
        this.length--;
        return true;
    }

    public Country countryAt(int index) {
        if ((index < 0) || (index > this.length)) {
            return null;
        }
        return this.countries[index];
    }

    public Country[] sortByIncreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        for (int i = 0; i < newArray.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[j].getPopulation() < newArray[minIdx].getPopulation()) {
                    minIdx = j;
                }
            }
            Country temp = newArray[i];
            newArray[i] = newArray[minIdx];
            newArray[minIdx] = temp;
        }
        return newArray;
    }

    public Country[] sortByDecreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        for (int i = 0; i < newArray.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[j].getPopulation() > newArray[maxIdx].getPopulation()) {
                    maxIdx = j;
                }
            }
            Country temp = newArray[i];
            newArray[i] = newArray[maxIdx];
            newArray[maxIdx] = temp;
        }
        return newArray;
    }

    public Country[] sortByIncreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        for (int i = 0; i < newArray.length - 1; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[i].getPopulation() > newArray[j].getPopulation()) {
                    Country temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
        return newArray;
    }

    public Country[] sortByDecreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        for (int i = 0; i < newArray.length - 1; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[i].getPopulation() < newArray[j].getPopulation()) {
                    Country temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
        return newArray;
    }

    public Country[] sortByIncreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        for (int i = 1; i < newArray.length; i++) {
            Country key = newArray[i];
            int j = i - 1;

            while (j >= 0 && newArray[j].getGdp() > key.getGdp()) {
                newArray[j + 1] = newArray[j];
                j = j - 1;
            }
            newArray[j + 1] = key;
        }
        return newArray;
    }

    public Country[] sortByDecreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        for (int i = 1; i < newArray.length; i++) {
            Country key = newArray[i];
            int j = i - 1;

            while (j >= 0 && newArray[j].getGdp() < key.getGdp()) {
                newArray[j + 1] = newArray[j];
                j = j - 1;
            }
            newArray[j + 1] = key;
        }
        return newArray;
    }

    // PHẦN TỰ CODE
    /*public AfricaCountry[] filterAfricaCountry() {
        AfricaCountry[] africaCountries = new AfricaCountry[this.length];
        int count = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getClass().getName().equals("AfricaCountry")) {
                count++;
            }
        }
        for (int i = 0; i < this.countries.length; i++) {
            for (int j = 0; j < count; j++) {
                if (countries[i].getClass().getName().equals("AfricaCountry")) {
                    africaCountries[j] = (AfricaCountry) countries[i];
                }
            }
        }
        return africaCountries;
    }*/
    // PHẦN ĐÁP ÁN
    public AfricaCountry[] filterAfricaCountry() {
        ArrayList<Country> arrayList = new ArrayList<>();
        for (Country country : countries) {
            if (country instanceof AfricaCountry) { // instanceof ở đây được hiểu theo tiếng anh nghĩa là
                arrayList.add(country);             // phiên bản tức là nếu country là phiên bản của AfricaCountry thì thêm vào mảng
            }
        }
        AfricaCountry[] res = new AfricaCountry[arrayList.size()];
        return arrayList.toArray(res); // toArray chuyển đổi mảng arrayList thành mảng một chiều res
        // Muốn in ra mảng bất kỳ sử dụng hàm Arrays.toString(res).
    }

    /*public AsiaCountry[] filterAsiaCountry() {
        AsiaCountry[] asiaCountries = new AsiaCountry[this.length];
        int count = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getClass().getName().equals("AsiaCountry")) {
                count++;
            }
        }
        for (int i = 0; i < this.countries.length; i++) {
            for (int j = 0; j < count; j++) {
                if (countries[i].getClass().getName().equals("AsiaCountry")) {
                    asiaCountries[j] = (AsiaCountry) countries[i];
                }
            }
        }
        return asiaCountries;
    }*/
    public AsiaCountry[] filterAsianCountry() {
        ArrayList<Country> arrayList = new ArrayList<>();
        for (Country country : countries) {
            if (country instanceof AsiaCountry) {
                arrayList.add(country);
            }
        }
        AsiaCountry[] res = new AsiaCountry[arrayList.size()];
        return arrayList.toArray(res);
    }

    /*public EuropeCountry[] filterEuropeCountry() {
        EuropeCountry[] europeCountries = new EuropeCountry[this.length];
        int count = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getClass().getName().equals("EuropeCountry")) {
                count++;
            }
        }
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < count; j++) {
                if (countries[i].getClass().getName().equals("EuropeCountry")) {
                    europeCountries[j] = (EuropeCountry) countries[i];
                }
            }
        }
        return europeCountries;

    }*/
     public EuropeCountry[] filterEuropeCountry() {
         ArrayList<Country> arrayList = new ArrayList<>();
         for (Country country : countries) {
             if (country instanceof EuropeCountry) {
                 arrayList.add(country);
             }
         }
         EuropeCountry[] res = new EuropeCountry[arrayList.size()];
         return arrayList.toArray(res);
     }
    /*public NorthAmericaCountry[] filterNorthAmericaCountry() {
        NorthAmericaCountry[] northAmericaCountries = new NorthAmericaCountry[this.length];
        int count = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getClass().getName().equals("NorthAmericaCountry")) {
                count++;
            }
        }
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if (countries[i].getClass().getName().equals("NorthAmericaCountry")) {
                    northAmericaCountries[j] = (NorthAmericaCountry) countries[i];
                }
            }
        }
        return northAmericaCountries;
    }*/
    public NorthAmericaCountry[] filterNorthAmerican() {
        ArrayList<Country> arrayList = new ArrayList<>();
        for (Country country : countries) {
            if (country instanceof NorthAmericaCountry) {
                arrayList.add(country);
            }
        }
        NorthAmericaCountry[] res = new NorthAmericaCountry[arrayList.size()];
        return  arrayList.toArray(res);
    }

    /*public OceaniaCountry[] filterOceanCountry() {
        OceaniaCountry[] oceaniaCountries = new OceaniaCountry[this.length];
        int count = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getClass().getName().equals("OceaniaCountry")) {
                count++;
            }
        }
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if (countries[i].getClass().getName().equals("OceaniaCountry")) {
                    oceaniaCountries[j] = (OceaniaCountry) countries[i];
                }
            }
        }
        return oceaniaCountries;
    }*/

    public OceaniaCountry[] filterOceaniaCountry() {
        ArrayList<Country> arrayList = new ArrayList<>();
        for (Country country : countries) {
            if (country instanceof OceaniaCountry) {
                arrayList.add(country);
            }
        }
        OceaniaCountry[] res = new OceaniaCountry[arrayList.size()];
        return  arrayList.toArray(res);
    }

    /*public SouthAmericaCountry[] filterSouthAmericaCountry() {
        SouthAmericaCountry[] southAmericaCountries = new SouthAmericaCountry[this.length];
        int count = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getClass().getName().equals("SouthAmericaCountry")) {
                count++;
            }
        }
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if (countries[i].getClass().getName().equals("SouthAmericaCountry")) {
                    southAmericaCountries[j] = (SouthAmericaCountry) countries[i];
                }
            }
        }
        return southAmericaCountries;
    }*/

    public SouthAmericaCountry[] filterSouthAmericanCountry() {
        ArrayList<Country> arrayList = new ArrayList<>();
        for (Country country : countries) {
            if (country instanceof SouthAmericaCountry) {
                arrayList.add(country);
            }
        }
        SouthAmericaCountry[] res = new SouthAmericaCountry[arrayList.size()];
        return arrayList.toArray(res);
    }

    /*public Country[] filterMostPopulousCountries(int howMany) {
        Country[] mostPopulousCountries = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            mostPopulousCountries[i] = sortByDecreasingPopulation()[i];
        }
        return mostPopulousCountries;
    }*/

    public Country[] filterMostPopulousCountries(int howMany) {
        return Arrays.copyOf(sortByDecreasingPopulation(), howMany);
    }

    /*public Country[] filterLeastPopulousCountries(int howMany) {
        Country[] newArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            newArray[i] = sortByIncreasingPopulation()[i];
        }
        return newArray;
    }

    public Country[] filterLargestAreaCountries(int howMany) {
        Country[] newArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            newArray[i] = sortByDecreasingArea()[i];
        }
        return newArray;
    }

    public Country[] filterSmallestAreaCountries(int howMany) {
        Country[] newArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            newArray[i] = sortByIncreasingArea()[i];
        }
        return newArray;
    }

    public Country[] filterHighestGdpCountries(int howMany) {
        Country[] newArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            newArray[i] = sortByDecreasingGdp()[i];
        }
        return newArray;
    }

    public Country[] filterLowestGdpCountries(int howMany) {
        Country[] newArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            newArray[i] = sortByIncreasingGdp()[i];
        }
        return newArray;
    }*/

    public Country[] filterLeastPopulousCountries(int howMany) {
        return Arrays.copyOf(sortByIncreasingPopulation(), howMany);
    }

    public Country[] filterLargestAreaCountries(int howMany) {
        return Arrays.copyOf(sortByDecreasingArea(), howMany);
    }

    public Country[] filterSmallestAreaCountries(int howMany) {
        return Arrays.copyOf(sortByIncreasingArea(), howMany);
    }

    public Country[] filterHighestGdpCountries(int howMany) {
        return Arrays.copyOf(sortByDecreasingGdp(), howMany);
    }
    public Country[] filterLowestGdpCountries(int howMany) {
        return Arrays.copyOf(sortByIncreasingGdp(), howMany);
    }


    public static String codeOfCountriesToString(Country[] countries) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                codeOfCountries.append(country.getCode()).append(" ");
            }
        }
        return codeOfCountries.toString().trim() + "]";
    }

    public static void print(Country[] countries) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                countriesString.append(country.toString()).append("\n");
            }
        }
        System.out.println(countriesString.toString().trim() + "]");
    }


}
