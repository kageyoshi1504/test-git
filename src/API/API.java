package API;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class API {
	private String status;
	private String country;
	private String message;
	private String isa;
	
	public API(String json)
	{
		JsonParser parse = new JsonParser();
		JsonObject jsonObject = parse.parse(json).getAsJsonObject();
		
		if (jsonObject.has("status"))
		{
			status = jsonObject.get("status").getAsString();
		}
		if (jsonObject.has("country"))
		{
			country = jsonObject.get("country").getAsString();
		}
		if (jsonObject.has("message"))
		{
			message = jsonObject.get("message").getAsString();
		}
		if (jsonObject.has("isa")){
			isa = jsonObject.get("isa").getAsString();
		}
		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setISA(String isa){
		this.isa = isa;
	}
	public String getISA()
	{
		return isa;
	}	
	
}
