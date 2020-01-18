package weixin.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFileUtil {

	/**
     * 下载url的文件到指定文件路径里面,如果文件父文件夹不存在则自动创建
     * url 下载的http地址
     * path 文件存储地址
     * return 如果文件大小大于2k则返回true
     */
    public static boolean downloadCreateDir(String url,String path){
        HttpURLConnection connection=null;
        InputStream in = null;
        FileOutputStream o=null;
        try{
            URL httpUrl=new URL(url);
            connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("Charset", "gbk");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestMethod("GET");
            
            byte[] data=new byte[1024];
            File f=new File(path);
            File parentDir = f.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
            if(connection.getResponseCode() == 200){
                in = connection.getInputStream();
                o=new FileOutputStream(path);
                int n=0;
                while((n=in.read(data))>0){
                    o.write(data, 0, n);
                    o.flush();
                }
            }
            if(f.length()>2048){  //代表文件大小
                return true;  //如果文件大于2k则返回true
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
            try{o.close();}catch(Exception ex){}
            try{connection.disconnect();}catch(Exception ex){}
        }
        return false;
    }
}
