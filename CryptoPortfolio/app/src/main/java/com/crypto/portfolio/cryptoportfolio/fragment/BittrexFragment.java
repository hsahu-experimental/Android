package com.crypto.portfolio.cryptoportfolio.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.crypto.portfolio.cryptoportfolio.R;
import com.crypto.portfolio.cryptoportfolio.apiclient.BittrexClient;
import com.crypto.portfolio.cryptoportfolio.asynctask.bittrex.BittrexGetAccountBalanceAsyncTask;
import com.crypto.portfolio.cryptoportfolio.asynctask.bittrex.BittrexGetOpenOrderAsyncTask;
import com.crypto.portfolio.cryptoportfolio.fragmentstate.BittrexState;
import com.crypto.portfolio.cryptoportfolio.utils.SharedPreferencesUtils;

public class BittrexFragment extends Fragment {

    BittrexState bittrexState = new BittrexState();
    BittrexClient bittrexClient = new BittrexClient();

    /**
     * render add bittrex account layout
     * @param inflater
     * @param container
     * @return
     */
    private View inflateAddBittrexAccountFragment(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.fragment_bittrex, container, false);

        final FloatingActionButton fab = view.findViewById(R.id.addBittrexKey);

        final TextView bittrexBackgroundText = view.findViewById(R.id.bittrexBackgroundText);

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
                        bittrexState.setBittrexKey(bittrex_key.getText().toString());
                        bittrexState.setBittrexSecret(bittrex_secret.getText().toString());
                        SharedPreferencesUtils.setBittrexPreference(bittrexState.getBittrexKey(), bittrexState.getBittrexSecret());
                        Toast.makeText(getContext(), "Bittrex key added", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        fab.setVisibility(View.GONE);
                        bittrexBackgroundText.setText("account exists.. hitting bittrex api");
                    }
                });
                dialog.show();
            }
        });

        return view;
    }


    RecyclerView mGetAccountBalanceRecyclerView;
    RecyclerView.LayoutManager mGetAccountBalanceLayoutManager;
    RecyclerView.Adapter mGetAccountBalanceAdapter;

    RecyclerView mGetOpenOrderRecyclerView;
    RecyclerView.LayoutManager mGetOpenOrderLayoutManager;
    RecyclerView.Adapter mGetOpenOrderAdapter;
    SwipeRefreshLayout swipeRefreshLayout;

    private void onRefesh(View view){
        swipeRefreshLayout.setRefreshing(true);
        new BittrexGetAccountBalanceAsyncTask(view, bittrexClient, bittrexState, mGetAccountBalanceRecyclerView, mGetAccountBalanceAdapter).execute();
        new BittrexGetOpenOrderAsyncTask(view, bittrexClient, bittrexState, mGetOpenOrderRecyclerView, mGetOpenOrderAdapter).execute();
    }

    /**
     * render bittrex account balance layout
     * @param inflater
     * @param container
     * @return
     */
    private View inflateBittrexAccountBalanceFragment(LayoutInflater inflater, ViewGroup container) {

        final View view = inflater.inflate(R.layout.bittrex_account_info_layout, container, false);

        mGetAccountBalanceRecyclerView = view.findViewById(R.id.bittrexGetAccountBalanceRecyclerView);
        mGetAccountBalanceLayoutManager = new LinearLayoutManager(getActivity());
        mGetAccountBalanceRecyclerView.setLayoutManager(mGetAccountBalanceLayoutManager);

        swipeRefreshLayout = view.findViewById(R.id.bittrexRefresh);
        mGetOpenOrderRecyclerView = view.findViewById(R.id.bittrexGetOpenOrderRecyclerView);
        mGetOpenOrderLayoutManager = new LinearLayoutManager(getActivity());
        mGetOpenOrderRecyclerView.setLayoutManager(mGetOpenOrderLayoutManager);

        onRefesh(view);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onRefesh(view);
            }
        });

        return view;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bittrexState.setBittrexKey(SharedPreferencesUtils.get(SharedPreferencesUtils.BITTREX_KEY_NAME, getContext()));
        bittrexState.setBittrexSecret(SharedPreferencesUtils.get(SharedPreferencesUtils.BITTREX_SECRET_NAME, getContext()));

        if (bittrexState.getBittrexKey() != null && bittrexState.getBittrexSecret() != null) {
            return inflateBittrexAccountBalanceFragment(inflater, container);
        } else {
            return inflateAddBittrexAccountFragment(inflater,container);
        }
    }
}
