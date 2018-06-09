package com.mannydev.bitfliphelperpro;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mannydev.bitfliphelperpro.bitflip.Coin;




/**
 * Created by manny on 16.01.18.
 */

public class CoinViewHolder extends MyViewHolder  {

    TextView txtCoinName,txtUsdBuy,txtUsdSell,txtRubBuy,txtRubSell,txtBtcBuy,txtBtcSell,
            txtUsdSpread,txtRubSpread,txtBtcSpread, txtBrn,txtSrn;

    public CoinViewHolder(View itemView) {
        super(itemView);
        txtCoinName = itemView.findViewById(R.id.txtCoinName);
        txtUsdBuy = itemView.findViewById(R.id.txtUsdBuy);
        txtUsdSell = itemView.findViewById(R.id.txtUsdSell);
        txtBtcBuy = itemView.findViewById(R.id.txtBtcBuy);
        txtBtcSell = itemView.findViewById(R.id.txtBtcSell);
        txtRubBuy = itemView.findViewById(R.id.txtRubBuy);
        txtRubSell = itemView.findViewById(R.id.txtRubSell);
        txtUsdSpread = itemView.findViewById(R.id.txtUsdSpread);
        txtRubSpread = itemView.findViewById(R.id.txtRubSpread);
        txtBtcSpread = itemView.findViewById(R.id.txtBtcSpread);
        txtBrn = itemView.findViewById(R.id.txtBrn);
        txtSrn = itemView.findViewById(R.id.txtSrn);

    }

    public void onBindCoinHolder(Coin coin){
        txtCoinName.setText(coin.getName());

        txtUsdBuy.setText(String.valueOf(coin.getUsdBuy()));
        txtUsdSell.setText(String.valueOf(coin.getUsdSell()));
        txtRubBuy.setText(String.valueOf(coin.getRubBuy()));
        txtRubSell.setText(String.valueOf(coin.getRubSell()));
        txtBtcBuy.setText(String.valueOf(coin.getBtcBuy()));
        txtBtcSell.setText(String.valueOf(coin.getBtcSell()));

        txtUsdSpread.setText(coin.getUsdSpread());
        txtRubSpread.setText(coin.getRubSpread());
        txtBtcSpread.setText(coin.getBtcSpread());

        txtBrn.setText(coin.getRightNowBuyProfit());
        txtSrn.setText(coin.getRightNowSellProfit());

        if(coin.getBestBuy().equals("USD")) {
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }
        if (coin.getBestBuy().equals("RUB")) {
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }
        if (coin.getBestBuy().equals("BTC")) {
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }

        if (coin.getBestSell().equals("USD")) {
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }
        if (coin.getBestSell().equals("RUB")) {
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }

        if (coin.getBestSell().equals("BTC")) {
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }
    }
}
