/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressordecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author abhijeet
 */
public class decompressor {
    public static void method(File file) throws IOException{
        String fileDirectory= file.getParent();
        FileInputStream fis= new FileInputStream(file);
        GZIPInputStream gzipIS= new GZIPInputStream(fis);
        //put the location wher you want to store your decommpred file
        FileOutputStream fos=new  FileOutputStream("E:/ac"+"/Decompressedfilecheck");
        
        byte[] buffer=new byte[1024];
        
        int len;
        
        while((len=gzipIS.read(buffer)) !=-1){
           // System.out.println("length of file"+len);
            fos.write(buffer, 0,len);     
        }
        gzipIS.close();
        fis.close();
        fos.close();     
    }
    
    public static void main(String[] args) throws IOException{
        boolean flag=true;
        //only put .gz file for decompressed otherwise you get error
        File path=new File("E:/ac/compressedfile.gz");
        if(path.exists()){
            method(path);
        }else{
            System.out.println("bhaiya sahi payh dalo");
            flag=false;
        }
        System.out.println("Task successfully completed !");

        
    }
    
    
    
    
}
