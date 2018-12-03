package com.royao.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * xml操作类
 *
 * @param <T>
 * @author Administrator
 */
public class XmlUtil<T> {

    private Document doc = null;

    /**
     * 解析给定的xml字符串，把xml字符串中的内容填充到对应的对象中，并且列表的形式返回
     *
     * @param clazz   返回对象的类型
     * @param xml     xml字符串
     * @param element 要解析的根节点
     * @return 返回封装对象的列表
     * @throws DocumentException
     * @throws IllegalArgumentException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public List<T> parseXmltoList(Class<T> clazz, String xml, String element) throws DocumentException,
            IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<T> result = new ArrayList<T>();
        doc = DocumentHelper.parseText(xml);
        Element rootElt = doc.getRootElement();
        Iterator<Element> iter = rootElt.elementIterator(element);

        while (iter.hasNext()) {
            Element childElement = iter.next();
            Iterator<Element> childIterator = childElement.elementIterator();
            result.add(toBean(clazz, childIterator));
        }
        return result;
    }

    /**
     * 解析xml字符串返回给定的对象类型
     *
     * @param clazz 对象类型
     * @param iter  元素的迭代器
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    protected T toBean(Class<T> clazz, Iterator<Element> iter) throws InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        T bean = clazz.newInstance();
        while (iter.hasNext()) {
            Element secondChildElement = iter.next();

            if (secondChildElement.nodeCount() > 1) {
                toBean(clazz, iter);
            } else {
                fullMethod(clazz, secondChildElement, bean);
            }
        }

        return bean;
    }

    /**
     * 对象填充方法
     *
     * @param clazz
     * @param element
     * @param bean
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private void fullMethod(Class<?> clazz, Element element, Object bean)
            throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        String setter = "set" + element.getName().toLowerCase();
        Method[] method = clazz.getMethods();
        if (null == method) {
            throw new IllegalArgumentException("The method is null");
        }

        for (int i = 0; i < method.length; i++) {
            if (setter.equals(method[i].getName().toLowerCase())) {
                method[i].invoke(bean, element.getTextTrim());
            }
        }
    }

}
