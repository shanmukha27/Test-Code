package automationmoboltproduct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jsonread1 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception, Exception {
		// TODO Auto-generated method stub
		try{
	
		FileReader reader = new FileReader("/Users/santoshkumar/Desktop/testjsonfile1.json");
		
		
		
		
		
		FileInputStream fis = new FileInputStream("/Users/santoshkumar/Desktop/testjsonfile1.json");
		String fileData = IOUtils.toString(fis);
		Map<String,Object> validationMap = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		try{
		validationMap = mapper.readValue(fileData, new TypeReference<HashMap<String,Object>>() {});
		List<Object> questions = (List<Object>)validationMap.get("questions");
		for (Object question : questions) {
			Map<String,Object> questionMap = (Map<String, Object>) question;
			System.out.println(questionMap.get("validations"));
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println();
		
		
		
		
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(reader);
		
		JSONArray questions= (JSONArray) jsonobject.get("questions");
		System.out.println(questions.size());
		
		for(int i=0; i<questions.size(); i++){
		System.out.println("The " + i + " Question: " +i +" " +questions.get(i));
		}
		Iterator i = questions.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			System.out.print(innerObj.get("validations").toString());
//			Map<String,Object> validationMap = new HashMap<String, Object>();
//			ObjectMapper mapper = new ObjectMapper();
//			try{
//			validationMap = mapper.readValue(innerObj.toString(), new TypeReference<HashMap<String,Object>>() {});
//			}catch(Exception e){
//				e.printStackTrace();
//			}
			//jsonobject.questions[0].backend_category;
			System.out.println("Test Question1 "+ innerObj.get("validations") +" Test Question2 " + innerObj.get("visible"));
			
		}
		/* String str = "hello";
		 compulsory_field = str.split("\"compulsory\":*")[0].split(":");
		 compulsory_message = str.split("compulsory_message");
		 
		 
		 
		String[] JSON = {\"compulsory\":1,\"compulsory_message\":\"\",\"custom\":\"\",\"required\":{},\"knockout\":{\"	\":[2],\"message\":\"\"},\"length\":[],\"value\":[],\"format\":[],\"datetime\":[],\"file_size\":[],\"file_type\":[]};
				
		}
		System.out.println(JSON);
		JSONObject obj = new JSONObject(JSON);
		JSONObject getSth = ((Object) jsn).getJSONObject("compulsory");
			*/
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
 
	
	}
}
