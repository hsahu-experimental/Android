package com.crypto.portfolio.cryptoportfolio.apiclient;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class HTTPClient {

    public <T> T getResponseBody(String urlString, Map<String, String> headers, Class<T> type) {

        String responseBody = null;
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
            responseBody = readDataFromInputStream(httpURLConnection);
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (ProtocolException pe) {
            pe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Gson gson = new Gson();
        T tObject = gson.fromJson(responseBody, type);
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
            e.printStackTrace();
        }
        return result;
    }
}
