package com.crypto.portfolio.cryptoportfolio.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.crypto.portfolio.cryptoportfolio.R;
import com.crypto.portfolio.cryptoportfolio.utils.SharedPreferencesUtils;

public class BittrexFragment extends Fragment {

    String bittrexKey;
    String bittrexSecret;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bittrex, container, false);

        final FloatingActionButton fab = view.findViewById(R.id.addBittrexKey);

        final TextView bittrexBackgroundText = view.findViewById(R.id.bittrexBackgroundText);

        bittrexKey = SharedPreferencesUtils.get(SharedPreferencesUtils.BITTREX_KEY_NAME, getContext());
        bittrexSecret = SharedPreferencesUtils.get(SharedPreferencesUtils.BITTREX_SECRET_NAME, getContext());

        if (bittrexKey != null && bittrexSecret != null) {
            bittrexBackgroundText.setText("account exists.. hitting bittrex api");
            fab.setVisibility(View.GONE);
        } else {
            fab.setVisibility(View.VISIBLE);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alBuilder = new AlertDialog.Builder(getContext());
                final View mView = getLayoutInflater().inflate(R.layout.dialog_add_bittrex_key, null);
                alBuilder.setView(mView);
                final AlertDialog dialog = alBuilder.create();
                mView.findViewById(R.id.add_bittrex_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        EditText bittrex_key = mView.findViewById(R.id.bittrex_key);
                        EditText bittrex_secret = mView.findViewById(R.id.bittrex_secret);
                        bittrexKey = bittrex_key.getText().toString();
                        bittrexSecret = bittrex_secret.getText().toString();
                        SharedPreferencesUtils.setBittrexPreference(bittrexKey, bittrexSecret);
                        Toast.makeText(getContext(), "Bittrex key added", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        fab.setVisibility(View.GONE);
                        bittrexBackgroundText.setText("account exists.. hitting bittrex api");
                    }
                });
                dialog.show();
            }
        });

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.bittrexRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "bittrex Data updated", Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });

        return view;
    }

}
