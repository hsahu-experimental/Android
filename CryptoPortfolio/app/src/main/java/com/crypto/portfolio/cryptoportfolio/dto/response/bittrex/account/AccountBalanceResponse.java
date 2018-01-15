package com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.account;

import java.util.List;

public class AccountBalanceResponse {

    private Boolean success;
    private String message;
    private List<GetBalanceDTO> result;

    public AccountBalanceResponse() {
        super();
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GetBalanceDTO> getResult() {
        return result;
    }

    public void setResult(List<GetBalanceDTO> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AccountBalanceResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
