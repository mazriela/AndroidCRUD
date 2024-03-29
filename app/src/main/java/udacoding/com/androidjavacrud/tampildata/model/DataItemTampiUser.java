package udacoding.com.androidjavacrud.tampildata.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataItemTampiUser implements Serializable {

	@SerializedName("email_user")
	private String emailUser;

	@SerializedName("no_hp_user")
	private String noHpUser;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("nama_user")
	private String namaUser;

	@SerializedName("alamat")
	private String alamat;

	public void setEmailUser(String emailUser){
		this.emailUser = emailUser;
	}

	public String getEmailUser(){
		return emailUser;
	}

	public void setNoHpUser(String noHpUser){
		this.noHpUser = noHpUser;
	}

	public String getNoHpUser(){
		return noHpUser;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setNamaUser(String namaUser){
		this.namaUser = namaUser;
	}

	public String getNamaUser(){
		return namaUser;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	@Override
 	public String toString(){
		return 
			"DataItemTampiUser{" +
			"email_user = '" + emailUser + '\'' + 
			",no_hp_user = '" + noHpUser + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",nama_user = '" + namaUser + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}