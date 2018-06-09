/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mannydev.bitfliphelperpro.bitflip;

public class Coin {

    private static final double TAKER = 0.0018; //Комиссия тэйкера
    private static final double MAKER = 0.001; //Комиссия мэйкера
    public static final String USD = "USD";
    public static final String RUB = "RUB";
    public static final String BTC = "BTC";


    private String bestBuy;
    private String bestSell;

    private String name;
    
    private Pair usdRub;
    private Pair btcUsd;
    
    private double usdBuy;
    private double usdSell;
    private double btcBuy;
    private double btcSell;
    private double rubBuy;
    private double rubSell;
    
    private String rightNowBuyProfit;
    private String rightNowSellProfit;
    
    private String usdSpread;
    private String rubSpread;
    private String btcSpread;
    
    private String bestBuyProfit;
    private String bestSellProfit;

    public Coin(String name, Pair altUsd, Pair altRub, Pair altBtc, Pair usdRub, Pair btcUsd) {
        this.name = name;
        this.usdBuy = altUsd.getBuy();
        this.usdSell = altUsd.getSell();

        this.btcBuy = altBtc.getBuy();
        this.btcSell = altBtc.getSell();

        this.rubBuy = altRub.getBuy();
        this.rubSell = altRub.getSell();

        this.usdSpread = getSpread(altUsd);
        this.rubSpread = getSpread(altRub);
        this.btcSpread = getSpread(altBtc);

        this.usdRub = usdRub;
        this.btcUsd = btcUsd;
        if(name.equals("BTC")==true){
            this.rightNowBuyProfit = getBuyUsdProfitForBtc(altUsd,altRub);
            this.rightNowSellProfit = getSellUsdProfitForBtc(altUsd,altRub);
        }else{
            this.rightNowBuyProfit = getBuyUsdProfit(altUsd, altRub, altBtc);
            this.rightNowSellProfit = getSellUsdProfit(altUsd, altRub, altBtc);
        }

        this.bestBuyProfit = getBestBuyProfit(altUsd, altRub);
        this.bestSellProfit = getBestSellProfit(altUsd, altRub);

        calcBestProfits(altUsd, altRub, usdRub, altBtc);
    }




    private void calcBestProfits(Pair altUsd, Pair altRub, Pair usdRub, Pair altBtc) {
        double usdBuy, rubBuy,btcBuy, usdSell, rubSell, btcSell;
        usdBuy = altUsd.getBuy();
        usdSell = altUsd.getSell();
        rubBuy = altRub.getBuy()/usdRub.getBuy()-(altRub.getBuy()/usdRub.getBuy()*TAKER);
        rubSell = altRub.getSell()/usdRub.getBuy()-(altRub.getSell()/usdRub.getBuy()*TAKER);
        btcBuy = altBtc.getBuy()/btcUsd.getBuy()-(altBtc.getBuy()/btcUsd.getBuy()*TAKER);
        btcSell = altBtc.getSell()/btcUsd.getBuy()-(altBtc.getSell()/btcUsd.getBuy()*TAKER);

        if(this.name.equals("BTC")==false){
            if(usdBuy<rubBuy && usdBuy<btcBuy){
                bestBuy = USD;
            }
            if(rubBuy<usdBuy && rubBuy<btcBuy){
                bestBuy = RUB;
            }
            if(btcBuy<usdBuy && btcBuy<rubBuy){
                bestBuy = BTC;
            }

            if(usdSell>rubSell && usdSell>btcSell){
                bestSell = USD;
            }
            if(rubSell>usdSell && rubSell>btcSell){
                bestSell = RUB;
            }

            if(btcSell>usdSell && btcSell>rubSell){
                bestSell = BTC;
            }
        }else{
            if(usdBuy<rubBuy){
                bestBuy = USD;
            }else bestBuy = RUB;
            if(usdSell>rubSell){
                bestSell = USD;
            }else bestSell = RUB;
        }


    }


