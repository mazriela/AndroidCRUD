package udacoding.com.androidjavacrud.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import udacoding.com.androidjavacrud.tambahdata.model.ResponseTambahData;

public interface RestApi {

    @FormUrlEncoded
    @POST("AddUser")
    Call<ResponseTambahData> tambah_user(
            @Field("nama_user") String namaUser,
            @Field("email_user") String emailUser,
            @Field("no_hp_user") String hpUser,
            @Field("alamat") String alamat

    );
}
