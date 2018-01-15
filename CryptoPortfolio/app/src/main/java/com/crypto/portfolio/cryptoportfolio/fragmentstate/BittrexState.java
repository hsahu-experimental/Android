package com.crypto.portfolio.cryptoportfolio.fragmentstate;

import com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.GetBalanceDTO;

public class BittrexState {

    private String bittrexKey;
    private String bittrexSecret;
    private GetBalanceDTO getBalanceDTO;

    public BittrexState() {
        super();
    }

    public String getBittrexKey() {
        return bittrexKey;
    }

    public void setBittrexKey(String bittrexKey) {
        this.bittrexKey = bittrexKey;
    }

    public String getBittrexSecret() {
        return bittrexSecret;
    }

    public void setBittrexSecret(String bittrexSecret) {
        this.bittrexSecret = bittrexSecret;
    }

    public GetBalanceDTO getGetBalanceDTO() {
        return getBalanceDTO;
    }

    public void setGetBalanceDTO(GetBalanceDTO getBalanceDTO) {
        this.getBalanceDTO = getBalanceDTO;
    }

    @Override
    public String toString() {
        return "BittrexState{" +
                "bittrexKey='" + bittrexKey + '\'' +
                ", bittrexSecret='" + bittrexSecret + '\'' +
                ", getBalanceDTO=" + getBalanceDTO +
                '}';
    }
}
