package model;

import java.util.HashMap;
import java.util.Map;

public class Home_Dto_ {

	private int layout_id;
	private int layout_count;
	private int layout_Num;
	private int occupied_area;

	 private Map<String, String> areaAndAppJspFileName;

	    public Home_Dto_() {
	        this.areaAndAppJspFileName = new HashMap<>();
	    }

	    public Map<String, String> getAreaAndAppJspFileName() {
	        return areaAndAppJspFileName;
	    }

	    public void setAreaAndAppJspFileName(Map<String, String> areaAndAppJspFileName) {
	        this.areaAndAppJspFileName = areaAndAppJspFileName;
	    }
	    public void addToAreaAndAppJspFileName(String area, String appjspfileName) {
	        this.areaAndAppJspFileName.put(area, appjspfileName);
	    }
	    public String getAreaAndAppJspFileNameByKey(String key) {
	        return areaAndAppJspFileName.get(key);
	    }

	public int getLayout_id() {
		return layout_id;
	}

	public void setLayout_id(int layout_id) {
		this.layout_id = layout_id;
	}

	public int getLayout_Num() {
		return layout_Num;
	}

	public void setLayout_Num(int layout_Num) {
		this.layout_Num = layout_Num;
	}

	public int getLayout_count() {
		return layout_count;
	}

	public void setLayout_count(int layout_count) {
		this.layout_count = layout_count;
	}

	public int getOccupied_area() {
		return occupied_area;
	}

	public void setOccupied_area(int occupied_area) {
		this.occupied_area = occupied_area;
	}

}
