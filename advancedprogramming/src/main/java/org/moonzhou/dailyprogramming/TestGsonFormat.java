package org.moonzhou.dailyprogramming;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * test plugin: GsonFormatPlus
 *
 * install:
 * Using IDE built-in plugin system on Windows:
 * File > Settings > Plugins > Browse repositories... > Search for "GsonFormatPlus" > Install Plugin
 * Using IDE built-in plugin system on MacOs:
 * Preferences > Settings > Plugins > Browse repositories... > Search for "GsonFormatPlus" > Install Plugin
 *
 * using:
 * Code -- Generate -- GsonFormatPlus
 * short cut: control + n -- GsonFormatPlus
 * short cut: option + s
 *
 * notice: SETTINGS(can not set CamelCase)
 *
 * demo data:
 * {"date":"20180507","message":"Success !","status":200,"city":"广州","count":1642,"data":{"shidu":"86%","pm25":14.0,"pm10":24.0,"quality":"优","wendu":"26","ganmao":"各类人群可自由活动","yesterday":{"date":"06日星期日","sunrise":"05:52","high":"高温 30.0℃","low":"低温 24.0℃","sunset":"18:56","aqi":44.0,"fx":"无持续风向","fl":"<3级","type":"雷阵雨","notice":"带好雨具，别在树下躲雨"},"forecast":[{"date":"07日星期一","sunrise":"05:51","high":"高温 27.0℃","low":"低温 21.0℃","sunset":"18:57","aqi":43.0,"fx":"无持续风向","fl":"<3级","type":"大到暴雨","notice":"雨势转大，在外找好避雨处"},{"date":"08日星期二","sunrise":"05:51","high":"高温 26.0℃","low":"低温 21.0℃","sunset":"18:57","aqi":49.0,"fx":"无持续风向","fl":"<3级","type":"大到暴雨","notice":"雨势转大，在外找好避雨处"},{"date":"09日星期三","sunrise":"05:50","high":"高温 25.0℃","low":"低温 21.0℃","sunset":"18:58","aqi":57.0,"fx":"无持续风向","fl":"<3级","type":"中雨","notice":"记得随身携带雨伞哦"},{"date":"10日星期四","sunrise":"05:49","high":"高温 26.0℃","low":"低温 21.0℃","sunset":"18:58","aqi":53.0,"fx":"东南风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"11日星期五","sunrise":"05:49","high":"高温 28.0℃","low":"低温 22.0℃","sunset":"18:59","aqi":45.0,"fx":"东风","fl":"3-4级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"}]}}
 *
 * @author moon zhou
 */
@NoArgsConstructor
@Data
public class TestGsonFormat {


    private String date;
    private String message;
    private Integer status;
    private String city;
    private Integer count;
    private Data data;

    @NoArgsConstructor
    @lombok.Data
    public static class Data {
        private String shidu;
        private Integer pm25;
        private Integer pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private Yesterday yesterday;
        private List<Yesterday> forecast;

        @NoArgsConstructor
        @lombok.Data
        public static class Yesterday {
            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private Integer aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;
        }
    }
}
