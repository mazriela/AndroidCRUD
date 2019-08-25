package udacoding.com.androidjavacrud.tampildata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import udacoding.com.androidjavacrud.R;
import udacoding.com.androidjavacrud.detaildata.DetailDataActivity;
import udacoding.com.androidjavacrud.network.NetworkClient;
import udacoding.com.androidjavacrud.tambahdata.AddDataUserActivity;
import udacoding.com.androidjavacrud.tampildata.adapter.AdapterTampilData;
import udacoding.com.androidjavacrud.tampildata.model.DataItemTampiUser;
import udacoding.com.androidjavacrud.tampildata.model.ResponseTampilData;

public class ShowDataUserActivity extends AppCompatActivity {


    @BindView(R.id.btnNavigateToTambahData)
    Button btnNavigateToTambahData;
    @BindView(R.id.rvListDataUser)
    RecyclerView rvListDataUser;

    public List<DataItemTampiUser> dataItemList;
    AdapterTampilData adapterTampilData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data_user);
        ButterKnife.bind(this);
        dataItemList = new ArrayList<>();

        getListDataUser();
    }

    private void getListDataUser() {
        NetworkClient.service.tampil_user().enqueue(new Callback<ResponseTampilData>() {
            @Override
            public void onResponse(Call<ResponseTampilData> call, Response<ResponseTampilData> response) {
                if (response.isSuccessful()) {
                    String message = response.body().getMessage();
                    Boolean status = response.body().isStatus();

                    if(status){
                        dataItemList = response.body().getData();
                        rvListDataUser.setLayoutManager(new LinearLayoutManager(ShowDataUserActivity.this, LinearLayoutManager.VERTICAL, false));
                        adapterTampilData = new AdapterTampilData(ShowDataUserActivity.this, dataItemList, new AdapterTampilData.onItemClick() {
                            @Override
                            public void item(DataItemTampiUser data) {
                                Intent intent = new Intent(getApplicationContext(), DetailDataActivity.class);
                                intent.putExtra("data_user", data);
                                startActivity(intent);
                            }
                        });
                        rvListDataUser.setAdapter(adapterTampilData);
                    } else {
                        Toast.makeText(ShowDataUserActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                    }

            }

            @Override
            public void onFailure(Call<ResponseTampilData> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.btnNavigateToTambahData)
    public void onViewClicked() {
        moveToAddAddData();
    }

    private void moveToAddAddData() {
        startActivity(new Intent(ShowDataUserActivity.this, AddDataUserActivity.class));
    }
}
