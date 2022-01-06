package com.example.marinecertificates.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marinecertificates.models.CardItem;
import com.example.marinecertificates.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CardItemAdapter extends ArrayAdapter<CardItem> {

    boolean m_inProfile;
    TextView tv ;
    ImageView iv;
    TextView dateView;
    TextView validTV;
    ImageView iconIV;
    TextView tvType;
    TextView tvDescription;

    public CardItemAdapter(Context context, int resource, List<CardItem> CrtList,boolean inProfile)
    {
        super(context, resource, CrtList);
        m_inProfile = inProfile;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        CardItem cardItem = getItem(position);


        if(m_inProfile){
            if (convertView == null)
            {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.profile_card, parent, false);
            }
            tv = (TextView) convertView.findViewById(R.id.tv_profile);
            iv = (ImageView) convertView.findViewById(R.id.iv_profile);
            dateView = (TextView) convertView.findViewById(R.id.tv_profile_date);
            validTV = (TextView) convertView.findViewById(R.id.tv_profile_status);
            iconIV = (ImageView) convertView.findViewById(R.id.iv_icon);
            tvType = (TextView) convertView.findViewById(R.id.tv_profile_type);


            tvType.setText(cardItem.getItemType());

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            dateView.setText(dateFormat.format(cardItem.getDate()));

            Date currDate = Calendar.getInstance().getTime();
            Calendar cal = Calendar.getInstance();
            cal.setTime(cardItem.getDate());
            cal.add(Calendar.YEAR,cardItem.getYearPeriod());



            if(currDate.after(cal.getTime())){
                validTV.setText("Expired");
                validTV.setTextColor(Color.parseColor("#F34235"));
                iconIV.setImageResource(R.drawable.expierd);

            }
            else {
                validTV.setText("valid");
                validTV.setTextColor(Color.parseColor("#4BAE4E"));
                iconIV.setImageResource(R.drawable.correct);
            }

        }
        else{
            if (convertView == null)
            {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, parent, false);
            }
            tv = (TextView) convertView.findViewById(R.id.tv_title_card);
            iv = (ImageView) convertView.findViewById(R.id.iv_card);
            tvDescription = (TextView) convertView.findViewById(R.id.tv_descrip_card);
            tvDescription.setText(cardItem.getDescription());


        }


        tv.setText(cardItem.getName());
        iv.setImageResource(cardItem.getImage());



        return convertView;
    }
}