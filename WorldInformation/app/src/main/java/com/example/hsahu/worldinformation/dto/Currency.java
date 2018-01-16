package com.example.hsahu.worldinformation.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Currency implements Serializable {

    @SerializedName("code")
    private String code;

    @SerializedName("name")
    private String name;

    @SerializedName("symbol")
    private String symbol;

    public Currency() {
        super();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Currency(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
