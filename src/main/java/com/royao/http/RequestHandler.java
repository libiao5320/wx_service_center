package com.royao.http;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by libia on 2015/12/29.
 */
public class RequestHandler {


    @SuppressWarnings("unused")
    public static RequestContent execute(HttpServletRequest request) {



        InputStream in;
        BufferedReader reader = null;
        String str = "";
        StringBuffer buffer = new StringBuffer();


        try {
            str = request.getQueryString();
            in = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in,"utf-8"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String input = null;
        try {
            while (!((input = reader.readLine()) == null)) {
                buffer.append(input);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        RequestContent requestContent = JSON.parseObject(buffer.toString(), RequestContent.class);
        return requestContent;
    }
}
