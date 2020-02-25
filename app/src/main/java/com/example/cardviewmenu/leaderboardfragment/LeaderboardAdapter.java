package com.example.cardviewmenu.leaderboardfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardviewmenu.R;

import java.util.ArrayList;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {
    Context context;
    ArrayList<Leaderboard> listLeader;

    public LeaderboardAdapter(Context context){
        this.context = context;
        listLeader = new ArrayList<>();
    }

    public void setListLeader(ArrayList<Leaderboard> listLeader){
        this.listLeader = listLeader;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_leaderboard, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Leaderboard leader = listLeader.get(position);
        holder.txtRank.setText(leader.userRank);
        holder.txtUser.setText(leader.userNama);
        holder.txtPoint.setText(leader.userPoin);
    }

    @Override
    public int getItemCount() {
        return listLeader.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtRank;
        public TextView txtUser;
        public TextView txtPoint;
        public ImageView imgCoin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRank = itemView.findViewById(R.id.userRank);
            txtUser = itemView.findViewById(R.id.userLead);
            txtPoint = itemView.findViewById(R.id.userPoint);
            imgCoin = itemView.findViewById(R.id.imgCoin);
        }
    }
}
