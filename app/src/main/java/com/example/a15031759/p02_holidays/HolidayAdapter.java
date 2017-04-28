package com.example.a15031759.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by 15031759 on 28/4/2017.
 */

public class HolidayAdapter extends ArrayAdapter<Holiday> {
    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvHoliday;
    private TextView tvDate;
    private ImageView ivHoliday;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.holiday_row, parent, false);

        tvHoliday = (TextView) rowView.findViewById(R.id.tvHoliday);
        ivHoliday = (ImageView) rowView.findViewById(R.id.ivHoliday);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);


        Holiday currentHoliday = holiday.get(position);

        tvHoliday.setText(currentHoliday.getHoliday());
        tvDate.setText(currentHoliday.getDate());
        ivHoliday.setImageResource(currentHoliday.getResourceID());

        //currentHoliday.getHoliday() +"Date: "+ currentHoliday.getDate()

        return rowView;
    }
}
