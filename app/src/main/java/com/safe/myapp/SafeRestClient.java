package com.safe.myapp;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import cz.msebera.android.httpclient.entity.StringEntity;


public class SafeRestClient {
    private static final String BASE_URL = SafeService.HTTP_SERVER;
    private static final int TIMEOUT = 30 * 1000;

    private static SyncHttpClient httpClient = new SyncHttpClient(SafeService.HTTP_PORT);

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        httpClient.setTimeout(TIMEOUT);
        httpClient.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        httpClient.setTimeout(TIMEOUT);
        httpClient.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void postJson(String url, Context context, StringEntity entity, AsyncHttpResponseHandler responseHandler){
        httpClient.post(context, getAbsoluteUrl(url), entity, "application/json", responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}