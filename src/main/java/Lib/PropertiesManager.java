package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesManager {
	private Properties properties = null;
	private String fileName;
	private static final Logger LOG =  LoggerFactory.getLogger(PropertiesManager.class);
	
	/**
	 * Instantiates a new properties manager.
	 *
	 * @param filename the filename
	 * @throws Exception the exception
	 */
	public PropertiesManager(String filename){
		fileName = filename;
		
		properties = new Properties();
		try {
			properties.load(new FileInputStream(fileName));
		} catch (Exception e) {
			LOG.info(e.getMessage(),e);
		}
	}
	
	/**
	 * Gets the value.
	 *
	 * @param key the key
	 * @return the value
	 */
	public String getValue(String key) {
		String value =null;
		try{
			value = properties.getProperty(key);
		}catch(Exception e){
			LOG.info(e.getMessage(),e);
		}
		return value;
	}
	
	/**
	 * Gets the properties map.
	 *
	 * @return the properties map
	 */
	public Map<String,String> getPropertiesMap(){
		Map <String,String> keyInfo = null;
		
		try{
			keyInfo = new HashMap<String,String>();
			Enumeration<?> en = properties.propertyNames();
			while(en.hasMoreElements()){
				String key = (String) en.nextElement();
				String value = properties.getProperty (key);
				keyInfo.put(key, value);
			}
		}catch(Exception e){
			LOG.info(e.getMessage(),e);
		}
		return keyInfo;
	}
	
	/**
	 * Gets the list of properties files in an specified folder.
	 *
	 * @param path the folder path
	 * @return the list of properties files
	 */
	public List<String> getListPropertiesFiles(String path){
		List<String> propFiles = new ArrayList<String>();
		File dir = new File(path);
		File[] files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".properties");
		    }
		});
		for (File file : files){
			propFiles.add(file.getName());
		}
		return propFiles;
	}
	
	/**
	 * Gets the property from files.
	 *
	 * @param pm the Properties Manager
	 * @param filesList the files list
	 * @return the property values from all files
	 */
	public String getPropertyFromFiles(PropertiesManager pm, List<String> filesList){
		String propertyValues = "";
		int i = 0;
		for (String fileList : filesList){
			i++;
			if (i>1){
				propertyValues = propertyValues + ",";
			}
			fileList = fileList.substring(0, fileList.indexOf(".properties"));
			propertyValues = propertyValues + pm.getValue(fileList);
		}
		return propertyValues;
	}
	
}
