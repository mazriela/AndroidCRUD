package udacoding.com.androidjavacrud.tambahdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import udacoding.com.androidjavacrud.MainActivity;
import udacoding.com.androidjavacrud.R;
import udacoding.com.androidjavacrud.tambahdata.model.ResponseTambahData;
import udacoding.com.androidjavacrud.network.NetworkClient;
import udacoding.com.androidjavacrud.tampildata.ShowDataUserActivity;

public class AddDataUserActivity extends AppCompatActivity {

    @BindView(R.id.etNamaUser)
    EditText etNamaUser;
    @BindView(R.id.etEmailUser)
    EditText etEmailUser;
    @BindView(R.id.etNoHpUser)
    EditText etNoHpUser;
    @BindView(R.id.etAlamatIser)
    EditText etAlamatIser;
    @BindView(R.id.btnTambahDataUser)
    Button btnTambahDataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_user);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnTambahDataUser)
    public void onViewClicked() {
        actionTambahData();

    }

    private  void  actionTambahData(){
        String nama = etNamaUser.getText().toString();
        String email = etEmailUser.getText().toString();
        String  noHp = etNoHpUser.getText().toString();
        String  alamat = etAlamatIser.getText().toString();


        if(nama.isEmpty()){
            etNamaUser.setError("Nama tidak boleh kosong");
            etNamaUser.requestFocus();
        } else if (email.isEmpty()){
            etEmailUser.setError("Email tidak boleh kosong");
            etEmailUser.requestFocus();
        } else if(noHp.isEmpty()){
            etNoHpUser.setError("No Hp tidak boleh kosong");
            etNoHpUser.requestFocus();
        } else if(alamat.isEmpty()){
            etAlamatIser.setError("Alamat tidak boleh kosong");
            etAlamatIser.requestFocus();
        } else {
            NetworkClient.service.tambah_user(nama,email,noHp,alamat).enqueue(new Callback<ResponseTambahData>() {
                @Override
                public void onResponse(Call<ResponseTambahData> call, Response<ResponseTambahData> response) {
                    if(response.isSuccessful()){
                        Boolean status = response.body().isStatus();
                        String message = response.body().getMessage();

                        if(status){
                            startActivity(new Intent(AddDataUserActivity.this, ShowDataUserActivity.class));
                            Toast.makeText(AddDataUserActivity.this, message, Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(AddDataUserActivity.this, message, Toast.LENGTH_SHORT).show();
                        }

                    }
                }

                @Override
                public void onFailure(Call<ResponseTambahData> call, Throwable t) {
                    t.printStackTrace();

                }
            });
        }


    }
}
