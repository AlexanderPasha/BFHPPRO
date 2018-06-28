/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mannydev.bitfliphelperpro.bitflip;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author manny
 */
public class Controller implements Observer {

    private Pair usdRub, btcUsd, btcRub, ltcUsd, ltcRub, ltcBtc,
            ethUsd, ethRub,ethBtc, xrpUsd, xrpRub,xrpBtc, trxUsd, trxRub,trxBtc, flipUsd, flipRub,
            flipBtc, dashUsd, dashRub,dashBtc, dogeUsd, dogeRub,dogeBtc, bchUsd, bchRub, bchBtc, rUsd, rRub,
            rBtc, rmcUsd, rmcRub, rmcBtc, btgUsd, btgRub,btgBtc, nanoUsd, nanoRub,nanoBtc, foodUsd, foodRub,
            foodBtc, realUsd, realRub, realBtc,
            eosUsd,eosRub,eosBtc,btwUsd,btwRub,btwBtc,lindaUsd,lindaRub,lindaBtc, benUsd, benRub, benBtc,
            cscUsd,cscRub,cscBtc;

    private Coin btc, ltc, eth, xrp, trx, flip,
            dash, doge, bch, r, rmc, btg, nano, food, real, eos, btw, linda, ben, csc;

    Observable observable;
    ArrayList<Coin> coins;

    public Controller(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
        this.coins = new ArrayList<>();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Bitflip) {
            Bitflip bitflip = (Bitflip) o;
            updatePairs(bitflip);
            updateCoins();
        }
    }

    private void updatePairs(Bitflip b) {
        this.usdRub = b.getUsdRub();
        this.btcUsd = b.getBtcUsd();
        this.btcRub = b.getBtcRub();

        this.ltcUsd = b.getLtcUsd();
        this.ltcRub = b.getLtcRub();
        this.ltcBtc = b.getLtcBtc();

        this.ethUsd = b.getEthUsd();
        this.ethRub = b.getEthRub();
        this.ethBtc = b.getEthBtc();

        this.xrpUsd = b.getXrpUsd();
        this.xrpRub = b.getXrpRub();
        this.xrpBtc = b.getXrpBtc();

        this.trxUsd = b.getTrxUsd();
        this.trxRub = b.getTrxRub();
        this.trxBtc = b.getTrxBtc();

        this.flipUsd = b.getFlipUsd();
        this.flipRub = b.getFlipRub();
        this.flipBtc = b.getFlipBtc();

        this.dashUsd = b.getDashUsd();
        this.dashRub = b.getDashRub();
        this.dashBtc = b.getDashBtc();

        this.dogeUsd = b.getDogeUsd();
        this.dogeRub = b.getDogeRub();
        this.dogeBtc = b.getDogeBtc();

        this.bchUsd = b.getBchUsd();
        this.bchRub = b.getBchRub();
        this.bchBtc = b.getBchBtc();

        this.rUsd = b.getrUsd();
        this.rRub = b.getrRub();
        this.rBtc = b.getrBtc();

        this.rmcUsd = b.getRmcUsd();
        this.rmcRub = b.getRmcRub();
        this.rmcBtc = b.getRmcBtc();

        this.btgUsd = b.getBtgUsd();
        this.btgRub = b.getBtgRub();
        this.btgBtc = b.getBtgBtc();

        this.nanoUsd = b.getNanoUsd();
        this.nanoRub = b.getNanoRub();
        this.nanoBtc = b.getNanoBtc();

        this.foodUsd = b.getFoodUsd();
        this.foodRub = b.getFoodRub();
        this.foodBtc = b.getFoodBtc();

        this.realUsd = b.getRealUsd();
        this.realRub = b.getRealRub();
        this.realBtc = b.getRealBtc();

        this.eosUsd = b.getEosUsd();
        this.eosRub = b.getEosRub();
        this.eosBtc = b.getEosBtc();

        this.btwUsd = b.getBtwUsd();
        this.btwRub = b.getBtwRub();
        this.btwBtc = b.getBtwBtc();

        this.lindaUsd = b.getLindaUsd();
        this.lindaRub = b.getLindaRub();
        this.lindaBtc = b.getLindaBtc();

        this.benUsd = b.getBenUsd();
        this.benRub = b.getBenRub();
        this.benBtc = b.getBenBtc();

        this.cscUsd = b.getCscUsd();
        this.cscRub = b.getCscRub();
        this.cscBtc = b.getCscBtc();
    }

    private void updateCoins() {
        this.btc = new Coin("BTC", btcUsd, btcRub,btcUsd, usdRub,btcUsd);
        this.ltc = new Coin("LTC", ltcUsd, ltcRub,ltcBtc, usdRub, btcUsd);
        this.eth = new Coin("ETH", ethUsd, ethRub,ethBtc, usdRub, btcUsd);
        this.xrp = new Coin("XRP", xrpUsd, xrpRub,xrpBtc, usdRub,btcUsd);
        this.trx = new Coin("TRX", trxUsd, trxRub,trxBtc, usdRub,btcUsd);
        this.flip = new Coin("FLIP", flipUsd, flipRub,flipBtc, usdRub,btcUsd);
        this.dash = new Coin("DASH", dashUsd, dashRub,dashBtc, usdRub,btcUsd);
        this.doge = new Coin("DOGE", dogeUsd, dogeRub,dogeBtc, usdRub,btcUsd);
        this.bch = new Coin("BCH", bchUsd, bchRub,bchBtc, usdRub,btcUsd);
        this.r = new Coin("R", rUsd, rRub,rBtc, usdRub,btcUsd);
        this.rmc = new Coin("RMC", rmcUsd, rmcRub,rmcBtc, usdRub,btcUsd);
        this.btg = new Coin("BTG", btgUsd, btgRub,btgBtc, usdRub,btcUsd);
        this.nano = new Coin("NANO", nanoUsd, nanoRub, nanoBtc, usdRub,btcUsd);
        this.food = new Coin("FOOD", foodUsd, foodRub, foodBtc, usdRub,btcUsd);
        this.real = new Coin("REAL", realUsd, realRub,realBtc, usdRub,btcUsd);
        this.eos = new Coin("EOS", eosUsd, eosRub, eosBtc, usdRub,btcUsd);
        this.btw = new Coin("BTW", btwUsd, btwRub,btwBtc, usdRub,btcUsd);
        this.linda = new Coin("LINDA", lindaUsd, lindaRub,lindaBtc, usdRub,btcUsd);
        this.ben = new Coin("BEN", benUsd, benRub,benBtc, usdRub,btcUsd);
        this.csc = new Coin("CSC", cscUsd,cscRub,cscBtc,usdRub,btcUsd);
        addCoinsToList();
    }

    private void addCoinsToList() {
        coins = new ArrayList<>();
        coins.add(btc);
        coins.add(ltc);
        coins.add(eth);
        coins.add(xrp);
        coins.add(trx);
        coins.add(flip);
        coins.add(dash);
        coins.add(doge);
        coins.add(bch);
        coins.add(r);
        coins.add(rmc);
        coins.add(btg);
        coins.add(nano);
        coins.add(food);
        coins.add(real);
        coins.add(eos);
        coins.add(btw);
        coins.add(linda);
        coins.add(ben);
        coins.add(csc);
    }

    public ArrayList getCoins() {
        return coins;
    }

}
