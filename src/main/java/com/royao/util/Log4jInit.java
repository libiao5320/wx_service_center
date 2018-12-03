package com.royao.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by vixuan-006 on 14-7-13.
 */
public class Log4jInit extends HttpServlet {


    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(Log4jInit.class);

    public void init() {
        String path = this.getServletContext().getRealPath("/");
        String file = this.getInitParameter("log4j_init_path");
        String logFile = this.getInitParameter("log4j_file_path");
        if (file != null) {
            Properties prop = new Properties();
            try {
                prop.load(new FileInputStream(path + file)); //加载log4j.properties
                prop.setProperty("log4j.appender.R.File", path + logFile + prop.getProperty("log4j.appender.R.File")); //设置日志文件的输出路径

                PropertyConfigurator.configure(prop); //加载配置项
            } catch (Exception e) {
                logger.info("初始化log4j日志输入路径异常，请检查web.xml参数配置是否正常，异常发生在" + this.getClass().getName() + "类的public void init()方法，异常的愿意是：" + e.getMessage(), e.fillInStackTrace());
            }
        }


    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
