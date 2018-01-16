package com.crypto.portfolio.cryptoportfolio.asynctask.bittrex;

import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.crypto.portfolio.cryptoportfolio.R;
import com.crypto.portfolio.cryptoportfolio.adapter.bittrex.AccountBalanceRecyclerViewAdapter;
import com.crypto.portfolio.cryptoportfolio.apiclient.BittrexClient;
import com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.account.AccountBalanceResponse;
import com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.market.MarketSummaryDTO;
import com.crypto.portfolio.cryptoportfolio.fragmentstate.BittrexState;

import java.util.Map;

public class BittrexGetAccountBalanceAsyncTask extends AsyncTask<Void, Void, AccountBalanceResponse> {

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
    protected AccountBalanceResponse doInBackground(Void... voids) {
        AccountBalanceResponse accountBalanceResponse =  bittrexClient
                .getAccountBalance(bittrexState.getBittrexKey(), bittrexState.getBittrexSecret());

        Map<String, MarketSummaryDTO> marketSummaryDTOMap = bittrexClient.getMarketSummary();
        bittrexState.setMarketSummaryMap(marketSummaryDTOMap);
        accountBalanceResponse.setResult(bittrexState.filterAndSetPrice(accountBalanceResponse.getResult()));
        bittrexState.setGetBalanceDTO(accountBalanceResponse.getResult());
        return accountBalanceResponse;
    }

    @Override
    protected void onPostExecute(AccountBalanceResponse accountBalanceResponse) {
        super.onPostExecute(accountBalanceResponse);
        String totalBTC = String.format("%.8f", bittrexState.getTotalBTC()) + " BTC";
        String usdValue = String.format("%.2f", bittrexState.getMarketSummaryMap().get("USDT-BTC").getLast() * bittrexState.getTotalBTC()) + " USD";
        ((TextView)view.findViewById(R.id.usdValue)).setText(usdValue);
        ((TextView)view.findViewById(R.id.btcValue)).setText(totalBTC);
        ((SwipeRefreshLayout)view.findViewById(R.id.bittrexRefresh)).setRefreshing(false);
        mAdapter = new AccountBalanceRecyclerViewAdapter(bittrexState.getGetBalanceDTO());
        mRecyclerView.setAdapter(mAdapter);
        view.findViewById(R.id.btcCard).setVisibility(View.VISIBLE);
    }
}