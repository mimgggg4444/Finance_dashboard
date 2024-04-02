package com.min.finance_dashboard.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.majorik.sparklinelibrary.SparkLineLayout;
import com.min.finance_dashboard.Domain.domain;
import com.min.finance_dashboard.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CrtproAdapter extends RecyclerView.Adapter<CrtproAdapter.Viewholder> {

    ArrayList<domain> dataList;
    DecimalFormat formatter;

    public CrtproAdapter(ArrayList<domain> dataList) {
        this.dataList = dataList;
        formatter = new DecimalFormat("###,###,###,###,##");
    }

    @NonNull
    @Override
    public CrtproAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_crypto, parent, false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CrtproAdapter.Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView nameTxt,priceTxt,changePersentTxt,propertySizeTxt,propertyAmountTxt;
        ImageView logo;

        SparkLineLayout lineChart;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            nameTxt=itemView.findViewById(R.id.cryptoNameTxt);
            priceTxt=itemView.findViewById(R.id.cryptoPriceTxt);
            changePersentTxt=itemView.findViewById(R.id.changePriceTxt);
            propertySizeTxt=itemView.findViewById(R.id.propertySizeTxt);
            propertyAmountTxt=itemView.findViewById(R.id.propertyAmountTxt);
            logo=itemView.findViewById(R.id.logoImg);
        }
    }
}
