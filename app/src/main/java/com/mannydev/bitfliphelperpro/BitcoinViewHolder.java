package com.mannydev.bitfliphelperpro;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mannydev.bitfliphelperpro.bitflip.Coin;

import static com.mannydev.bitfliphelperpro.R.id.txtBtcBuy;
import static com.mannydev.bitfliphelperpro.R.id.txtBtcSell;
import static com.mannydev.bitfliphelperpro.R.id.txtBtcSpread;


/**
 * Created by manny on 16.01.18.
 */

public class BitcoinViewHolder extends MyViewHolder {

    TextView txtCoinName,txtUsdBuy,txtUsdSell,txtRubBuy,txtRubSell,
            txtUsdSpread,txtRubSpread, txtBrn,txtSrn;

    public BitcoinViewHolder(View itemView) {
        super(itemView);
        txtCoinName = itemView.findViewById(R.id.txtCoinName);
        txtUsdBuy = itemView.findViewById(R.id.txtUsdBuy);
        txtUsdSell = itemView.findViewById(R.id.txtUsdSell);
        txtRubBuy = itemView.findViewById(R.id.txtRubBuy);
        txtRubSell = itemView.findViewById(R.id.txtRubSell);
        txtUsdSpread = itemView.findViewById(R.id.txtUsdSpread);
        txtRubSpread = itemView.findViewById(R.id.txtRubSpread);
        txtBrn = itemView.findViewById(R.id.txtBrn);
        txtSrn = itemView.findViewById(R.id.txtSrn);

    }

    public void onBindCoinHolder(Coin coin){
        txtCoinName.setText(coin.getName());

        txtUsdBuy.setText(String.valueOf(coin.getUsdBuy()));
        txtUsdSell.setText(String.valueOf(coin.getUsdSell()));
        txtRubBuy.setText(String.valueOf(coin.getRubBuy()));
        txtRubSell.setText(String.valueOf(coin.getRubSell()));

        txtUsdSpread.setText(coin.getUsdSpread());
        txtRubSpread.setText(coin.getRubSpread());

        txtBrn.setText(coin.getRightNowBuyProfit());
        txtSrn.setText(coin.getRightNowSellProfit());

        if(coin.getBestBuy().equals("USD")) {
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }
        if (coin.getBestBuy().equals("RUB")) {
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }
        if (coin.getBestSell().equals("USD")) {
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }
        if (coin.getBestSell().equals("RUB")) {
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }

    }
}
