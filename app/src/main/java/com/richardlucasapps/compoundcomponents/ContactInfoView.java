package com.richardlucasapps.compoundcomponents;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactInfoView extends LinearLayout {

    private ImageView picture;
    private TextView firstName;
    private TextView lastName;
    private TextView phoneNumber;
    private TextView emailAddress;
    private TextView homeAddress;
    private TextView cityStateZip;

    public ContactInfoView(Context context) {
        super(context);
        init();
    }

    public ContactInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ContactInfoView);
        readArray(arr);
        arr.recycle();
    }

    public ContactInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ContactInfoView);
        readArray(arr);
        arr.recycle();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ContactInfoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ContactInfoView);
        readArray(arr);
        arr.recycle();
    }

    private void init() {
        setOrientation(VERTICAL);

        LayoutInflater.from(getContext()).inflate(R.layout.view_contact_info, this);

        picture = (ImageView) findViewById(R.id.picture);
        firstName = (TextView) findViewById(R.id.first_name);
        lastName = (TextView) findViewById(R.id.last_name);
        phoneNumber = (TextView) findViewById(R.id.phone_number);
        emailAddress = (TextView) findViewById(R.id.email_address);
        homeAddress = (TextView) findViewById(R.id.home_address);
        cityStateZip = (TextView) findViewById(R.id.city_state_zip);
    }

    private void readArray(TypedArray arr) {
        boolean nameBold = arr.getBoolean(R.styleable.ContactInfoView_nameBold, false);
        boolean hidePicture = arr.getBoolean(R.styleable.ContactInfoView_hidePicture, false);

        if (nameBold) {
            firstName.setTypeface(firstName.getTypeface(), Typeface.BOLD);
            lastName.setTypeface(lastName.getTypeface(), Typeface.BOLD);
        }
        if (hidePicture) {
            picture.setVisibility(View.GONE);
        }
    }

    public void load(ContactInfo contactInfo) {
        Context context = getContext();
        picture.setImageResource(contactInfo.getPicture());
        firstName.setText(contactInfo.getFirstName());
        lastName.setText(contactInfo.getLastName());

        String phoneNumberString = contactInfo.getPhoneNumber();
        String phoneNumberFormatted = getContext().getString(R.string.phone_number, phoneNumberString.substring(0, 3), phoneNumberString.substring(3, 6), phoneNumberString.substring(6, 10));
        phoneNumber.setText(phoneNumberFormatted);

        emailAddress.setText(contactInfo.getEmailAddress());
        homeAddress.setText(contactInfo.getHomeAddress());

        String cityStateZipFormatted = context.getString(R.string.city_state_zip, contactInfo.getHomeCity(), contactInfo.getHomeState(), contactInfo.getHomeZipCode());
        cityStateZip.setText(cityStateZipFormatted);
    }

}
