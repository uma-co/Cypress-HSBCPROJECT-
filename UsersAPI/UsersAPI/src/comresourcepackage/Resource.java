package comresourcepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Resource {
	
	static RequestSpecification req;
	static ResponseSpecification res;
	
	public static String GlobalPropData(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/home/umaraaj1999gmai/Downloads/UsersAPI/GlobalpropData.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	public static RequestSpecification RequestData() throws IOException {
		PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
		   req = new RequestSpecBuilder().setBaseUri(GlobalPropData("baseurl"))
					.addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream)).build();
			return req;	
	}
	

}
