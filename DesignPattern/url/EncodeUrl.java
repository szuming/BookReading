package DesignPattern.url;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class EncodeUrl {
    public static void main(String []argv) throws UnsupportedEncodingException {
        MDUrlFactory mdUrlFactory=MDUrlFactory.getInstance();
        Scanner reader=new Scanner(System.in);
        String url=reader.next();
        url=mdUrlFactory.encodeUrl(url);
    }
}
