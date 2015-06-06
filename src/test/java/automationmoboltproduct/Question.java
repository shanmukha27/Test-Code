package automationmoboltproduct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
	String parent_index;
	String name;
	
	public String getParent_index() {
		return parent_index;
	}
	public void setParent_index(String parent_index) {
		this.parent_index = parent_index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
