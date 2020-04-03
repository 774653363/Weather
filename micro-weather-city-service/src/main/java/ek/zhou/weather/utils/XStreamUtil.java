package ek.zhou.weather.utils;

import com.thoughtworks.xstream.XStream;

public class XStreamUtil {
    public static Object toBean(Class<?> clazz,String xml){
        Object xmlObject = null;
        XStream xStream = new XStream();
        xStream.processAnnotations(clazz);
        xStream.autodetectAnnotations(true);
        xmlObject = xStream.fromXML(xml);
        return xmlObject;
    }
}
