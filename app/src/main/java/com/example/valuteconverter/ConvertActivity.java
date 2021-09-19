package com.example.valuteconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity {
    TextView desc, charCode, result;
    EditText etValue;
    Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        desc = findViewById(R.id.tv_desc);
        charCode = findViewById(R.id.valute_charCode);
        result = findViewById(R.id.tv_result);
        etValue = findViewById(R.id.et_value);
        btnConvert = findViewById(R.id.btn_convert);

        Intent intent = getIntent();
        String charCod = intent.getStringExtra("CHAR_CODE");
        int edin = intent.getIntExtra("EDIN",1);
        double course = intent.getDoubleExtra("COURSE",1);

        desc.setText("Конвертация "+charCod+" в RUB");
        charCode.setText(charCod);
        result.setText(String.format("%.2f",course));

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double courseForOneRub = course/edin;
                String userInput = etValue.getText().toString();
                double userInputValue = Double.parseDouble(userInput);
                double resultt = userInputValue * courseForOneRub;
                result.setText(String.format("%.2f",resultt));
            }
        });
        etValue.addTextChangedListener(new TextWatcher(){
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (s.toString().matches("^0") ) {
                    etValue.setText("");
                    etValue.setError("Число не может начинаться с 0");
                }

            }
            @Override
            public void afterTextChanged(Editable arg0) { }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        });
    }
}