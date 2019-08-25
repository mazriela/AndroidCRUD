package udacoding.com.androidjavacrud.detaildata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;
import udacoding.com.androidjavacrud.R;
import udacoding.com.androidjavacrud.detaildata.model.ResponseHapushData;
import udacoding.com.androidjavacrud.network.NetworkClient;
import udacoding.com.androidjavacrud.tampildata.ShowDataUserActivity;
import udacoding.com.androidjavacrud.tampildata.model.DataItemTampiUser;

public class DetailDataActivity extends AppCompatActivity {

    DataItemTampiUser dataItemTampiUser;
    @BindView(R.id.paramIdUser)
    TextView paramIdUser;
    @BindView(R.id.tvDetailNama)
    TextView tvDetailNama;
    @BindView(R.id.tvDetailEmail)
    TextView tvDetailEmail;
    @BindView(R.id.tvDetailNoHp)
    TextView tvDetailNoHp;
    @BindView(R.id.tvDetailAlamat)
    TextView tvDetailAlamat;
    @BindView(R.id.btnHapus)
    Button btnHapus;
    @BindView(R.id.btnNavigateToEdit)
    Button btnNavigateToEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        ButterKnife.bind(this);

        dataItemTampiUser = (DataItemTampiUser) getIntent().getSerializableExtra("data_user");
        paramIdUser.setText(dataItemTampiUser.getIdUser());
        tvDetailNama.setText(dataItemTampiUser.getNamaUser());
        tvDetailEmail.setText(dataItemTampiUser.getEmailUser());
        tvDetailNoHp.setText(dataItemTampiUser.getNoHpUser());
        tvDetailAlamat.setText(dataItemTampiUser.getAlamat());
    }


    @OnClick({R.id.btnHapus, R.id.btnNavigateToEdit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHapus:
                actionDeleteData();
                break;
            case R.id.btnNavigateToEdit:
                break;
        }
    }

    private void actionDeleteData() {
        String idUser = paramIdUser.getText().toString();

        NetworkClient.service.hapus_user(idUser).enqueue(new Callback<ResponseHapushData>() {
            @Override
            public void onResponse(Call<ResponseHapushData> call, Response<ResponseHapushData> response) {
                if(response.isSuccessful()){
                   String message = response.body().getMessage();
                   Boolean status = response.body().isStatus();

                   if(status){
                       startActivity(new Intent(DetailDataActivity.this, ShowDataUserActivity.class));
                       Toast.makeText(DetailDataActivity.this, message, Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(DetailDataActivity.this, message, Toast.LENGTH_SHORT).show();
                   }
                }
            }

            @Override
            public void onFailure(Call<ResponseHapushData> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
}
