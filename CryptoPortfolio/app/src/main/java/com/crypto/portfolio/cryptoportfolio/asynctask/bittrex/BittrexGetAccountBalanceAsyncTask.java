package com.crypto.portfolio.cryptoportfolio.asynctask.bittrex;

import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.crypto.portfolio.cryptoportfolio.R;
import com.crypto.portfolio.cryptoportfolio.adapter.bittrex.AccountBalanceRecyclerViewAdapter;
import com.crypto.portfolio.cryptoportfolio.apiclient.BittrexClient;
import com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.BittrexResponse;
import com.crypto.portfolio.cryptoportfolio.fragmentstate.BittrexState;

public class BittrexGetAccountBalanceAsyncTask extends AsyncTask<Void, Void, BittrexResponse> {

    private View view;
    private BittrexClient bittrexClient;
    private BittrexState bittrexState;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    public BittrexGetAccountBalanceAsyncTask(View view, BittrexClient bittrexClient, BittrexState bittrexState, RecyclerView mRecyclerView, RecyclerView.Adapter mAdapter) {
        this.view = view;
        this.bittrexClient = bittrexClient;
        this.bittrexState = bittrexState;
        this.mAdapter = mAdapter;
        this.mRecyclerView = mRecyclerView;
    }

    @Override
    protected BittrexResponse doInBackground(Void... voids) {
        BittrexResponse bittrexResponse =  bittrexClient
                .getAccountBalance(bittrexState.getBittrexKey(), bittrexState.getBittrexSecret());
        bittrexResponse.setResult(BittrexState.filter(bittrexResponse.getResult()));
        bittrexState.setGetBalanceDTO(bittrexResponse.getResult());
        return bittrexResponse;
    }

    @Override
    protected void onPostExecute(BittrexResponse bittrexResponse) {
        super.onPostExecute(bittrexResponse);
        ((TextView)view.findViewById(R.id.bittrexBackgroundText)).setText(bittrexResponse.toString());
        ((SwipeRefreshLayout)view.findViewById(R.id.bittrexRefresh)).setRefreshing(false);
        mAdapter = new AccountBalanceRecyclerViewAdapter(bittrexState.getGetBalanceDTO());
        mRecyclerView.setAdapter(mAdapter);
    }
}