package com.example.a15031759.p02_holidays;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by 15031759 on 28/4/2017.
 */

public class SecondActivity extends AppCompatActivity{

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday> allHoliday;
    ArrayList<Holiday> holiday;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        lv = (ListView) this.findViewById(R.id.lvHoliday);
        tvTitle = (TextView)findViewById(R.id.textViewTitle);

        holiday = new ArrayList<Holiday>();

        allHoliday = new ArrayList<Holiday>();
        allHoliday.add(new Holiday("Secular","New Year's Day", R.drawable.newyear,"1 Jan 2017", "New Year's Day falls on January 1 and marks the start of a new year according to the Gregorian calendar. It marks the end of New Year's Eve celebrations in the United States and gives many Americans a chance to remember the previous year."));
        allHoliday.add(new Holiday("Secular","Labour Day",R.drawable.labourday, "1 May 2017" , "a public holiday or day of festivities held in honour of working people, in many countries on 1 May, in the US and Canada on the first Monday in September."));
        allHoliday.add(new Holiday("Secular","National Day",R.drawable.nationalday, "9 August 2017" , "The National Day of Singapore is celebrated every year on August 9, in commemoration of the Singapore's independence from Malaysia in the year 1965. This holiday features a National Day Parade, an address by the Prime Minister of Singapore, and fireworks celebrations."));
        allHoliday.add(new Holiday("Secular","Christmas Day",R.drawable.christmas, "25 December 2017" , "Christmas or Christmas Day is an annual festival commemorating the birth of Jesus Christ, observed most commonly on December 25 as a religious and cultural celebration among billions of people around the world."));

        allHoliday.add(new Holiday("Ethnic & Religion","Chinese New Year",R.drawable.cny, "28 January 2017, 29 January 2017" , "the Chinese festival marking the start of the new year, beginning on the second new moon after the winter solstice and ending on the full moon fifteen days later. It is marked by visits to family and friends, special meals, fireworks, and gift giving."));
        allHoliday.add(new Holiday("Ethnic & Religion","Good Friday",R.drawable.goodfriday, "14 April 2017","the Friday before Easter Sunday, on which the Crucifixion of Christ is commemorated in the Christian Church. It is traditionally a day of fasting and penance."));
        allHoliday.add(new Holiday("Ethnic & Religion","Vesak Day",R.drawable.vesakday, "10 May 2017","Vesak Day is celebrated by Buddhists in Singapore and around the world to mark the birth, enlightenment and death of Buddha."));
        allHoliday.add(new Holiday("Ethnic & Religion","Hari Raya Puasa",R.drawable.harirayapuasa, "25 June 2017","Marking the end of the Islamic holy month of Ramadan is the festival of Eid, known in Singapore as Hari Raya Aidilfitri or Hari Raya Puasa. Ramadan is a period of sober repentance for Muslims, with approximately 30 days of dawn-to-dusk fasting."));
        allHoliday.add(new Holiday("Ethnic & Religion","Hari Raya Haji",R.drawable.harirayahaji, "1 September 2017","Muslims in Singapore remember their faith with prayer and reflection during Hari Raya Haji, also known as the Festival of Sacrifice"));
        allHoliday.add(new Holiday("Ethnic & Religion","Deepavali",R.drawable.deepavali, "18 October 2017","Diwali or Deepavali is the Hindu festival of lights celebrated every year in autumn in the northern hemisphere."));

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        tvTitle.setText(type.toString());



        for(int i = 0; i<allHoliday.size(); i++){
            if(allHoliday.get(i).getType().equalsIgnoreCase(type)){
                holiday.add(allHoliday.get(i));
            }
        }

        aa = new HolidayAdapter(this, R.layout.holiday_row, holiday);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = holiday.get(position);

                Toast.makeText(SecondActivity.this, selectedHoliday.getHoliday() +" Date: "+ selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();

                AlertDialog.Builder helpBuilder = new AlertDialog.Builder(SecondActivity.this);
                helpBuilder.setTitle("Infomation");
                helpBuilder.setMessage(selectedHoliday.getInfo());
                helpBuilder.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });

                AlertDialog helpDialog = helpBuilder.create();
                helpDialog.show();
            }
        });

    }
}
