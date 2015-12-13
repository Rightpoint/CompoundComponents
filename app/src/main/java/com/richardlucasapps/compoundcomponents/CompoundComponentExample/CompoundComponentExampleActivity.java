package com.richardlucasapps.compoundcomponents.CompoundComponentExample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.richardlucasapps.compoundcomponents.ContactInfo;
import com.richardlucasapps.compoundcomponents.ContactInfoView;
import com.richardlucasapps.compoundcomponents.FragmentExample.FragmentExampleActivity;
import com.richardlucasapps.compoundcomponents.InlcudeLayoutExample.IncludeLayoutActivity;
import com.richardlucasapps.compoundcomponents.R;

public class CompoundComponentExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_component_example);
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

        ContactInfo contactInfo = new ContactInfo(
                R.drawable.mike, "Michael", "LeBarron", "2813308004", "Mike@LeBarron.com",
                "50 Milk St.", "Boston", "MA", "02109");

        ContactInfoView contactInfoView = (ContactInfoView) findViewById(R.id.contact_info_view);
        contactInfoView.load(contactInfo);

        findViewById(R.id.button_launch_include_layout_example).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), IncludeLayoutActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.button_launch_fragment_layout_example).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FragmentExampleActivity.class);
                startActivity(intent);
            }
        });
    }
}
