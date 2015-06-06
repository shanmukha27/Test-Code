package automationmoboltproduct;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.jxpath.ri.Parser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jsonread {
	public static WebDriver driver;
	@SuppressWarnings({"unchecked", "unused"})
	public static void main(String[] args) throws Exception, Exception {
		JSONParser parser=new JSONParser();
	
		try{
		/*	driver = new FirefoxDriver();
			driver.get("https://admin:AxkN!BjZx@cecentertainment-test.mobolt.com/en/job/list");
			driver.manage().window().maximize();
			driver.findElement(By.partialLinkText("Opening Coordinator")).click();
			driver.findElement(By.id("apply")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("a[data-social='manual']")).click();
			Thread.sleep(3000);
			String java_script = driver.findElement(By.xpath("/html/body/div[1]/div[3]/script")).getAttribute("innerHTML");
			System.out.println(java_script);
			// "curr_count":1,
			String get_questions[] = java_script.split("\"curr_count\":1,");
			System.out.println(get_questions[0]);
			System.out.println(get_questions[1]);
			String filter_ques[] = get_questions[1].split(",\"answers\":");
			System.out.println(filter_ques[0]);
			String questions_arr = "{"+filter_ques[0]+"}";
			System.out.println(questions_arr);*/
			FileInputStream fis = new FileInputStream("/Users/santoshkumar/Desktop/testjsonfile.json");
			String fileData = IOUtils.toString(fis);
			
			String question[] = fileData.split("\"questions\":");
			
			for (int i = 0; i < question.length; i++) {
				System.out.println(question[i]);
				
			}
			
			Map<String,Object> elementsMap = new HashMap<String, Object>(); //Extracting all the elements from JSON into an Hash Map
			ObjectMapper mapper = new ObjectMapper();
			elementsMap = mapper.readValue(fileData, new TypeReference<HashMap<String,Object>>() {});
			
			List<Object> questions = (List<Object>)elementsMap.get("questions"); //Get all the list of questions
			
			for (Object question : questions) { //Navigate into each and every question and performing actions
			Map<String,Object> questionMap = (Map<String, Object>) question;
			String validations = (String) questionMap.get("validations");
			
			String id = questionMap.get("id").toString();
			String visible = questionMap.get("visible").toString();
			String label = questionMap.get("label").toString();
			System.out.println("\n The id of the question: " +label+ " is "+ id);
			
			
			/*System.out.println(questionMap.get("id")); //Extracting id of a question
			String id = questionMap.get("id").toString();
			System.out.println("The id of this question is :"+id);
			//driver.findElement(By.id(id)).sendKeys("test");*/
			System.out.println("//input[contains(@id,'" + id + "')]");
			//driver.findElement(By.xpath("//input[contains(@id,'" + id + "')]")).sendKeys("test");
			System.out.println(questionMap.get("options")); //Extracting options of a question
			String options = questionMap.get("options").toString();
			String options_json = "{"+"\"options\":"+options+"}";
			System.out.println(options_json);
			
			Map<String,Object> inner_opt_map = new HashMap<String, Object>();
			ObjectMapper map = new ObjectMapper();
			inner_opt_map = map.readValue(options_json, new TypeReference<HashMap<String,Object>>() {});
			
			List<Object> option_s = (List<Object>)inner_opt_map.get("options");
			
			for (Object option : option_s) {
				Map<String, Object> optionMap = (Map<String, Object>) option;
				try{
				System.out.println(optionMap.get("index"));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			System.out.println("The options of this question is :"+options);
			System.out.println(questionMap.get("label")); //Extracting label of a question
			String label_name = questionMap.get("label").toString();
			System.out.println("The label name of this question is :"+label_name);
			Map<String,Object> validatonMap = new HashMap<String, Object>();
			
			validatonMap = mapper.readValue(validations, new TypeReference<HashMap<String,Object>>() {});
			
			System.out.println(validatonMap.get("knockout"));
			String compulsory = validatonMap.get("compulsory").toString();
			System.out.println(compulsory);
			Object knockout_val = validatonMap.get("knockout");
			Map<String, Object> knockout_ans = (Map<String, Object>) knockout_val;
			if(knockout_ans !=  null && !knockout_ans.isEmpty())
			System.out.println(knockout_ans.get("indices").toString().replaceAll("\\[", "").replaceAll("\\]", "").toString());
			
//			Map<String, Object> knockoutmap = new HashMap<String, Object>(); 
//			knockoutmap = mapper.readValue(knockout_val, new TypeReference<HashMap<String,Object>>() {});
//			
//			System.out.println(knockoutmap.get("indices"));
//			
			/*Map<String, String> = str;
			System.out.println(str);
			String test = str.toString();
			System.out.println(test);*/
			//Object obj = parser.parse(test);
			
			/*JSONObject jsnobj = (JSONObject) obj;
			
			String indices = (String) jsnobj.get("indices");
			System.out.println(indices);*/
			
			
		}
		}catch(Exception e){	
			e.printStackTrace();
		}
	}
}
