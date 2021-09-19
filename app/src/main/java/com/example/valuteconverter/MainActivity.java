package com.example.valuteconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<ValuteModel> valuteModelList;
    private ImageView btnRefresh;
    private ValuteModelAd valuteModelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRefresh = findViewById(R.id.btn_refresh);
        valuteModelList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.rv_valuteList);
        valuteModelAdapter = new ValuteModelAd(valuteModelList);
        recyclerView.setAdapter(valuteModelAdapter);
        setValuteList();

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValuteList();
            }
        });

    }
    private void setValuteList(){

        valuteModelList.clear();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.cbr-xml-daily.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonValute jsonValute = retrofit.create(JsonValute.class);

        Call<Example> call = jsonValute.getExample();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (!response.isSuccessful()) {
                    String code = response.code() + "";
                    Toast.makeText(getApplicationContext(),code, Toast.LENGTH_SHORT).show();
                    return;
                }
                valuteModelList.add(new ValuteModel(response.body().getValute().getAmd().getCharCode(),
                        response.body().getValute().getAmd().getNominal(),
                        response.body().getValute().getAmd().getValue(),
                        response.body().getValute().getAmd().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getAud().getCharCode(),
                        response.body().getValute().getAud().getNominal(),
                        response.body().getValute().getAud().getValue(),
                        response.body().getValute().getAud().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getAzn().getCharCode(),
                        response.body().getValute().getAzn().getNominal(),
                        response.body().getValute().getAzn().getValue(),
                        response.body().getValute().getAzn().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getBgn().getCharCode(),
                        response.body().getValute().getBgn().getNominal(),
                        response.body().getValute().getBgn().getValue(),
                        response.body().getValute().getBgn().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getBrl().getCharCode(),
                        response.body().getValute().getBrl().getNominal(),
                        response.body().getValute().getBrl().getValue(),
                        response.body().getValute().getBrl().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getByn().getCharCode(),
                        response.body().getValute().getByn().getNominal(),
                        response.body().getValute().getByn().getValue(),
                        response.body().getValute().getByn().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getCad().getCharCode(),
                        response.body().getValute().getCad().getNominal(),
                        response.body().getValute().getCad().getValue(),
                        response.body().getValute().getCad().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getChf().getCharCode(),
                        response.body().getValute().getChf().getNominal(),
                        response.body().getValute().getChf().getValue(),
                        response.body().getValute().getChf().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getCny().getCharCode(),
                        response.body().getValute().getCny().getNominal(),
                        response.body().getValute().getCny().getValue(),
                        response.body().getValute().getCny().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getCzk().getCharCode(),
                        response.body().getValute().getCzk().getNominal(),
                        response.body().getValute().getCzk().getValue(),
                        response.body().getValute().getCzk().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getDkk().getCharCode(),
                        response.body().getValute().getDkk().getNominal(),
                        response.body().getValute().getDkk().getValue(),
                        response.body().getValute().getDkk().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getEur().getCharCode(),
                        response.body().getValute().getEur().getNominal(),
                        response.body().getValute().getEur().getValue(),
                        response.body().getValute().getEur().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getGbp().getCharCode(),
                        response.body().getValute().getGbp().getNominal(),
                        response.body().getValute().getGbp().getValue(),
                        response.body().getValute().getGbp().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getHkd().getCharCode(),
                        response.body().getValute().getHkd().getNominal(),
                        response.body().getValute().getHkd().getValue(),
                        response.body().getValute().getHkd().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getHuf().getCharCode(),
                        response.body().getValute().getHuf().getNominal(),
                        response.body().getValute().getHuf().getValue(),
                        response.body().getValute().getHuf().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getInr().getCharCode(),
                        response.body().getValute().getInr().getNominal(),
                        response.body().getValute().getInr().getValue(),
                        response.body().getValute().getInr().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getJpy().getCharCode(),
                        response.body().getValute().getJpy().getNominal(),
                        response.body().getValute().getJpy().getValue(),
                        response.body().getValute().getJpy().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getKgs().getCharCode(),
                        response.body().getValute().getKgs().getNominal(),
                        response.body().getValute().getKgs().getValue(),
                        response.body().getValute().getKgs().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getKrw().getCharCode(),
                        response.body().getValute().getKrw().getNominal(),
                        response.body().getValute().getKrw().getValue(),
                        response.body().getValute().getKrw().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getKzt().getCharCode(),
                        response.body().getValute().getKzt().getNominal(),
                        response.body().getValute().getKzt().getValue(),
                        response.body().getValute().getKzt().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getMdl().getCharCode(),
                        response.body().getValute().getMdl().getNominal(),
                        response.body().getValute().getMdl().getValue(),
                        response.body().getValute().getMdl().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getNok().getCharCode(),
                        response.body().getValute().getNok().getNominal(),
                        response.body().getValute().getNok().getValue(),
                        response.body().getValute().getNok().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getPln().getCharCode(),
                        response.body().getValute().getPln().getNominal(),
                        response.body().getValute().getPln().getValue(),
                        response.body().getValute().getPln().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getRon().getCharCode(),
                        response.body().getValute().getRon().getNominal(),
                        response.body().getValute().getRon().getValue(),
                        response.body().getValute().getRon().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getSek().getCharCode(),
                        response.body().getValute().getSek().getNominal(),
                        response.body().getValute().getSek().getValue(),
                        response.body().getValute().getSek().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getSgd().getCharCode(),
                        response.body().getValute().getSgd().getNominal(),
                        response.body().getValute().getSgd().getValue(),
                        response.body().getValute().getSgd().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getTjs().getCharCode(),
                        response.body().getValute().getTjs().getNominal(),
                        response.body().getValute().getTjs().getValue(),
                        response.body().getValute().getTjs().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getTmt().getCharCode(),
                        response.body().getValute().getTmt().getNominal(),
                        response.body().getValute().getTmt().getValue(),
                        response.body().getValute().getTmt().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getTry().getCharCode(),
                        response.body().getValute().getTry().getNominal(),
                        response.body().getValute().getTry().getValue(),
                        response.body().getValute().getTry().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getUah().getCharCode(),
                        response.body().getValute().getUah().getNominal(),
                        response.body().getValute().getUah().getValue(),
                        response.body().getValute().getUah().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getUsd().getCharCode(),
                        response.body().getValute().getUsd().getNominal(),
                        response.body().getValute().getUsd().getValue(),
                        response.body().getValute().getUsd().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getUzs().getCharCode(),
                        response.body().getValute().getUzs().getNominal(),
                        response.body().getValute().getUzs().getValue(),
                        response.body().getValute().getUzs().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getXdr().getCharCode(),
                        response.body().getValute().getXdr().getNominal(),
                        response.body().getValute().getXdr().getValue(),
                        response.body().getValute().getXdr().getPrevious()));
                valuteModelList.add(new ValuteModel(response.body().getValute().getZar().getCharCode(),
                        response.body().getValute().getZar().getNominal(),
                        response.body().getValute().getZar().getValue(),
                        response.body().getValute().getZar().getPrevious()));

                valuteModelAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT);
            }
        });
    }
}



