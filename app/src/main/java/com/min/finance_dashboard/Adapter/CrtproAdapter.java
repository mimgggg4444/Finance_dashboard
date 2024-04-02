package com.min.finance_dashboard.Adapter;

import android.graphics.Color;
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
        holder.nameTxt.setText(dataList.get(position).getName());
        holder.priceTxt.setText("$" + formatter.format(dataList.get(position).getPrice()));
        holder.changePersentTxt.setText(dataList.get(position).getChangePercent() + "%");
        holder.propertySizeTxt.setText(dataList.get(position).getPropertySize() + dataList.get(position).getSymbol());
        holder.propertyAmountTxt.setText("$" + formatter.format(dataList.get(position).getPropertyAmount()));
        holder.lineChart.setData(dataList.get(position).getLineData());

        if (dataList.get(position).getChangePercent() > 0) {
            holder.changePersentTxt.setTextColor(Color.parseColor("#12c737"));
            holder.lineChart.setSparkLineColor(Color.parseColor("#12737"));
        } else if (dataList.get(position).getChangePercent() < 0) {

        } else {

        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView nameTxt, priceTxt, changePersentTxt, propertySizeTxt, propertyAmountTxt;
        ImageView logo;
        SparkLineLayout lineChart;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.cryptoNameTxt);
            priceTxt = itemView.findViewById(R.id.cryptoPriceTxt);
            changePersentTxt = itemView.findViewById(R.id.changePriceTxt);
            propertySizeTxt = itemView.findViewById(R.id.propertySizeTxt);
            propertyAmountTxt = itemView.findViewById(R.id.propertyAmountTxt);
            logo = itemView.findViewById(R.id.logoImg);
            lineChart = itemView.findViewById(R.id.sparkLineLayout);
        }
    }
}
