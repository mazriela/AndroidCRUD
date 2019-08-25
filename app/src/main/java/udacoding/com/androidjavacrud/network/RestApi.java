package udacoding.com.androidjavacrud.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import udacoding.com.androidjavacrud.detaildata.model.ResponseHapushData;
import udacoding.com.androidjavacrud.tambahdata.model.ResponseTambahData;
import udacoding.com.androidjavacrud.tampildata.model.ResponseTampilData;

public interface RestApi {

    @FormUrlEncoded
    @POST("AddUser")
    Call<ResponseTambahData> tambah_user(
            @Field("nama_user") String namaUser,
            @Field("email_user") String emailUser,
            @Field("no_hp_user") String hpUser,
            @Field("alamat") String alamat

    );
    @GET("ShowDataUser")
    Call<ResponseTampilData> tampil_user();

    @FormUrlEncoded
    @POST("DeleteDatauser")
    Call<ResponseHapushData> hapus_user(
            @Field("id_user") String idUser
    );
}
