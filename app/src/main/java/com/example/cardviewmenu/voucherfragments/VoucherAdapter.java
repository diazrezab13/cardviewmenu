package com.example.cardviewmenu.voucherfragments;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.cardviewmenu.R;
import com.example.cardviewmenu.leaderboardfragment.Leaderboard;
import com.example.cardviewmenu.voucherfragments.Voucher;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class VoucherAdapter implements ListAdapter {
    ArrayList<Voucher> arrayList;
    Context context;

    public VoucherAdapter(Context context, ArrayList<Voucher> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Voucher subjectData = arrayList.get(position);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_voucher, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            TextView point = convertView.findViewById(R.id.txtPoint);
            ImageView imag = convertView.findViewById(R.id.imgVoucher);
            TextView name = convertView.findViewById((R.id.txtTitle));

            point.setText(subjectData.point);
            name.setText(subjectData.name);
            Picasso.with(context)
                    .load(subjectData.image)
                    .into(imag);
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
