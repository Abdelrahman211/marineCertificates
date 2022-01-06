package com.example.marinecertificates.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marinecertificates.models.CardItem;
import com.example.marinecertificates.fragments.CorFragment;
import com.example.marinecertificates.fragments.CrtFragment;
import com.example.marinecertificates.MarineCertificatesApp;
import com.example.marinecertificates.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DetailsActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    CardItem selectedItem;
    private TextView dateText;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detais);
        dateText = findViewById(R.id.date_text);
        getSelectedItem();
        setValues();
        btnAdd = findViewById(R.id.btn_add) ;
        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
              showDatePickerDialog();
            }
        });
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
        String parsedStringID = previousIntent.getStringExtra("id");
        String fromFrag = previousIntent. getStringExtra("from");
        if (fromFrag .equals("crt"))
            selectedItem = CrtFragment.CrtList.get(Integer.valueOf(parsedStringID));
        else
            selectedItem = CorFragment.CorList.get(Integer.valueOf(parsedStringID));
    }

    private void setValues()
    {
        TextView tv = (TextView) findViewById(R.id.tv_details);
        ImageView iv = (ImageView) findViewById(R.id.iv_details);
        TextView tvDescription = (TextView) findViewById(R.id.tv_descrip_derails);


        tv.setText(selectedItem.getName());
        iv.setImageResource(selectedItem.getImage());
        tvDescription.setText(selectedItem.getDescription());


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar myCalendar = new GregorianCalendar(year, month, dayOfMonth);
        Date myDate = myCalendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = "Issuing Date is : "  + dateFormat.format(myDate);
        dateText.setText(date);



        CardItem item = new CardItem( selectedItem.getId(),selectedItem.getName(),selectedItem.getImage(),selectedItem.getYearPeriod(),selectedItem.getItemType(),selectedItem.getDescription());
        item.setDate(myDate);
        item.setAddedDate(  Calendar.getInstance().getTime());
        ((MarineCertificatesApp) getApplication()).myProfileList.addItem(item);

        ((MarineCertificatesApp) getApplication()).saveData();
        onBackPressed();
        Toast.makeText(getApplicationContext(),"Your certificate has been added to your profile", Toast.LENGTH_LONG).show();


    }
}

