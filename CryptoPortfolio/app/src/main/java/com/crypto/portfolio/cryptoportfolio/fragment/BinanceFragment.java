package com.crypto.portfolio.cryptoportfolio.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.crypto.portfolio.cryptoportfolio.R;
import com.crypto.portfolio.cryptoportfolio.utils.SharedPreferencesUtils;

public class BinanceFragment extends Fragment {

    String binanceKey;
    String binanceSecret;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_binance, container, false);

        final FloatingActionButton fab = view.findViewById(R.id.addBinanceKey);

        final TextView binanceBackgroundText = view.findViewById(R.id.binanceBackgroundText);

        binanceKey = SharedPreferencesUtils.get(SharedPreferencesUtils.BINANCE_KEY_NAME, getContext());
        binanceSecret = SharedPreferencesUtils.get(SharedPreferencesUtils.BINANCE_SECRET_NAME, getContext());

        if (binanceKey != null && binanceSecret != null) {
            binanceBackgroundText.setText("account exists.. hitting binance api");
            fab.setVisibility(View.GONE);
        } else {
            fab.setVisibility(View.VISIBLE);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alBuilder = new AlertDialog.Builder(getContext());
                final View mView = getLayoutInflater().inflate(R.layout.dialog_add_binance_key, null);
                alBuilder.setView(mView);
                final AlertDialog dialog = alBuilder.create();
                mView.findViewById(R.id.add_binance_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText binance_key = mView.findViewById(R.id.binance_key);
                        EditText binance_secret = mView.findViewById(R.id.binance_secret);
                        binanceKey = binance_secret.getText().toString();
                        binanceSecret = binance_secret.getText().toString();
                        SharedPreferencesUtils.setBinancePreference(binanceKey , binanceSecret);
                        Toast.makeText(getContext(), "Binance key added", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        fab.setVisibility(View.GONE);
                        binanceBackgroundText.setText("account exists.. hitting binance api");
                    }
                });
                dialog.show();
            }
        });
        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.binanceRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "binance Data updated", Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });
        return view;
    }
}
