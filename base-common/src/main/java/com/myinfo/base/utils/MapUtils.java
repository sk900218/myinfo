package com.myinfo.base.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Map工具类
 * @author 盛凯 2020-12-24
 */
public class MapUtils {

    /**
     * 对象转map
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null)
            return null;

        Map<String, Object> map = new HashMap<String, Object>();

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null ? getter.invoke(obj) : null;
            map.put(key, value);
        }

        return map;
    }

    /**
     * 对象转MultiValueMap
     * @param obj
     * @return
     */
    public static MultiValueMap objToMultiValueMap(Object obj) {
        try {
            Map map = BeanUtils.describe(obj);

            MultiValueMap params = new LinkedMultiValueMap<>();

            map.forEach((name, values) -> {
                if(!StringUtils.isEmpty(values)) {
                    params.add(name, values);
                }
            });

            return params;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
