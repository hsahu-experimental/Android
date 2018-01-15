package com.crypto.portfolio.cryptoportfolio.fragmentstate;

import com.crypto.portfolio.cryptoportfolio.dto.response.binance.GetBalanceDTO;

public class BinanceState {

    private String binanceKey;
    private String binanceSecret;
    private GetBalanceDTO getBalanceDTO;

    public BinanceState() {
        super();
    }

    public String getBinanceKey() {
        return binanceKey;
    }

    public void setBinanceKey(String binanceKey) {
        this.binanceKey = binanceKey;
    }

    public String getBinanceSecret() {
        return binanceSecret;
    }

    public void setBinanceSecret(String binanceSecret) {
        this.binanceSecret = binanceSecret;
    }

    public GetBalanceDTO getGetBalanceDTO() {
        return getBalanceDTO;
    }

    public void setGetBalanceDTO(GetBalanceDTO getBalanceDTO) {
        this.getBalanceDTO = getBalanceDTO;
    }

    @Override
    public String toString() {
        return "BinanceState{" +
                "binanceKey='" + binanceKey + '\'' +
                ", binanceSecret='" + binanceSecret + '\'' +
                ", getBalanceDTO=" + getBalanceDTO +
                '}';
    }
}
