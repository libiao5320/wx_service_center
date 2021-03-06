package com.royao.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.royao.model.base.BaseEntity;
import com.royao.util.DateUtil;

import java.util.List;

/**
 * Created by libia on 2016/1/4.
 */
public class ResponseHandler {

    private static final String SUCCESSCODE = "200";
    private static final String FAILCODE = "500";


    private static final String SUCCESS = "SUCCESS"; // 接口请求成功

    private static final String INVALID_REQUEST = "INVALID_REQUEST"; // 无效的接口请求

    public static ResponseContent makeResponse(Object result, boolean flag) throws Exception {

        ResponseContent responseContent = new ResponseContent();
        ResponseHead responseHead = new ResponseHead();

        JSON json = null;


        StringBuffer stringBuffer = new StringBuffer();

        SerializerFeature feature =  SerializerFeature.DisableCircularReferenceDetect;
        SerializerFeature writeDateUseDateFormat =  SerializerFeature.WriteDateUseDateFormat;





        if (result instanceof List) {
//            new StringBuffer(new String (JSON.toJSONBytes(result,feature))).toString());
//            json  = JSON.parseObject(new StringBuffer(new String (JSON.toJSONBytes(result,feature))).toString());
//            json = toJSON(result);

            json  = JSONArray.parseArray(new StringBuffer(new String (JSONArray.toJSONStringWithDateFormat(result,"yyyy-MM-dd hh:mm:ss",feature,writeDateUseDateFormat))).toString());
        } else if (result instanceof BaseEntity) {
//            json = JSON.parseObject(new StringBuffer(new String (JSON.toJSONBytes(result,feature))).toString());
            json  = JSON.parseObject(new StringBuffer(new String (JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd hh:mm:ss", feature,writeDateUseDateFormat))).toString());
        } else if(result instanceof String || result instanceof Boolean || result instanceof Integer || result instanceof Double || result instanceof Float || result instanceof Long) {
        	String jsonStr = "{result:"+result+"}";
        	json =  JSONObject.parseObject(jsonStr);
        } else {
//        	json =  JSON.parseObject(new StringBuffer(new String (JSON.toJSONBytes(result,feature))).toString());
            json  = JSON.parseObject(new StringBuffer(new String (JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd hh:mm:ss",feature,writeDateUseDateFormat))).toString());
        }
//        if(result instanceof String || result instanceof Boolean || result instanceof Integer || result instanceof Double || result instanceof Float || result instanceof Long) {
//        	String jsonStr = "{result:"+result+"}";
//        	json =  JSONObject.parseObject(jsonStr);
//        }
//        else {
//            json = toJSON(result);
//        }

//        if (result != null) {
            responseContent.setBody(json);
//        } else {
//            throw new Exception("接口返回报错");
//        }

        if (flag) {
            responseHead.setResultCode(SUCCESSCODE);
            responseHead.setDescription(SUCCESS);
        } else {
            responseHead.setResultCode(FAILCODE);
            responseHead.setDescription(INVALID_REQUEST);
        }
        responseHead.setResponseTime(DateUtil.format("yyyyMMddHHmmss", DateUtil.current()));
        responseContent.setHead(responseHead);

        return responseContent;

    }


    public static  JSONObject toJSON(Object javaObject) {

        SerializeWriter out = new SerializeWriter();
        String jsonStr;
        try {
            JSONSerializer serializer = new JSONSerializer(out);

            for (com.alibaba.fastjson.serializer.SerializerFeature feature : CONFIG) {
                serializer.config(feature, true);
            }
//            serializer.config(SerializerFeature.WriteEnumUsingToString, false);
//            serializer.config(SerializerFeature.DisableCircularReferenceDetect, true);
            serializer.write(javaObject);

            jsonStr =  out.toString();
        } finally {
            out.close();
        }
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        return jsonObject;
    }


    private static  final SerializerFeature[] CONFIG = new SerializerFeature[]{
            SerializerFeature.WriteNullBooleanAsFalse,//boolean为null时输出false
            SerializerFeature.WriteMapNullValue, //输出空置的字段
            SerializerFeature.WriteNonStringKeyAsString,//如果key不为String 则转换为String 比如Map的key为Integer
            SerializerFeature.WriteNullListAsEmpty,//list为null时输出[]
            SerializerFeature.WriteNullNumberAsZero,//number为null时输出0
            SerializerFeature.WriteNullStringAsEmpty,//String为null时输出""
//            SerializerFeature.DisableCircularReferenceDetect
    };
}
