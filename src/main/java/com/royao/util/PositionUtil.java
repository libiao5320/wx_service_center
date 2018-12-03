package com.royao.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015-04-08.
 */
public class PositionUtil {


        public static Map getAround(double lat, double lon, int raidus) {

            Double latitude = lat;
            Double longitude = lon;

            Double degree = (24901 * 1609) / 360.0;
            double raidusMile = raidus;

            Double dpmLat = 1 / degree;
            Double radiusLat = dpmLat * raidusMile;
            Double minLat = latitude - radiusLat;
            Double maxLat = latitude + radiusLat;

            Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
            Double dpmLng = 1 / mpdLng;
            Double radiusLng = dpmLng * raidusMile;
            Double minLng = longitude - radiusLng;
            Double maxLng = longitude + radiusLng;

            Map result   = new HashMap();
            result.put("minLat",minLat);
            result.put("minLng",minLng);
            result.put("maxLat",maxLat);
            result.put("maxLng",maxLng);
            result.put("lat",lat);
            result.put("lon",lon);

            return result;
        }
}
