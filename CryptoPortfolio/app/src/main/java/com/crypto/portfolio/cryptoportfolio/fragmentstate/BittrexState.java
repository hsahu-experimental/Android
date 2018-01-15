package com.crypto.portfolio.cryptoportfolio.fragmentstate;

import com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.GetBalanceDTO;
import com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.openorder.OpenOrderDTO;

import java.util.ArrayList;
import java.util.List;

public class BittrexState {

    private String bittrexKey;
    private String bittrexSecret;
    private List<GetBalanceDTO> getBalanceDTO;
    private List<OpenOrderDTO> openOrderDTO;

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

    public List<GetBalanceDTO> getGetBalanceDTO() {
        return getBalanceDTO;
    }

    public void setGetBalanceDTO(List<GetBalanceDTO> getBalanceDTO) {
        this.getBalanceDTO = getBalanceDTO;
    }

    public List<OpenOrderDTO> getOpenOrderDTO() {
        return openOrderDTO;
    }

    public void setOpenOrderDTO(List<OpenOrderDTO> openOrderDTO) {
        this.openOrderDTO = openOrderDTO;
    }

    public static List<GetBalanceDTO> filter(List<GetBalanceDTO> getBalanceDTOList) {
        List<GetBalanceDTO> filteredGetBalanceDTOList = new ArrayList<>();
        for (GetBalanceDTO getBalanceDTO : getBalanceDTOList) {
            if (getBalanceDTO.getBalance() >= 1e-8) {
                filteredGetBalanceDTOList.add(getBalanceDTO);
            }
        }
        return filteredGetBalanceDTOList;
    }

    @Override
    public String toString() {
        return "BittrexState{" +
                "bittrexKey='" + bittrexKey + '\'' +
                ", bittrexSecret='" + bittrexSecret + '\'' +
                ", getBalanceDTO=" + getBalanceDTO +
                ", openOrderDTO=" + openOrderDTO +
                '}';
    }
}
