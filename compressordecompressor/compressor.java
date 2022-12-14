/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressordecompressor;

import GUI.*;
import java.lang.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author abhijeet
 */
public class compressor {
    public static void method(File file) throws IOException{

        String filedirectory= file.getParent();
        System.out.println(filedirectory);
        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos=new FileOutputStream("E:/ac"+"/Compressedfile.gz");
        GZIPOutputStream gzipOS=new GZIPOutputStream(fos);
        
        byte[] buffer =new byte[1024];
        int len;
        
        while((len=fis.read(buffer)) != -1){
            gzipOS.write(buffer,0,len);
        }
        gzipOS.close();
        fos.close();
        fis.close();
        
    }
    public static void main(String[] args) throws IOException{
        File path=new File("C:/Users/maury/Desktop/Rahul's Resume-1.pdf");
        if(path.exists()){
            System.out.println(path);
            method(path);
        }else{
            System.out.println("path doesnot exists");
        }
        
    }
    
}
