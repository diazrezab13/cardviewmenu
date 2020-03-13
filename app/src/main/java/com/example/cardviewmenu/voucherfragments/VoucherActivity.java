package com.example.cardviewmenu.voucherfragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.cardviewmenu.GPointActivity;
import com.example.cardviewmenu.R;
import com.example.cardviewmenu.SharedPrefManager;
import com.example.cardviewmenu.voucherfragments.Voucher;
import com.example.cardviewmenu.voucherfragments.VoucherAdapter;

import java.util.ArrayList;

public class VoucherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);

        final ListView list = (ListView) findViewById(R.id.listvoucher);
        ArrayList<Voucher> arrayList = getAllVouchers();
        VoucherAdapter customAdapter = new VoucherAdapter(getApplicationContext(), arrayList);
        list.setAdapter(customAdapter);

        Button btnAll = (Button) findViewById(R.id.btnAll);
        Button btnFNB = (Button) findViewById(R.id.btnFNB);
        Button btnGold = (Button) findViewById(R.id.btnGold);
        Button btnGadai = (Button) findViewById(R.id.btnGadai);
        Button btnBack = (Button) findViewById(R.id.buttonBack1);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(VoucherActivity.this, GPointActivity.class);
                finish();
                startActivity(newIntent);
            }
        });

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Voucher> arrayList = getAllVouchers();
                VoucherAdapter customAdapter = new VoucherAdapter(getApplicationContext(), arrayList);
                list.setAdapter(customAdapter);
            }
        });

        btnFNB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Voucher> arrayList = getFNBVouchers();
                VoucherAdapter customAdapter = new VoucherAdapter(getApplicationContext(), arrayList);
                list.setAdapter(customAdapter);
            }
        });

        btnGold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Voucher> arrayList = getGoldVouchers();
                VoucherAdapter customAdapter = new VoucherAdapter(getApplicationContext(), arrayList);
                list.setAdapter(customAdapter);
            }
        });

        btnGadai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Voucher> arrayList = getGadaiVouchers();
                VoucherAdapter customAdapter = new VoucherAdapter(getApplicationContext(), arrayList);
                list.setAdapter(customAdapter);
            }
        });
    }

    private ArrayList<Voucher> getAllVouchers() {
        ArrayList<Voucher> arrayList = new ArrayList<Voucher>();
        arrayList.add(new Voucher("300", "https://testdiaz.000webhostapp.com/disc_pulsa.jpeg","Discount Pulsa", "Discount Pulsa nih"));
        arrayList.add(new Voucher("150", "https://testdiaz.000webhostapp.com/disc_gold_bag.jpeg","Gold Back", "Gold Back nih"));
        arrayList.add(new Voucher("200", "https://testdiaz.000webhostapp.com/disc_the_gade.jpeg","The Gade Coffee and Gold","The Gade Coffee and Gold nih"));
        return arrayList;
    }

    private ArrayList<Voucher> getFNBVouchers() {
        ArrayList<Voucher> arrayList = new ArrayList<Voucher>();
        arrayList.add(new Voucher("200", "https://testdiaz.000webhostapp.com/disc_the_gade.jpeg","The Gade Coffee and Gold","The Gade Coffee and Gold nih"));
        return arrayList;
    }

    private ArrayList<Voucher> getGoldVouchers() {
        ArrayList<Voucher> arrayList = new ArrayList<Voucher>();
        arrayList.add(new Voucher("150", "https://testdiaz.000webhostapp.com/disc_gold_bag.jpeg","Gold Back", "Gold Back nih"));
        return arrayList;
    }

    private ArrayList<Voucher> getGadaiVouchers() {
        ArrayList<Voucher> arrayList = new ArrayList<Voucher>();
        arrayList.add(new Voucher("300", "https://testdiaz.000webhostapp.com/disc_pulsa.jpeg","Discount Pulsa", "Discount Pulsa nih"));
        return arrayList;
    }
}
