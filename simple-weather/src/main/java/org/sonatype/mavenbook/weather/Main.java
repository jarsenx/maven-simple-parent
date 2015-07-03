package org.sonatype.mavenbook.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {

  public static void main(String[] args) throws Exception {
    // Configure Log4j
    PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));

    // Read the Zip code from the command line
    // if none supplied, use 21204
    String zipcode = "21204";
    try {
      zipcode = args[0];
    } catch (Exception ex) {

    }

    // Start the program
    new Main(zipcode).start();
  }

  private String zip;

  public Main(String zip) {
    this.zip = zip;
  }

  public void start() throws Exception {
    // Retrieve Data
    InputStream datain = new YahooRetriever().retrieve(zip);

    //Parse Data
    Weather weather = new YahooParser().parse(datain);

    // Format (Print) Data
    System.out.println(new WeatherFormatter().format(weather));

  }

}