    public static String getSpread(Pair pair) {
        double start = 100.0;
        double step1 = start / pair.getBuy() - (start / pair.getBuy() * MAKER);
        double end = step1 * pair.getSell() - (step1 * pair.getSell() * MAKER);
        double rez = (end - start) * 100 / start;
        return roundResult(rez) + " %";
    }

    static String roundResult(double d) {
        return String.format("%.2f", d);
    }

    //Как купить когда на руках доллары
    public String getBuyUsdProfitForBtc(Pair altUsd, Pair altRub) {
        //Buy for usd
        double buyForUsdStep1 = 1 / altUsd.getSell();
        double buyForUsd = buyForUsdStep1 - buyForUsdStep1 * TAKER;

        //Buy for rub
        double buyForRubstep1 = 1 * usdRub.getBuy();
        double buyForRubStep2 = buyForRubstep1 - buyForRubstep1 * TAKER;//комиссия
        double buyForRubStep3 = buyForRubStep2 / altRub.getSell();
        double buyForRub = buyForRubStep3 - buyForRubStep3 * TAKER;//комиссия

        //Calc best Profit
        if (buyForUsd < buyForRub) {
            double rubBuyProfit = buyForRub * 100 / buyForUsd - 100;
            return "Buy now: RUB (+" + roundResult(rubBuyProfit) + "%)";
        } else {
            double usdBuyProfit = buyForUsd * 100 / buyForRub - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }
    }

    private String getBuyUsdProfit(Pair altUsd, Pair altRub, Pair altBtc) {
        //Buy for usd
        double buyForUsdStep1 = 1 / altUsd.getSell();
        double buyForUsd = buyForUsdStep1 - buyForUsdStep1 * TAKER;

        //Buy for rub
        double buyForRubstep1 = 1 * usdRub.getBuy();
        double buyForRubStep2 = buyForRubstep1 - buyForRubstep1 * TAKER;//комиссия
        double buyForRubStep3 = buyForRubStep2 / altRub.getSell();
        double buyForRub = buyForRubStep3 - buyForRubStep3 * TAKER;//комиссия

        //buy for btc
        double buyForBtcstep1 = 1 / btcUsd.getSell();
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * TAKER;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 * altBtc.getSell();
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * TAKER;//комиссия


        //Calc best Profit
        if (buyForUsd < buyForRub && buyForRub>buyForBtc) {
            double rubBuyProfit = buyForRub * 100 / buyForUsd - 100;
            return "Buy now: RUB (+" + roundResult(rubBuyProfit) + "%)";
        }

        if(buyForUsd>buyForRub && buyForUsd>buyForBtc){
            double usdBuyProfit = buyForUsd * 100 / buyForRub - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }

        if(buyForBtc>buyForUsd && buyForBtc>buyForRub){
            double btcBuyProfit = buyForBtc * 100 / buyForUsd - 100;
            return "Buy now: BTC (+" + roundResult(btcBuyProfit) + "%)";
        }

        return "Buy now: USD";
    }

    //Как продать когда на руках крипта
    public String getSellUsdProfitForBtc(Pair altUsd, Pair altRub) {

        //Sell for usd
        double sellForUsdStep1 = 1 * altUsd.getBuy();
        double sellForUsd = sellForUsdStep1 - (sellForUsdStep1 * TAKER);

        //Sell for rub
        double sellForRubStep1 = 1 * altRub.getBuy();
        double sellForRubStep2 = sellForRubStep1 - sellForRubStep1 * TAKER;
        double sellForRubStep3 = sellForRubStep2 / usdRub.getSell();
        double sellForRub = sellForRubStep3 - sellForRubStep3 * TAKER;

        //Calc best Profit
        if (sellForUsd < sellForRub) {
            double rubSellProfit = sellForRub * 100 / sellForUsd - 100;
            return "Sell now: RUB (+" + roundResult(rubSellProfit) + "%)";
        } else {
            double usdSellProfit = sellForUsd * 100 / sellForRub - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }
    }

