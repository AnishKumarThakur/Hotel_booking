package com.e.hotel_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
 TextView tvciDate, tvcoDate, tvResult;
 Spinner spnrRoomtype;
 EditText etAdult, etChildren, etRoom;
 Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvciDate = findViewById(R.id.tvciDate);
        tvcoDate = findViewById(R.id.tvcoDate);
        tvResult = findViewById(R.id.tvResult);
        spnrRoomtype = findViewById(R.id.spnrRoomtype);
        etAdult = findViewById(R.id.etAdult);
        etChildren = findViewById(R.id.etChildren);
        etRoom = findViewById(R.id.etRoom);
        btnCalculate = findViewById(R.id.btnCalculate);

        final String rooms[] = {"- - Select Room Types - -", "Delux - Rs. 2000", "Presenditial - Rs. 5000", "Premium - Rs. 4000"};
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
               android.R.layout.simple_list_item_1,
                rooms
        );
        spnrRoomtype.setAdapter(adapter);


        tvciDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadtvciData();
            }
        });
        tvcoDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadtvcoData();
            }
        });


    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "Check in Date: \n" + (month + 1) + "/" + dayOfMonth + "/" + year;
        tvciDate.setText(date);
    }

    private void loadtvciData() {
        final java.util.Calendar c = java.util.Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this, year, month, day);
        datePickerDialog.show();
    }


    // For Checkout Date
    private void loadtvcoData() {
        final java.util.Calendar c = java.util.Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "Check in Date: \n" + (month + 1) + "/" + dayOfMonth + "/" + year;
                tvcoDate.setText(date);
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}

