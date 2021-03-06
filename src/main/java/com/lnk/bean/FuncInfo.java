package com.lnk.bean;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;


public class FuncInfo {
    private String path;
    private String file;
    private String funcDefName;
    private int startLine;
    private int endLine;
    private ParseTree funcInfoTree = null; // 该函数所在行的tree
    private ArrayList<String> paramList = new ArrayList<>(); // 该函数的形参

    public FuncInfo() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFuncDefName() {
        return funcDefName;
    }

    public void setFuncDefName(String funcDefName) {
        this.funcDefName = funcDefName;
    }

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }

    public ParseTree getFuncInfoTree() {
        return funcInfoTree;
    }

    public void setFuncInfoTree(ParseTree funcInfoTree) {
        this.funcInfoTree = funcInfoTree;
    }

    public ArrayList<String> getParamList() {
        return paramList;
    }


    public void setParamList(ArrayList<String> paramList) {
        this.paramList = paramList;
    }
    @Override
    public String toString() {
        String res = "";
        res += path + ",";
        res += file + ",";
        res += funcDefName + ",";
        res += startLine + ",";
        res += endLine + ",";
        res += "\n";
        return res;
    }
}

