package com.mannydev.bitfliphelperpro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mannydev.bitfliphelperpro.bitflip.Coin;

import java.util.ArrayList;

/**
 * Created by manny on 16.01.18.
 */

public class CoinViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private static final int BITCOIN = 0;
    private static final int ALTCOIN = 1;
    ArrayList<Coin>list;


    public CoinViewAdapter() {

    }

    public void setData(ArrayList<Coin> list){
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ALTCOIN){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.coin_view, parent, false);
            return new CoinViewHolder(v);
        }else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.bitcoin_view, parent, false);
            return new BitcoinViewHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Coin coin = list.get(position);
        holder.onBindCoinHolder(coin);
    }

    @Override
    public int getItemViewType(int position) {
        Coin coin = list.get(position);
        if(coin.getName().equals("BTC")){
            return BITCOIN;
        }else return ALTCOIN;

    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }
}
