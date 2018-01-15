package com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.openorder;

import java.util.List;

public class OpenOrderResponse {

    private Boolean success;
    private String message;
    private List<OpenOrderDTO> result;

    public OpenOrderResponse() {
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

    public List<OpenOrderDTO> getResult() {
        return result;
    }

    public void setResult(List<OpenOrderDTO> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "OpenOrderResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
