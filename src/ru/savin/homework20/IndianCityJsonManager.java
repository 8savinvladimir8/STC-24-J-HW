package ru.savin.homework20;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.Formatter;

public class IndianCityJsonManager {
    private IndianCityJsonManager() {}

    public static void getIndianCitiesJSON(String searchParameter) {
        searchParameter = searchParameter.replaceAll("(?iu)" + " ","+");

        ObjectMapper mapper = new ObjectMapper();
        try {
            IndianCity[] city = mapper.readValue(new URL("https://indian-cities-api-nocbegfhqg.now.sh/cities" + searchParameter), IndianCity[].class);

            String delimiter = "==========";
            printCatalogString("Город", "Штат", "Округ");
            printCatalogString(delimiter, delimiter, delimiter);

            for (IndianCity c: city) {
                printCatalogString(c.getCity(), c.getState(), c.getDistrict());
            }

            serializeCatalog(city);
        } catch (Exception e) {
            IndianCityCatalog.log.error(e.fillInStackTrace());
        }
    }

    public static void printCatalogString(String city, String state, String district) {
        try (Formatter catalogFormatter = new Formatter()) {
            catalogFormatter.format("%-60.60s%-40.40s%-40.40s", city, state, district);
            IndianCityCatalog.log.info(catalogFormatter);
        } catch (Exception e) {
            IndianCityCatalog.log.error(e.fillInStackTrace());
        }
    }

    public static void serializeCatalog(IndianCity[] city) {
        try (FileWriter fw = new FileWriter("IndianCities.json")) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(fw, city);
        } catch (Exception e) {
            IndianCityCatalog.log.error(e.fillInStackTrace());
        }
    }

    public static void deserializeCatalog() {
        File file = new File("IndianCities.json");
        if (!file.exists()) {
            IndianCityCatalog.log.error("Файл IndianCities.json не существует");
            return;
        }

        try (FileReader fr = new FileReader("IndianCities.json")) {
            ObjectMapper mapper = new ObjectMapper();
            IndianCity[] city = mapper.readValue(fr, IndianCity[].class);

            String delimiter = "==========";
            printCatalogString("Город", "Штат", "Округ");
            printCatalogString(delimiter, delimiter, delimiter);

            for (IndianCity c: city) {
                printCatalogString(c.getCity(), c.getState(), c.getDistrict());
            }
        } catch (Exception e) {
            IndianCityCatalog.log.error(e.fillInStackTrace());
        }
    }
}
