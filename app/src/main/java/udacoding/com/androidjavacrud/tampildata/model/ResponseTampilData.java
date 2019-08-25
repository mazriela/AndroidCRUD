package udacoding.com.androidjavacrud.tampildata.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseTampilData{

	@SerializedName("response_code")
	private int responseCode;

	@SerializedName("data")
	private List<DataItemTampiUser> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setResponseCode(int responseCode){
		this.responseCode = responseCode;
	}

	public int getResponseCode(){
		return responseCode;
	}

	public void setData(List<DataItemTampiUser> data){
		this.data = data;
	}

	public List<DataItemTampiUser> getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseTampilData{" + 
			"response_code = '" + responseCode + '\'' + 
			",data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}