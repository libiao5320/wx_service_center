package com.royao.common;

import com.royao.util.XmlUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * Created by libia on 2016/1/3.
 */
public class BizHandler extends BizAbstratacClz {


    private String xmlFile = "";
    Logger logger = Logger.getLogger(BizHandler.class);

    public Object execute(Map params) throws Exception {
        Properties properties = this.properties;
        String bizCode;
        if (null != params.get("bizCode"))
            bizCode = (String) params.get("bizCode");
        else {
            logger.error("");
            throw new Exception("The bizCode  is Null !!!");
        }


        String xmlText = null;
        StringBuffer buffer = new StringBuffer("");

        InputStream in = null;


        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(xmlFile));

        Node root = document.getRootElement();


        Node target = root.selectSingleNode("//*[@" + bizCode + "]");

        Node clzNode = target.selectSingleNode("bean");
        Node medNode = target.selectSingleNode("method");


//        try {
//             in = new FileInputStream(new File(xmlFile));
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//
//
//            while (bufferedReader.readLine() != null) {
//                buffer.append(bufferedReader.readLine());
//            }
//            xmlText = buffer.toString();
//        }
//        catch (Exception ex)
//        {
//            logger.error("",ex);
//            throw  ex;
//        }
//
//        finally {
//            in.close();
//            in = null;
//        }
//
//        List nodeList = new XmlUtil<>().parseXmltoList( xmlText,"biz");


        return null;
    }
}
