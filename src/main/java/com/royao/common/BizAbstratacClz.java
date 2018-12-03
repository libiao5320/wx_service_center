package com.royao.common;

import com.royao.util.Config;
import com.royao.util.PropertiesReader;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

/**
 * Created by libia on 2016/1/3.
 */
public abstract class BizAbstratacClz implements BizInterface {


    private static final String _BZDECLAREPROPERTIESFILE_ = "";
    protected static Properties properties = null;


    static {

        try {
            properties = PropertiesReader.getProperties(_BZDECLAREPROPERTIESFILE_);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


}
