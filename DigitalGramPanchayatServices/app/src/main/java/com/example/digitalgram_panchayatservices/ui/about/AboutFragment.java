package com.example.digitalgram_panchayatservices.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digitalgram_panchayatservices.R;


public class AboutFragment extends Fragment {
    private TextView y1,y2,y3,y4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        y1 = view.findViewById(R.id.y1);
        y2 = view.findViewById(R.id.y2);
        y3 = view.findViewById(R.id.y3);
        y4 = view.findViewById(R.id.y4);


        y1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://byjus.com/free-ias-prep/national-rural-drinking-water-programme/");
            }
        });

        y2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.magicbricks.com/blog/hi/pmay-pradhan-mantri-awas-yojana/114376.html");
            }
        });

        y3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.xn--i1bj3fqcyde.xn--11b7cb3a6a.xn--h2brj9c/spotlight/%E0%A4%A6%E0%A5%80%E0%A4%A8-%E0%A4%A6%E0%A4%AF%E0%A4%BE%E0%A4%B2-%E0%A4%89%E0%A4%AA%E0%A4%BE%E0%A4%A7%E0%A5%8D%E0%A4%AF%E0%A4%BE%E0%A4%AF-%E0%A4%97%E0%A5%8D%E0%A4%B0%E0%A4%BE%E0%A4%AE%E0%A5%80%E0%A4%A3-%E0%A4%95%E0%A5%8C%E0%A4%B6%E0%A4%B2%E0%A5%8D%E0%A4%AF-%E0%A4%AF%E0%A5%8B%E0%A4%9C%E0%A4%A8%E0%A4%BE");
            }
        });

        y4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://sjsa.maharashtra.gov.in/mr/scheme-category/special-assistance");
            }
        });

        return view;
    }

    private void gotoUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}