package com.lnk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lnk.bean.FileInfo;
import com.lnk.util.*;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import com.alibaba.fastjson.*;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import java.io.*;
import java.util.*;

public class Main {

    /**
     *
     * str[0]:项目根目录
     * str[1]:结果文件输出路径
     */
    public static void main(String[] args) {

        String[] str= new String[2];
        str[0]="D:\\IdeaProjects\\cpptest\\src\\main\\resources\\testCode";
        str[1]="D:\\IdeaProjects\\cpptest\\src\\main\\resources\\res\\result.csv";

        checkInput(str);
        FileInfo fileInfo = new FileInfo(str[0], str[1]);
        process(fileInfo);
    }

    /**
     *
     * @param strings 检查项目根目录是否存在
     */
    private static void checkInput(String[] strings){

        if (!new File(strings[0]).exists()){
            String tip = String.format("%s not exist!", strings[0]);
            System.out.println(tip);
            System.exit(0);
        }
    }

    /**
     * 处理过程
     * @param fileInfo   结果文件输出
     */
    private static void process(FileInfo fileInfo){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileInfo.getOutputPath()))){
            writer.write("path,file,funcName,startLine,endLine");
            writer.newLine();
            writer.flush();
            writer.close();
            List<String> filesPath = FileUtil.listAllFiles(fileInfo.getInputPath(), new String[]{"c", "cpp", ".mm", ".cc"});
            for (String file: filesPath){
                AntlrUtil.processFile(file, fileInfo);
            }
            System.out.println("Output Successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
