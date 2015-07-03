package org.sonatype.mavenbook.weather;

import java.io.InputStream;

/**
 * Created by jarsen on 7/2/15.
 */
public class WeatherService {

    public WeatherService() { }

    public String retrieveForecast(String zip) throws Exception {

        // Retrieve Data
        InputStream dataIn = new YahooRetriever().retrieve(zip);

        // Parse Data
        Weather weather = new YahooParser().parse(dataIn);

        // Format (Print) Data
        return new WeatherFormatter().format(weather);

    }

}
