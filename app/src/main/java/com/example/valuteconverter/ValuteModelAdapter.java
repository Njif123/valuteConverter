package com.example.valuteconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ValuteModelAdapter extends RecyclerView.Adapter<ValuteModelAdapter.ViewHolder>{

    private List<ValuteModel> valuteModelList;
    private Context context;

    public ValuteModelAdapter(List<ValuteModel> valuteModelList, Context context) {
        this.valuteModelList = valuteModelList;
        this.context = context;
    }


    @Override
    public ValuteModelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.valute_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ValuteModelAdapter.ViewHolder holder, int position) {
        ValuteModel valuteModel = valuteModelList.get(position);
        holder.charCode.setText(valuteModel.getCharCode());
        holder.unit.setText(valuteModel.getNominal());
        holder.course.setText(valuteModel.getValue()+"");
        holder.prevCourse.setText(valuteModel.getPreviousValue()+"");
    }

    @Override
    public int getItemCount() {
        return valuteModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView charCode, unit, course, prevCourse;
        public ViewHolder( View itemView) {
            super(itemView);
            charCode = itemView.findViewById(R.id.charCode_item);
            unit = itemView.findViewById(R.id.edin_item);
            course = itemView.findViewById(R.id.course_item);
            prevCourse = itemView.findViewById(R.id.prevCourse_item);
        }
    }
    public void setData(List<ValuteModel> valuteModelList) {
        this.valuteModelList = valuteModelList;
        notifyDataSetChanged();
    }
}
