package com.simply.zuozuo.util;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.awt.print.Book;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Created by 谭健 on 2018/6/14 0014. 星期四. 11:48.
 * © All Rights Reserved.
 */
public class XmlUtils {


    private static ArrayList<Book> bookList = new ArrayList<Book>();
    /**
     * @param args
     */
    public static void main(String[] args) {

        String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

        // 解析books.xml文件
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        try {
            // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
            File file = new File("src/res/books.xml");
            Document document = DocumentHelper.parseText(xml);
            // 通过document对象获取根节点bookstore
            Element bookStore = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Iterator it = bookStore.elementIterator();
            // 遍历迭代器，获取根节点中的信息（书籍）
            while (it.hasNext()) {
                Element book = (Element) it.next();
                // 获取book的属性名以及 属性值
                List<Attribute> bookAttrs = book.attributes();

                if (bookAttrs.size() == 0){
                    System.out.println(book.getStringValue());
                }

                for (Attribute attr : bookAttrs) {
                    System.out.println("属性名：" + attr.getName() + "--属性值："
                            + attr.getValue());
                }
                Iterator itt = book.elementIterator();
                while (itt.hasNext()) {
                    Element bookChild = (Element) itt.next();
                    System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        // <xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>
    }


}
