package udacoding.com.androidjavacrud.tampildata.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import udacoding.com.androidjavacrud.R;
import udacoding.com.androidjavacrud.tampildata.model.DataItemTampiUser;

public class AdapterTampilData extends RecyclerView.Adapter<AdapterTampilData.ViewHolder> {
    Context context;
    List<DataItemTampiUser> dataItemList;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(itemView);
    }

    //Constructor
    public AdapterTampilData(Context context, List<DataItemTampiUser> dataItem) {
        this.context = context;
        this.dataItemList = dataItem;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final  DataItemTampiUser dataItemTampiUser = dataItemList.get(position);

        viewHolder.tvNamaUser.setText(dataItemTampiUser.getNamaUser());
        viewHolder.tvEmailUser.setText(dataItemTampiUser.getEmailUser());




    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvEmailUser)
        TextView tvEmailUser;
        @BindView(R.id.tvNamaUser)
        TextView tvNamaUser;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);


        }
    }
}
