package com.taskmanager.common.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HttpUtils {

    private HttpUtils() {
    }

    public static HttpHeaders headersWithContentType(MediaType mediaType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        return headers;
    }
}
