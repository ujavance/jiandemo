package com.uj.jian.test;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileAndAnalysis {

    /**
     * 读取一个文本 一行一行读取
     */
    public static List<String> readFile(String path) throws IOException {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        List<String> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        // 防止路径乱码
        // 如果utf-8 乱码  改GBK
        // eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
            if (line.lastIndexOf("---") < 0) {
                list.add(line);
            }
        }
        br.close();
        isr.close();
        fis.close();
        return list;
    }

    @Test
    public void testReadFile() throws IOException {
        // 文件夹路径
        String path = "F:\\一定要删除这个\\真的要删除这个\\哦老家\\测试读取一行文件.txt";
        List<String> fileContent = readFile(path);
        fileContent.stream().forEach(System.out::println);

    }
}
