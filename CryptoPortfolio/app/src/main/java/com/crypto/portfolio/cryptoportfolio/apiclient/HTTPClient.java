package com.crypto.portfolio.cryptoportfolio.apiclient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class HTTPClient {

    public <T> T getResponseBody(String urlString, Map<String, String> headers, Class<T> type) {

        T tObject = null;

        try {
            // create url
            URL url = new URL(urlString);
            // open connection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // set methods
            httpURLConnection.setRequestMethod("GET");
            // set headers
            if (headers != null && !headers.isEmpty()) {
                for (String headerName: headers.keySet()) {
                    httpURLConnection.setRequestProperty(headerName, headers.get(headerName));
                }
            }

            // get the response body as string from input stream
            String responseBody = readDataFromInputStream(httpURLConnection);

            // convert to java object
            Gson gson = new Gson();
            tObject = gson.fromJson(responseBody, type);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return tObject;
    }

    private String readDataFromInputStream(HttpURLConnection httpURLConnection) {

        String result = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer resultBuffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                resultBuffer.append(line);
            }
            result = resultBuffer.toString();
        } catch (IOException e) {
            // e.printStackTrace();
        }
        return result;
    }
}
