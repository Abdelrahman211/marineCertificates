package com.example.marinecertificates.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.marinecertificates.MarineCertificatesApp;
import com.example.marinecertificates.R;
import com.example.marinecertificates.fragments.CorFragment;
import com.example.marinecertificates.fragments.CrtFragment;
import com.example.marinecertificates.models.CardItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DetailsProfileActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {




    Button deleteBtn;
    Button modifyBtn;
    CardItem selectedItem;
    String  parsedIntID;
    TextView dateTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_profile);
        deleteBtn = findViewById(R.id.btn_delete);
        modifyBtn = findViewById(R.id.btn_modify);
        dateTV = findViewById(R.id.date_profile_text);
        getSelectedItem();
        updateViews();

        modifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MarineCertificatesApp) getApplication()).myProfileList.removeItem(selectedItem.getId());
                ((MarineCertificatesApp) getApplication()).saveData();
                onBackPressed();
            }
        });
    }

    void updateViews(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        dateTV.setText(dateFormat.format(selectedItem.getDate()));

    }

    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }
    private void getSelectedItem()
    {
        Intent previousIntent = getIntent();
        parsedIntID = previousIntent.getStringExtra("id");

        selectedItem = ((MarineCertificatesApp) getApplication()).myProfileList.getItemById(parsedIntID);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar myCalendar = new GregorianCalendar(year, month, dayOfMonth);
        Date myDate = myCalendar.getTime();
         selectedItem.setDate(myDate);
        ((MarineCertificatesApp) getApplication()).saveData();
        updateViews();

    }
}