package ua.lviv.lgs.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.xml.DOMConfigurator;

public class ConnectionUtils {

	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "7870qQ11@";
	private static String URL = "jdbc:mysql://localhost/i_shop?useUnicode=true&serverTimezone=UTC";

	public static Connection openConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		DOMConfigurator.configure("loggerConfig.xml");
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}
}