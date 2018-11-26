package com.whiteclarks.aps.commandline.arguments;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import junit.framework.Assert;

/**
 * CommandLineArgumentsTest
 *
 * @author Ayush Verma
 *
 * This class reads the properties defined in my.properties.
 * my.properties file is generated during compile time and
 * all properties are picked from <properties> tags of pom.xml
 *
 * These arguments can also be passed from mvn command as
 * mvn clean install -D<property_name>=<property_value> OR
 * mvn clean test -D<property_name>=<property_value>
 *
 * For current scenerio we can use
 * mvn clean install -DserviceUrl=https://localhost:9090 -DdbConn=jdbc.aws1919:9090.au OR
 * mvn clean test -DserviceUrl=https://localhost:9090 -DdbConn=jdbc.aws1919:9090.au
 */
public class CommandLineArgumentsTest {
	private static final String DEFAULT_SERVICE_URL = "https://localhost:9090";
	private static final String DEFAULT_DB_CONNECTION = "jdbc.aws1919:9090.au";

	@Test
	public void testCommandLineArguments() {
		java.io.InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("my.properties");
		java.util.Properties p = new Properties();
		try {
			p.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String serviceUrl = p.getProperty("serviceUrl");
		System.out.println("#########################################");
		System.out.println("Service URL: " + serviceUrl);
		Assert.assertEquals(DEFAULT_SERVICE_URL, serviceUrl);

		String dbConnection = p.getProperty("dbConn");
		System.out.println("DB Connection: " + dbConnection);
		Assert.assertEquals(DEFAULT_DB_CONNECTION, dbConnection);
		System.out.println("#########################################");
	}

}
