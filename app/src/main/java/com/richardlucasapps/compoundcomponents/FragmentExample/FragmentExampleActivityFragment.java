package com.richardlucasapps.compoundcomponents.FragmentExample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.richardlucasapps.compoundcomponents.ContactInfo;
import com.richardlucasapps.compoundcomponents.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentExampleActivityFragment extends Fragment {

    public FragmentExampleActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.view_contact_info_layout, container, false);

        //Create ContactInfo object
        ContactInfo contactInfo = new ContactInfo(
                R.drawable.mike, "Michael", "LeBarron", "2813308004", "Mike@LeBarron.com",
                "50 Milk St.", "Boston", "MA", "02109");

        //Get Views
        ImageView picture = (ImageView) rootView.findViewById(R.id.picture);
        TextView firstName = (TextView) rootView.findViewById(R.id.first_name);
        TextView lastName = (TextView) rootView.findViewById(R.id.last_name);
        TextView phoneNumber = (TextView) rootView.findViewById(R.id.phone_number);
        TextView emailAddress = (TextView) rootView.findViewById(R.id.email_address);
        TextView homeAddress = (TextView) rootView.findViewById(R.id.home_address);
        TextView cityStateZip = (TextView) rootView.findViewById(R.id.city_state_zip);

        //Populate Views
        picture.setImageResource(contactInfo.getPicture());
        firstName.setText(contactInfo.getFirstName());
        lastName.setText(contactInfo.getLastName());

        String phoneNumberString = contactInfo.getPhoneNumber();
        String phoneNumberFormatted = getString(R.string.phone_number, phoneNumberString.substring(0,3), phoneNumberString.substring(3,6), phoneNumberString.substring(6,10));
        phoneNumber.setText(phoneNumberFormatted);

        emailAddress.setText(contactInfo.getEmailAddress());
        homeAddress.setText(contactInfo.getHomeAddress());

        String cityStateZipFormatted = getString(R.string.city_state_zip, contactInfo.getHomeCity(), contactInfo.getHomeState(), contactInfo.getHomeZipCode());
        cityStateZip.setText(cityStateZipFormatted);

        return rootView;
    }
}
