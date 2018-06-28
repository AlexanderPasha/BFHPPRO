/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mannydev.bitfliphelperpro.bitflip;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Observable;

public class Bitflip extends Observable {

    private static Bitflip bitflip;

    private Pair usdRub;
    private Pair btcUsd;
    private Pair btcRub;
    private Pair ltcUsd;
    private Pair ltcRub;
    private Pair ltcBtc;
    private Pair ethUsd;
    private Pair ethRub;
    private Pair ethBtc;
    private Pair xrpUsd;
    private Pair xrpRub;
    private Pair xrpBtc;
    private Pair trxUsd;
    private Pair trxRub;
    private Pair trxBtc;
    private Pair flipUsd;
    private Pair flipRub;
    private Pair flipBtc;
    private Pair dashUsd;
    private Pair dashRub;
    private Pair dashBtc;
    private Pair dogeUsd;
    private Pair dogeRub;
    private Pair dogeBtc;
    private Pair bchUsd;
    private Pair bchRub;
    private Pair bchBtc;
    private Pair rUsd;
    private Pair rRub;
    private Pair rBtc;
    private Pair rmcUsd;
    private Pair rmcRub;
    private Pair rmcBtc;
    private Pair btgUsd;
    private Pair btgRub;
    private Pair btgBtc;
    private Pair nanoUsd;
    private Pair nanoRub;
    private Pair nanoBtc;
    private Pair foodUsd;
    private Pair foodRub;
    private Pair foodBtc;
    private Pair realUsd;
    private Pair realRub;
    private Pair realBtc;
    private Pair eosUsd;
    private Pair eosRub;
    private Pair eosBtc;
    private Pair btwUsd;
    private Pair btwRub;
    private Pair btwBtc;
    private Pair lindaUsd;
    private Pair lindaRub;
    private Pair lindaBtc;

    private Pair benUsd;
    private Pair benRub;
    private Pair benBtc;

    private Pair cscUsd;
    private Pair cscRub;
    private Pair cscBtc;

    private Pair omgUsd;
    private Pair omgRub;
    private Pair omgBtc;

    private Bitflip() {
        initPairs();
    }

    public static Bitflip getInstanse(){
        if (bitflip==null){
            bitflip = new Bitflip();
            System.out.println("Bitflip создан!");
            return bitflip;
        }else{
            return bitflip;
        }
    }

    private void ratesChanged() {
        setChanged();
        notifyObservers();
    }

    private void initPairs() {
        usdRub = new Pair();
        btcUsd = new Pair();
        btcRub = new Pair();
        ltcUsd = new Pair();
        ltcRub = new Pair();
        ltcBtc = new Pair();
        ethUsd = new Pair();
        ethRub = new Pair();
        ethBtc = new Pair();
        xrpUsd = new Pair();
        xrpRub = new Pair();
        xrpBtc = new Pair();
        trxUsd = new Pair();
        trxRub = new Pair();
        trxBtc = new Pair();
        flipUsd = new Pair();
        flipRub = new Pair();
        flipBtc = new Pair();
        dashUsd = new Pair();
        dashRub = new Pair();
        dashBtc = new Pair();
        dogeUsd = new Pair();
        dogeRub = new Pair();
        dogeBtc = new Pair();
        bchUsd = new Pair();
        bchRub = new Pair();
        bchBtc = new Pair();
        rUsd = new Pair();
        rRub = new Pair();
        rBtc = new Pair();
        rmcUsd = new Pair();
        rmcRub = new Pair();
        rmcBtc = new Pair();
        btgUsd = new Pair();
        btgRub = new Pair();
        btgBtc = new Pair();
        nanoUsd = new Pair();
        nanoRub = new Pair();
        nanoBtc = new Pair();
        foodUsd = new Pair();
        foodRub = new Pair();
        foodBtc = new Pair();
        realUsd = new Pair();
        realRub = new Pair();
        realBtc = new Pair();
        eosUsd = new Pair();
        eosRub = new Pair();
        eosBtc = new Pair();
        btwUsd = new Pair();
        btwRub = new Pair();
        btwBtc = new Pair();
        lindaUsd = new Pair();
        lindaRub = new Pair();
        lindaBtc = new Pair();
        benUsd = new Pair();
        benRub = new Pair();
        benBtc = new Pair();
        cscUsd = new Pair();
        cscRub = new Pair();
        cscBtc = new Pair();
        omgUsd = new Pair();
        omgRub = new Pair();
        omgBtc = new Pair();
    }

