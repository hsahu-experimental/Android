package com.crypto.portfolio.cryptoportfolio.dto.response.bittrex;

public class GetBalanceDTO {

    private String Currency;
    private Double Balance;
    private Double Available;
    private Double Pending;
    private String CryptoAddress;

    public GetBalanceDTO() {
        super();
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }

    public Double getAvailable() {
        return Available;
    }

    public void setAvailable(Double available) {
        Available = available;
    }

    public Double getPending() {
        return Pending;
    }

    public void setPending(Double pending) {
        Pending = pending;
    }

    public String getCryptoAddress() {
        return CryptoAddress;
    }

    public void setCryptoAddress(String cryptoAddress) {
        CryptoAddress = cryptoAddress;
    }

    @Override
    public String toString() {
        return "GetBalanceDTO{" +
                "Currency='" + Currency + '\'' +
                ", Balance=" + Balance +
                ", Available=" + Available +
                ", Pending=" + Pending +
                ", CryptoAddress='" + CryptoAddress + '\'' +
                '}';
    }
}