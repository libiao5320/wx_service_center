package com.royao.http;


import com.alibaba.fastjson.JSON;
import com.royao.common.BizInterface;
import com.royao.model.ApiResult;
import com.royao.util.ApiException;
import com.royao.util.DateUtil;
import com.royao.util.Validate;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by libia on 2015/12/29.
 */
public class HttpHandler {


    private String serviceId;
    private String auth;  // 验证
    private Logger logger = Logger.getLogger(HttpHandler.class);


    private BizInterface bizInterface;

    public BizInterface getBizInterface() {
        return bizInterface;
    }

    public void setBizInterface(BizInterface bizInterface) {
        this.bizInterface = bizInterface;
    }

    private static final String SUCCESS = "SUCCESS"; // 接口请求成功

    private static final String INVALID_REQUEST = "INVALID_REQUEST"; // 无效的接口请求

    public ResponseContent execute(String parameter, HttpServletRequest request) {
        ResponseContent responseContent = new ResponseContent();
        ResponseHead responseHead = new ResponseHead();
        responseHead.setResultCode(SUCCESS);
        responseHead.setDescription("请求成功");
        try {
            if (Validate.isEmpty(parameter)) {
                throw new ApiException(INVALID_REQUEST, "无效请求");
            }
            RequestContent requestContent = JSON.parseObject(parameter, RequestContent.class);
            RequestHead head = requestContent.getHead();
            if (head == null) {
                throw new ApiException(INVALID_REQUEST, "无效请求");
            }
            String transactionId = head.getTransactionId();
            responseHead.setTransactionId(transactionId);
            responseHead.setResponseTime(DateUtil.format("yyyyMMddHHmmss", DateUtil.current()));
            ApiResult responseBody = null;
            if (responseBody != null && responseBody.isSuccess()) {
                responseContent.setBody(responseBody.getResultBody());
            } else {
                throw new ApiException(responseBody.getResultCode(), responseBody.getDescription());
            }
        } catch (ApiException e) {
            responseHead.setResultCode(e.getCode());
            responseHead.setDescription(e.getMessage());
        } catch (Exception e) {
            logger.error(INVALID_REQUEST, e);
            responseHead.setResultCode(INVALID_REQUEST);
            responseHead.setDescription("无效请求");
        }
        // 输出到结果页面
        responseContent.setHead(responseHead);

        return responseContent;
    }
}