    public void refresh(String rates) {
        JSONArray array = null;
        try {
            array = new JSONArray(rates);


        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);

            if (object.get("pair").equals("USD:RUB")) {
                this.usdRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("LTC:USD")) {
                this.ltcUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("LTC:RUB")) {
                this.ltcRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("LTC:BTC")) {
                this.ltcBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("BTC:USD")) {
                this.btcUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("BTC:RUB")) {
                this.btcRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("ETH:USD")) {
                this.ethUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("ETH:RUB")) {
                this.ethRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("ETH:BTC")) {
                this.ethBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("XRP:USD")) {
                this.xrpUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("XRP:RUB")) {
                this.xrpRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("XRP:BTC")) {
                this.xrpBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("TRX:USD")) {
                this.trxUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("TRX:RUB")) {
                this.trxRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("TRX:BTC")) {
                this.trxBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("FLIP:USD")) {
                this.flipUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("FLIP:RUB")) {
                this.flipRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("FLIP:BTC")) {
                this.flipBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("DASH:USD")) {
                this.dashUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("DASH:RUB")) {
                this.dashRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("DASH:BTC")) {
                this.dashBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("DOGE:USD")) {
                this.dogeUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("DOGE:RUB")) {
                this.dogeRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("DOGE:BTC")) {
                this.dogeBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BCH:USD")) {
                this.bchUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BCH:RUB")) {
                this.bchRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BCH:BTC")) {
                this.bchBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("R:USD")) {
                this.rUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("R:RUB")) {
                this.rRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("R:BTC")) {
                this.rBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("RMC:USD")) {
                this.rmcUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("RMC:RUB")) {
                this.rmcRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("RMC:BTC")) {
                this.rmcBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BTG:USD")) {
                this.btgUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BTG:RUB")) {
                this.btgRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BTG:BTC")) {
                this.btgBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("NANO:USD")) {
                this.nanoUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("NANO:RUB")) {
                this.nanoRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("NANO:BTC")) {
                this.nanoBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("FOOD:USD")) {
                this.foodUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("FOOD:RUB")) {
                this.foodRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("FOOD:BTC")) {
                this.foodBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("REAL:USD")) {
                this.realUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("REAL:RUB")) {
                this.realRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("REAL:BTC")) {
                this.realBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("EOS:USD")) {
                this.eosUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("EOS:RUB")) {
                this.eosRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("EOS:BTC")) {
                this.eosBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BTW:USD")) {
                this.btwUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BTW:RUB")) {
                this.btwRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BTW:BTC")) {
                this.btwBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("LINDA:USD")) {
                this.lindaUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("LINDA:RUB")) {
                this.lindaRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("LINDA:BTC")) {
                this.lindaBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BEN:USD")) {
                this.benUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BEN:RUB")) {
                this.benRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BEN:BTC")) {
                this.benBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("CSC:USD")) {
                this.cscUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("CSC:RUB")) {
                this.cscRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("CSC:BTC")) {
                this.cscBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("OMG:USD")) {
                this.omgUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("OMG:RUB")) {
                this.omgRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("OMG:BTC")) {
                this.omgBtc = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ratesChanged();
    }

    public Pair getUsdRub() {
        return usdRub;
    }

    public Pair getBtcUsd() {
        return btcUsd;
    }

    public Pair getBtcRub() {
        return btcRub;
    }

    public Pair getLtcUsd() {
        return ltcUsd;
    }

    public Pair getLtcRub() {
        return ltcRub;
    }

    public Pair getEthUsd() {
        return ethUsd;
    }

    public Pair getEthRub() {
        return ethRub;
    }

    public Pair getXrpUsd() {
        return xrpUsd;
    }

    public Pair getXrpRub() {
        return xrpRub;
    }

    public Pair getTrxUsd() {
        return trxUsd;
    }

    public Pair getTrxRub() {
        return trxRub;
    }

    public Pair getFlipUsd() {
        return flipUsd;
    }

    public Pair getFlipRub() {
        return flipRub;
    }

    public Pair getDashUsd() {
        return dashUsd;
    }

    public Pair getDashRub() {
        return dashRub;
    }

    public Pair getDogeUsd() {
        return dogeUsd;
    }

    public Pair getDogeRub() {
        return dogeRub;
    }

    public Pair getBchUsd() {
        return bchUsd;
    }

    public Pair getBchRub() {
        return bchRub;
    }

    public Pair getrUsd() {
        return rUsd;
    }

    public Pair getrRub() {
        return rRub;
    }

    public Pair getRmcUsd() {
        return rmcUsd;
    }

    public Pair getRmcRub() {
        return rmcRub;
    }

    public Pair getBtgUsd() {
        return btgUsd;
    }

    public Pair getBtgRub() {
        return btgRub;
    }

    public Pair getNanoUsd() {
        return nanoUsd;
    }

    public Pair getNanoRub() {
        return nanoRub;
    }

    public Pair getFoodUsd() {
        return foodUsd;
    }

    public Pair getFoodRub() {
        return foodRub;
    }

    public Pair getRealUsd() {
        return realUsd;
    }

    public Pair getRealRub() {
        return realRub;
    }

    public Pair getEosUsd() {
        return eosUsd;
    }

    public Pair getEosRub() {
        return eosRub;
    }

    public Pair getBtwUsd() {
        return btwUsd;
    }

    public Pair getBtwRub() {
        return btwRub;
    }

    public Pair getLtcBtc() {
        return ltcBtc;
    }

    public Pair getEthBtc() {
        return ethBtc;
    }

    public Pair getXrpBtc() {
        return xrpBtc;
    }

    public Pair getTrxBtc() {
        return trxBtc;
    }

    public Pair getFlipBtc() {
        return flipBtc;
    }

    public Pair getDashBtc() {
        return dashBtc;
    }

    public Pair getDogeBtc() {
        return dogeBtc;
    }

    public Pair getBchBtc() {
        return bchBtc;
    }

    public Pair getrBtc() {
        return rBtc;
    }

    public Pair getRmcBtc() {
        return rmcBtc;
    }

    public Pair getBtgBtc() {
        return btgBtc;
    }

    public Pair getNanoBtc() {
        return nanoBtc;
    }

    public Pair getFoodBtc() {
        return foodBtc;
    }

    public Pair getRealBtc() {
        return realBtc;
    }

    public Pair getEosBtc() {
        return eosBtc;
    }

    public Pair getBtwBtc() {
        return btwBtc;
    }

    public Pair getLindaUsd() {
        return lindaUsd;
    }

    public Pair getLindaRub() {
        return lindaRub;
    }

    public Pair getLindaBtc() {
        return lindaBtc;
    }

    public Pair getBenUsd() {
        return benUsd;
    }

    public Pair getBenRub() {
        return benRub;
    }

    public Pair getBenBtc() {
        return benBtc;
    }

    public Pair getCscUsd() {
        return cscUsd;
    }

    public Pair getCscRub() {
        return cscRub;
    }

    public Pair getCscBtc() {
        return cscBtc;
    }

    public Pair getOmgUsd() {
        return omgUsd;
    }

    public Pair getOmgRub() {
        return omgRub;
    }

    public Pair getOmgBtc() {
        return omgBtc;
    }
}


