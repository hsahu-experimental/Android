package com.crypto.portfolio.cryptoportfolio.apiclient;

import com.crypto.portfolio.cryptoportfolio.builder.urlBuilder.BittrexURLBuilder;
import com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.BittrexResponse;
import com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.openorder.OpenOrderResponse;

import java.util.HashMap;
import java.util.Map;

public class BittrexClient {

    public BittrexResponse getAccountBalance(String apiKey, String apiSecret) {

        String url = BittrexURLBuilder.getAccountBalanceURL(apiKey);

        Map<String, String> headers = getHeaders(apiSecret, url);

        BittrexResponse getBalanceDTOBittrexResponse = getDataFromBittrex(url, headers, BittrexResponse.class);

        return getBalanceDTOBittrexResponse;
    }

    public OpenOrderResponse getOpenOrders(String apiKey, String apiSecret) {

        String url = BittrexURLBuilder.getOpenOrderURL(apiKey);

        Map<String, String> headers = getHeaders(apiSecret, url);

        OpenOrderResponse openOrderResponse = getDataFromBittrex(url, headers, OpenOrderResponse.class);

        System.out.println(openOrderResponse.toString());

        return openOrderResponse;
    }

    private <T> T getDataFromBittrex(String url, Map<String, String> headers, Class<T> type) {

        HTTPClient httpClient = new HTTPClient();

        T tObject = httpClient.getResponseBody(url, headers, type);

        return tObject;
    }

    private Map<String, String> getHeaders(String apiSecret, String url) {

        Map<String, String> headers = new HashMap<>();

        String sign = APISign.sign(apiSecret, url);

        headers.put("apiSign", sign);

        return headers;
    }
}
