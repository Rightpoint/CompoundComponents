package com.richardlucasapps.compoundcomponents.InlcudeLayoutExample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.richardlucasapps.compoundcomponents.ContactInfo;
import com.richardlucasapps.compoundcomponents.R;

public class IncludeLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_include_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Create ContactInfo object
        ContactInfo contactInfo = new ContactInfo(
                R.drawable.mike, "Michael", "LeBarron", "2813308004", "Mike@LeBarron.com",
                "50 Milk St.", "Boston", "MA", "02109");

        //Find Views
        ImageView picture = (ImageView) findViewById(R.id.picture);
        TextView firstName = (TextView) findViewById(R.id.first_name);
        //region Find the other Views
        TextView lastName = (TextView) findViewById(R.id.last_name);
        TextView phoneNumber = (TextView) findViewById(R.id.phone_number);
        TextView emailAddress = (TextView) findViewById(R.id.email_address);
        TextView homeAddress = (TextView) findViewById(R.id.home_address);
        TextView cityStateZip = (TextView) findViewById(R.id.city_state_zip);
        //endregion

        //Populate Views
        picture.setImageResource(contactInfo.getPicture());
        firstName.setText(contactInfo.getFirstName());
        //region Populate the other views
        lastName.setText(contactInfo.getLastName());

        String phoneNumberString = contactInfo.getPhoneNumber();
        String phoneNumberFormatted = getString(R.string.phone_number, phoneNumberString.substring(0,3), phoneNumberString.substring(3,6), phoneNumberString.substring(6,10));
        phoneNumber.setText(phoneNumberFormatted);

        emailAddress.setText(contactInfo.getEmailAddress());
        homeAddress.setText(contactInfo.getHomeAddress());

        String cityStateZipFormatted = getString(R.string.city_state_zip, contactInfo.getHomeCity(), contactInfo.getHomeState(), contactInfo.getHomeZipCode());
        cityStateZip.setText(cityStateZipFormatted);
        //endregion
    }

}
