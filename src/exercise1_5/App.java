package exercise1_5;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final CountryArrayManager countryManager = new CountryArrayManager();

    public static void main(String[] args) {
        init();
        testOriginalData();

        System.out.println("\n===============================");
        testSortIncreasingByPopulation();
        testSortDecreasingByPopulation();

        System.out.println("\n===============================");
        testSortIncreasingByArea();
        testSortDecreasingByArea();

        System.out.println("\n===============================");
        testSortIncreasingByGdp();
        testSortDecreasingByGdp();

        System.out.println("\n===============================");
        testFilterAfricaCountry();
        testFilterAsiaCountry();
        testFilterEuropeCountry();
        testFilterNorthAmericaCountry();
        testFilterOceaniaCountry();
        testFilterSouthAmericaCountry();

        System.out.println("\n===============================");
        testFilterMostPopulousCountries();
        testFilterLeastPopulousCountries();

        System.out.println("\n===============================");
        testFilterLargestAreaCountries();
        testFilterSmallestAreaCountries();

        System.out.println("\n===============================");
        testFilterHighestGdpCountries();
        testFilterLowestGdpCountries();

    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null; // BufferedReader để đọc văn bản từ luồng đầu vào
        try {
            dataReader = new BufferedReader(new FileReader(filePath));
            String line; // Đọc các dữ liệu theo dòng
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.get(0).equals("code")) {
                    continue;
                }
                if (dataList.size() !=6) {
                    continue;
                }
                switch (dataList.get(5)) {
                    case "Africa":
                        Country africa = new AfricaCountry(dataList.get(0),dataList.get(1),Integer.parseInt(dataList.get(2)), Double.parseDouble(dataList.get(3)), Double.parseDouble(dataList.get(4))) ;
                        countryManager.append(africa);
                    case "Asia":
                        Country asia = new AsiaCountry(dataList.get(0),dataList.get(1),Integer.parseInt(dataList.get(2)), Double.parseDouble(dataList.get(3)), Double.parseDouble(dataList.get(4))) ;
                        countryManager.append(asia);
                    case "Europe":
                        Country europe = new EuropeCountry(dataList.get(0),dataList.get(1),Integer.parseInt(dataList.get(2)), Double.parseDouble(dataList.get(3)), Double.parseDouble(dataList.get(4))) ;
                        countryManager.append(europe);
                    case "North America":
                        Country northAmerica = new NorthAmericaCountry(dataList.get(0),dataList.get(1),Integer.parseInt(dataList.get(2)), Double.parseDouble(dataList.get(3)), Double.parseDouble(dataList.get(4))) ;
                        countryManager.append(northAmerica);
                    case "Oceania":
                        Country oceania = new OceaniaCountry(dataList.get(0),dataList.get(1),Integer.parseInt(dataList.get(2)), Double.parseDouble(dataList.get(3)), Double.parseDouble(dataList.get(4))) ;
                        countryManager.append(oceania);
                    case "South America":
                        Country southAmerica = new SouthAmericaCountry(dataList.get(0),dataList.get(1),Integer.parseInt(dataList.get(2)), Double.parseDouble(dataList.get(3)), Double.parseDouble(dataList.get(4))) ;
                        countryManager.append(southAmerica);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (dataReader != null) {
                    dataReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }
        return dataLine.split(COMMA_DELIMITER);
    }

    public static void init() {
        String filePath = "C:\\Users\\VNC\\IdeaProjects\\OPP_Tuan6\\src\\data\\countries.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        String codesString = CountryArrayManager.codeOfCountriesToString(countryManager.getCountries());
        System.out.print(codesString);
    }

    public static void testSortIncreasingByPopulation() {
        Country[] countries = countryManager.sortByIncreasingPopulation();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.print(codesString);
    }

    public static void testSortDecreasingByPopulation() {
        /* TODO */
        Country[] countries = countryManager.sortByDecreasingPopulation();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.print(codesString);
    }

    public static void testSortIncreasingByArea() {
        /* TODO */
        Country[] countries = countryManager.sortByIncreasingArea();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testSortDecreasingByArea() {
        /* TODO */
        Country[] countries = countryManager.sortByDecreasingArea();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testSortIncreasingByGdp() {
        /* TODO */
        Country[] countries = countryManager.sortByIncreasingGdp();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testSortDecreasingByGdp() {
        /* TODO */
        Country[] countries = countryManager.sortByDecreasingGdp();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterAfricaCountry() {
        /* TODO */
        Country[] countries = countryManager.filterAfricaCountry();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterAsiaCountry() {
        /* TODO */
        Country[] countries = countryManager.filterAsianCountry();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterEuropeCountry() {
        /* TODO */
        Country[] countries = countryManager.filterEuropeCountry();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterNorthAmericaCountry() {
        /* TODO */
        Country[] countries = countryManager.filterNorthAmerican();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterOceaniaCountry() {
        /* TODO */
        Country[] countries = countryManager.filterOceaniaCountry();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterSouthAmericaCountry() {
        /* TODO */
        Country[] countries = countryManager.filterSouthAmericanCountry();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterMostPopulousCountries() {
        /* TODO */
        Country[] countries = countryManager.filterMostPopulousCountries(3);
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterLeastPopulousCountries() {
        /* TODO */
        Country[] countries = countryManager.filterLeastPopulousCountries(3);
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterLargestAreaCountries() {
        /* TODO */
        Country[] countries = countryManager.filterLargestAreaCountries(3);
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterSmallestAreaCountries() {
        /* TODO */
        Country[] countries = countryManager.filterSmallestAreaCountries(3);
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterHighestGdpCountries() {
        /* TODO */
        Country[] countries = countryManager.filterHighestGdpCountries(3);
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

    public static void testFilterLowestGdpCountries() {
        /* TODO */
        Country[] countries = countryManager.filterLowestGdpCountries(3);
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codesString);
    }

}