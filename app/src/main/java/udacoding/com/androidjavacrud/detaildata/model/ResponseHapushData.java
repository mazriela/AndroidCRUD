package udacoding.com.androidjavacrud.detaildata.model;

import com.google.gson.annotations.SerializedName;

public class ResponseHapushData {

	@SerializedName("response_code")
	private int responseCode;

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
			"ResponseTambahData{" + 
			"response_code = '" + responseCode + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}