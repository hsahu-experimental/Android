package com.crypto.portfolio.cryptoportfolio.apiclient;

import com.crypto.portfolio.cryptoportfolio.builder.urlBuilder.BittrexURLBuilder;
import com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.BittrexResponse;
import com.crypto.portfolio.cryptoportfolio.dto.response.bittrex.GetBalanceDTO;

import java.util.HashMap;
import java.util.Map;

public class BittrexClient {

    public BittrexResponse<GetBalanceDTO> getAccountBalance(String apiKey, String apiSecret) {

        String url = BittrexURLBuilder.getAccountBalanceURL(apiKey);

        Map<String, String> headers = getHeaders(apiSecret, url);

        BittrexResponse<GetBalanceDTO> getBalanceDTOBittrexResponse = getDateFromBittrex(url, headers);

        System.out.println(getBalanceDTOBittrexResponse.toString());

        return getBalanceDTOBittrexResponse;
    }

    private <T> BittrexResponse<T> getDateFromBittrex(String url, Map<String, String> headers) {

        HTTPClient httpClient = new HTTPClient();

        BittrexResponse<T> bittrexResponse = httpClient.getResponseBody(url, headers, BittrexResponse.class);

        return bittrexResponse;
    }

    private Map<String, String> getHeaders(String apiSecret, String url) {

        Map<String, String> headers = new HashMap<>();

        String sign = APISign.sign(apiSecret, url);

        headers.put("apiSign", sign);

        return headers;
    }
}
