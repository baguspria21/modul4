package com.example.modul4;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidht, edtHeight, edtLenght;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidht = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLenght = findViewById(R.id.edt_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }
        @Override
        public void onClick(@NonNull View v) {
            if (v.getId() == R.id.btn_calculate) {
                String inputLength = edtLenght.getText().toString().trim();
                String inputWidth = edtWidht.getText().toString().trim();
                String inputHeight = edtHeight.getText().toString().trim();
                boolean isEmptyFields = false;
                if (TextUtils.isEmpty(inputLength)) {
                    isEmptyFields = true;
                    edtLenght.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(inputWidth)) {
                    isEmptyFields = true;
                    edtWidht.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(inputHeight)) {
                    isEmptyFields = true;
                    edtHeight.setError("Field ini tidak boleh kosong");
                }
                if (!isEmptyFields) {
                    double volume = Double.parseDouble(inputLength) * Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
                    tvResult.setText(String.valueOf(volume));
                }
            }
        }
}