package DesignPattern.url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MDUrlFactory {
    private static MDUrlFactory mdUrlFactory;

    private MDUrlFactory(){}

    public static MDUrlFactory getInstance(){
        if(mdUrlFactory==null)mdUrlFactory=new MDUrlFactory();
        return mdUrlFactory;
    }

    String encodeUrl(String url) throws UnsupportedEncodingException {
        String root="https://github.com/szuming/BookReading/blob/master";
        //url根部
        url=url.substring(url.indexOf("DesignPattern"));                                      //从src开始分割，包括src
        String []urls=url.split("\\\\");                                     //以\划分
        url= root;
        for(String temp:urls){
            url=url+"/"+URLEncoder.encode(temp,"UTF8");                         //对每一部分进行转义并拼接
        }
        return url;
    }
}
