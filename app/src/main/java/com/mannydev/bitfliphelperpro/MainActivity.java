package com.mannydev.bitfliphelperpro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mannydev.bitfliphelperpro.bitflip.Bitflip;
import com.mannydev.bitfliphelperpro.bitflip.Coin;
import com.mannydev.bitfliphelperpro.bitflip.Controller;
import com.mannydev.bitfliphelperpro.bitflip.Pair;
import com.mannydev.bitfliphelperpro.bitflip.Rates;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mannydev.bitfliphelperpro.MainActivity.bitflip;
import static com.mannydev.bitfliphelperpro.MainActivity.context;


public class MainActivity extends AppCompatActivity {

    private static final String APP_CACHE = "cache";
    public static final String RATES = "rates";
    public static final String USD = "usd";

    Controller controller;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rvCoins)
    RecyclerView rvCoins;
    CoinViewAdapter adapter;
    ArrayList<Coin> coins;
    @BindView(R.id.btnRefresh)
    Button btnRefresh;
    @BindView(R.id.txtUsdRubBuy)
    TextView txtUsdRubBuy;
    @BindView(R.id.txtUsdRubSell)
    TextView txtUsdRubSell;
    @BindView(R.id.txtUsdRubSprd)
    TextView txtUsdRubSprd;

    public static Bitflip bitflip;
    public static Context context;

    @BindView(R.id.btnLogo)
    Button btnLogo;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;
    private SharedPreferences appCache;
    private PopupMenu popupMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = getApplicationContext();

        adapter = new CoinViewAdapter();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvCoins.setLayoutManager(mLayoutManager);
        rvCoins.setAdapter(adapter);

        bitflip = Bitflip.getInstanse();
        controller = new Controller(bitflip);

        appCache = getSharedPreferences(APP_CACHE, MODE_PRIVATE);

        if (appCache.contains(RATES) && appCache.contains(USD)) {
            getRatesFromCashe();
        } else {
            refresh();
        }
        refresh();

        //Меню
        popupMenu = new PopupMenu(this, btnLogo);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.menu1:
                        intent = new Intent(getApplicationContext(), AboutActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.menu2:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://bitflip.cc/?ref=13d2mocg9b8g"));
                        startActivity(intent);
                        break;
                    case R.id.menu3:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("market://details?id=com.mannydev.bitfliphelperpro"));
                        startActivity(intent);
                        break;
                }
                return true;
            }

        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    void refresh() {
        if (hasConnection(MainActivity.this)) {
            RatesGetter rg = new RatesGetter();
            rg.execute();
            coins = controller.getCoins();

            if (coins.isEmpty()==false) {
                Rates rates = new Rates();
                rates.setList(coins);
                objectToCache(rates, RATES);
                objectToCache(bitflip.getUsdRub(), USD);
                txtUsdRubBuy.setText(String.valueOf(bitflip.getUsdRub().getBuy()));
                txtUsdRubSell.setText(String.valueOf(bitflip.getUsdRub().getSell()));
                txtUsdRubSprd.setText(Coin.getSpread(bitflip.getUsdRub()));
                adapter.setData(coins);
                adapter.notifyDataSetChanged();
            }

        } else {
            getRatesFromCashe();
            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }

    }

    private void objectToCache(Object object, String label) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String s = gson.toJson(object);
        SharedPreferences.Editor editor = appCache.edit();
        editor.putString(label, s);
        editor.apply();
    }

    private void getRatesFromCashe() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Rates rates = gson.fromJson(appCache.getString(RATES, null), Rates.class);
        coins = rates.getList();
        Pair usd = gson.fromJson(appCache.getString(USD, null), Pair.class);
        txtUsdRubBuy.setText(String.valueOf(usd.getBuy()));
        txtUsdRubSell.setText(String.valueOf(usd.getSell()));
        txtUsdRubSprd.setText(Coin.getSpread(usd));
        adapter.setData(coins);
        rvCoins.setAdapter(adapter);
    }

    private static boolean hasConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        return wifiInfo != null && wifiInfo.isConnected();
    }

    public void makeToast(){
        Toast.makeText(MainActivity.this,"Bad Connection",Toast.LENGTH_SHORT).show();
    }



    @OnClick({R.id.btnLogo, R.id.btnRefresh,R.id.btnBag})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogo:
                popupMenu.show();
                break;
            case R.id.btnRefresh:
                refresh();
                break;
            case R.id.btnBag:
                refresh();
                Intent intent = new Intent(getApplicationContext(), BagActivity.class);
                startActivity(intent);
                break;
        }
    }
}

class RatesGetter extends AsyncTask<Void,Void,String>{

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected String doInBackground(Void... voids) {
            StringBuilder response = new StringBuilder();
            String sourceUrl = "https://api.bitflip.cc/method/market.getRates";
            try {
                URL url = new URL(sourceUrl);
                HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();
                httpconn.addRequestProperty("User-Agent", "Mozilla/4.76");
                if (httpconn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader input;
                    input = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));
                    String strLine;
                    while ((strLine = input.readLine()) != null) {
                        response.append(strLine);
                    }
                    input.close();
                }
                httpconn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String json = response.toString();
            if(response.length()>50){
                json = json.substring(6);
                json = json.substring(0, json.length() - 1);
                return json;
            }
            return null;
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);
        if(json!=null){
            bitflip.refresh(json);
            System.out.println("Rates refreshed");
        }else Toast.makeText(context, "Bad connection", Toast.LENGTH_SHORT);
    }

    private static boolean hasConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        return wifiInfo != null && wifiInfo.isConnected();
    }
}


