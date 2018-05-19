package DesignPattern.StructerPattern.DecoratorPattern.IO;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputSteam extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    public LowerCaseInputSteam(InputStream in) {
        super(in);
    }

    public int read() throws IOException{
        int c=super.read();                                     //调用父类的read()方法
        return (c==-1?c:Character.toLowerCase((char)c));        //当没读到末尾则将其转为小写
    }

    public int read(byte[]b,int offset,int len)throws IOException{
        int result=super.read(b,offset,len);
        for(int i=offset;i<offset+result;i++){
            b[i]=(byte)Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
