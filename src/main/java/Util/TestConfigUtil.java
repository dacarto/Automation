package Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Generic.Parameters;
import Lib.PropertiesManager;

/**
 * The Class TestConfigUtil.
 */
public class TestConfigUtil {
	
	/** The log. */
	private static Logger LOG = LoggerFactory.getLogger(TestConfigUtil.class);
	
	/**
	 * Instantiates a new test config util.
	 */
	private TestConfigUtil() {

	}

	/**
	 * Gets the base path.
	 *
	 * @return the base path
	 */
	public static String getBasePath(){
		String base_path = "";
		try {
			if (System.getProperty("run.environment") == null) {
				base_path = System.getProperty("user.dir") + "\\";
			} else {
				base_path = System.getProperty("path.base") + "\\";
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return base_path;
	}
	
	/**
	 * Gets the report file path.
	 *
	 * @return the report file path
	 * @throws Exception the exception
	 */
	public static String getReportFilePath() throws Exception{
		String response ="";
		try{
			response = getBasePath()+"\\TEMP";
		}catch(Exception e){
			LOG.info(e.getMessage(), e);
		}
		return response;
	}
	
	/**
	 * Gets the test data file path txt.
	 *
	 * @param properties the properties
	 * @param tag the tag
	 * @return the test data file path txt
	 */
	public static String getTestDataFilePathTxt(PropertiesManager properties, String tag){
		String basePath = "";
		try{
			basePath = getReportFilePath();
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
		}
		return basePath+"/";
	}
	
	/**
	 * Gets the base path alternate.
	 *
	 * @return the base path alternate
	 * @throws Exception the exception
	 */
	public static String getBasePathAlternate() throws Exception{
		String base_path = "";
		try {
			if (System.getProperty("run.environment") == null) {
				base_path = System.getProperty("user.dir");
			} else {
				base_path = System.getProperty("path.base");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return base_path;
	}
	
	
	/**
	 * Gets the project properties.
	 *
	 * @param fileName the file name
	 * @return the project properties
	 */
	public static PropertiesManager getProjectProperties(String fileName){
		PropertiesManager prop = null;
		try {
			String base_path = getBasePath();
			prop = new PropertiesManager(base_path + "/Config/"+fileName);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return prop;
	}
	
	public static PropertiesManager getSearchXpathProperties(){
		PropertiesManager prop = null;
		try {
			String base_path = getBasePath();
			prop = new PropertiesManager(base_path + "/Config/" + Parameters.EbayXpathPropertiesFile);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return prop;
	}
	
}
