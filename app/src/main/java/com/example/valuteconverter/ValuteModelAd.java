package com.example.valuteconverter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ValuteModelAd extends RecyclerView.Adapter<ValuteModelAd.ViewHolder> {

    List<ValuteModel> valuteModelList;


    public ValuteModelAd(List<ValuteModel> valuteModelList) {
        this.valuteModelList = valuteModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.valute_list_item,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ValuteModel model = valuteModelList.get(position);
        TextView charCode, edin, cource, prevVal;
        charCode = holder.itemView.findViewById(R.id.tv_charCode);
        edin = holder.itemView.findViewById(R.id.tv_nominal);
        cource = holder.itemView.findViewById(R.id.tv_value);
        prevVal = holder.itemView.findViewById(R.id.tv_prevvalue);

        charCode.setText(model.getCharCode());
        edin.setText(String.format("%d", model.getNominal()));
        cource.setText(String.format("%s", model.getValue()));
        prevVal.setText(String.format("%s", model.getPreviousValue()));

        charCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConvertActivity.class);
                intent.putExtra("CHAR_CODE", model.getCharCode());
                intent.putExtra("EDIN",model.getNominal());
                intent.putExtra("COURSE", model.getValue());
                v.getContext().startActivity(intent);
            }
        });

        edin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConvertActivity.class);
                intent.putExtra("CHAR_CODE", model.getCharCode());
                intent.putExtra("EDIN",model.getNominal());
                intent.putExtra("COURSE", model.getValue());
                v.getContext().startActivity(intent);
            }
        });

        cource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConvertActivity.class);
                intent.putExtra("CHAR_CODE", model.getCharCode());
                intent.putExtra("EDIN",model.getNominal());
                intent.putExtra("COURSE", model.getValue());
                v.getContext().startActivity(intent);
            }
        });

        prevVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConvertActivity.class);
                intent.putExtra("CHAR_CODE", model.getCharCode());
                intent.putExtra("EDIN",model.getNominal());
                intent.putExtra("COURSE", model.getValue());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return valuteModelList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



}