    private String getSellUsdProfit(Pair altUsd, Pair altRub, Pair altBtc) {
        //Sell for usd
        double sellForUsdStep1 = 1 * altUsd.getBuy();
        double sellForUsd = sellForUsdStep1 - (sellForUsdStep1 * TAKER);

        //Sell for rub
        double sellForRubStep1 = 1 * altRub.getBuy();
        double sellForRubStep2 = sellForRubStep1 - sellForRubStep1 * TAKER;
        double sellForRubStep3 = sellForRubStep2 / usdRub.getSell();
        double sellForRub = sellForRubStep3 - sellForRubStep3 * TAKER;

        //Sell for btc
        double sellForBtcStep1 = 1 * altBtc.getBuy();
        double sellForBtcStep2 = sellForBtcStep1 - sellForBtcStep1 * TAKER;
        double sellForBtcStep3 = sellForBtcStep2 / btcUsd.getBuy();
        double sellForBtc = sellForBtcStep3 - sellForBtcStep3 * TAKER;

        //Calc best Profit
        if (sellForUsd < sellForRub && sellForRub>sellForBtc) {
            double rubSellProfit = sellForRub * 100 / sellForUsd - 100;
            return "Sell now: RUB (+" + roundResult(rubSellProfit) + "%)";
        }
        if(sellForUsd>sellForBtc && sellForUsd>sellForRub){
            double usdSellProfit = sellForUsd * 100 / sellForRub - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }

        if (sellForBtc>sellForUsd && sellForBtc>sellForRub){
            double btcSellProfit = sellForBtc * 100 / sellForUsd - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        }

        return "Sell now: USD";
    }

    //Схема из баксов через другой фиат
    public String getBestSellProfit(Pair altUsd, Pair altRub) {
        double start = 100.0;
        double step1 = start / altUsd.getSell() - (start / altUsd.getSell() * TAKER);
        double step2 = step1 * altRub.getBuy() - (step1 * altRub.getBuy() * TAKER);
        double end = step2 / usdRub.getSell() - (step2 / usdRub.getSell() * TAKER);
        double rez = end * 100 / start - 100;
        return roundResult(rez) + " %";
    }

    //Схема из рублей через другой фиат
    public String getBestBuyProfit(Pair altUsd, Pair altRub) {
        double start = 100.0;
        double step1 = start / altRub.getSell() - (start / altRub.getSell() * TAKER);
        double step2 = step1 * altUsd.getBuy() - (step1 * altUsd.getBuy() * TAKER);
        double end = step2 * usdRub.getBuy() - (step2 * usdRub.getBuy() * TAKER);
        double rez = end * 100 / start - 100;
        return roundResult(rez) + " %";
    }

    public double getUsdBuy() {
        return usdBuy;
    }

    public String getName() {
        return name;
    }

    public double getUsdSell() {
        return usdSell;
    }

    public double getRubBuy() {
        return rubBuy;
    }

    public double getRubSell() {
        return rubSell;
    }

    public String getRightNowBuyProfit() {
        return rightNowBuyProfit;
    }

    public String getRightNowSellProfit() {
        return rightNowSellProfit;
    }

    public String getUsdSpread() {
        return usdSpread;
    }

    public String getRubSpread() {
        return rubSpread;
    }

    public String getBestBuyProfit() {
        return bestBuyProfit;
    }

    public String getBestSellProfit() {
        return bestSellProfit;
    }

    public String getBestBuy() {
        return bestBuy;
    }

    public String getBestSell() {
        return bestSell;
    }

    public double getBtcBuy() {
        return btcBuy;
    }

    public double getBtcSell() {
        return btcSell;
    }

    public String getBtcSpread() {
        return btcSpread;
    }

    @Override
    public String toString(){
        return name+"__"+usdBuy+"__"+rubBuy+"__"+btcBuy;
    }
}
