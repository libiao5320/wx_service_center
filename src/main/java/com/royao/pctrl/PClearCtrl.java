package com.royao.pctrl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.royao.http.*;
import com.royao.model.Dclear;
import com.royao.model.Dgoods;
import com.royao.model.DsystemSet;
import com.royao.services.inface.DclearService;
import com.royao.services.inface.DkitingService;

import com.royao.services.inface.DsystemSetService;
import com.royao.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

/**
 * Created by libia on 2016/2/23.
 */

@Controller
@RequestMapping ("/clear")
public class PClearCtrl {



        @Autowired
        private DclearService dclearService;

        @Autowired
         private DkitingService kitingService;


        @Autowired
        private DsystemSetService dsystemSetService;


        @ResponseBody
        @RequestMapping ("/genClear.htm")
        public String genClear ( HttpServletRequest request , HttpServletResponse response )
        {

            ResponseContent responseContent = new ResponseContent();
            ResponseHead responseHead = new ResponseHead();
            RequestContent requestContent = RequestHandler.execute(request);

            Map params = requestContent.getBody();
            JSONObject result = new JSONObject();

            try {
                boolean falg = dclearService.addClear( params );

                result.put("flag",falg);

                responseContent = ResponseHandler.makeResponse(result, true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return JSONObject.toJSONString(responseContent);
        }


    @ResponseBody
    @RequestMapping("/storeClearTicket.htm")
    public String storeClearTicket (HttpServletRequest request,HttpServletResponse response){
        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map params = requestContent.getBody();
        JSONObject result = new JSONObject();
        Integer page = null ==  params.get("pageNo") ? 0 : Integer.valueOf(""+params.get("pageNo"));
        Integer pageSize = null ==  params.get("pageSize") ? 0 : Integer.valueOf(""+params.get("pageSize"));


        params.put("pageNo" , page );
        params.put("pageSize" , pageSize );

        if ( null != params.get("cycletime") && !"".equals(params.get("cycletime"))) {
            DsystemSet dsystemSet = dsystemSetService.queryByKey("billDay");


            try {
                Date  end  = new SimpleDateFormat("yyyy-MM-dd").parse((String) params.get("cycletime")+"-"+dsystemSet.getSvalue());

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(end);

                calendar.add(Calendar.MONTH,-1);//日期加3个月
                Date begin=calendar.getTime();


                String endStr =   new SimpleDateFormat("yyyy-MM-dd").format(end);
                String beginStr =new SimpleDateFormat("yyyy-MM-dd").format(begin);

                params.remove("cycletime");
                params.put("begin", beginStr);
                params.put("end", endStr);
//                Date  end  = new SimpleDateFormat("yyyy-MM-dd").parse((String) params.get("cycletime") + "-" + dsystemSet.getSvalue());




            } catch (ParseException e) {
                e.printStackTrace();
            }


        }

        try {

            List l = dclearService.queryClear(params);
            Integer count = dclearService.queryClearCount(params);

            result.put("rows", l);
            result.put("total", count);

            responseContent = ResponseHandler.makeResponse(result, true);

        } catch (Exception e) {
            e.printStackTrace();
        }



        return JSONObject.toJSONString(responseContent);
    }


    @ResponseBody
    @RequestMapping ("/dealClearTicket.htm")
    public String dealClearTicket (HttpServletRequest request , HttpServletResponse response)
    {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map params = requestContent.getBody();
        JSONObject result = new JSONObject();


        if ( null != params.get("clearId")) {






            try {
                Dclear dclear = dclearService.dealClear(params);


                if (null != dclear) {

                    if (null != dclear.getCycleTime() && !"".equals(dclear.getCycleTime())) {
                        DsystemSet dsystemSet = dsystemSetService.queryByKey("billDay");


                        try {
                            Date end = new SimpleDateFormat("yyyy-MM-dd").parse((String) dclear.getCycleTime() + "-" + dsystemSet.getSvalue());

                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(end);

                            calendar.add(Calendar.MONTH, -1);//日期加3个月
                            Date begin = calendar.getTime();


                            String endStr = new SimpleDateFormat("yyyy-MM-dd").format(end);
                            String beginStr = new SimpleDateFormat("yyyy-MM-dd").format(begin);




                            result.put("begin", beginStr);
                            result.put("end", endStr);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    result.put("dclear", dclear);
                    responseContent = ResponseHandler.makeResponse(result, true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




        return JSONObject.toJSONString(responseContent);
    }


    @ResponseBody
    @RequestMapping("/dealClearTicketOrderList.htm")
    public String dealClearTicketOrderList(HttpServletRequest request , HttpServletResponse response)
    {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);
        Map params = requestContent.getBody();
        JSONObject result = new JSONObject();
        Integer page = null ==  params.get("pageNo") ? 0 : Integer.valueOf(""+params.get("pageNo"));
        Integer pageSize = null ==  params.get("pageSize") ? 0 : Integer.valueOf(""+params.get("pageSize"));


        params.put("pageNo" , page );
        params.put("pageSize" , pageSize );
        try {

            List l = dclearService.queryClearOrder(params);
            Integer count = dclearService.queryClearOrderCount(params);

            result.put("rows", l);
            result.put("total", count);

            responseContent = ResponseHandler.makeResponse(result, true);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSONObject.toJSONString(responseContent);
    }


    @ResponseBody
    @RequestMapping("/saveDealClear.htm")
    public String saveDealClear(HttpServletRequest request , HttpServletResponse response) {

        ResponseContent responseContent = new ResponseContent();
        RequestContent requestContent = RequestHandler.execute(request);


        Map  params =  requestContent.getBody();

        JSONObject result = new JSONObject();
        Dclear dclear = JSON.parseObject(JsonUtil.map2json(params), Dclear.class);

        try {
            boolean flag = dclearService.saveDealClear(dclear);
            result.put("flag",flag);
            responseContent.setBody(result);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return JSONObject.toJSONString(responseContent);
    }

}
