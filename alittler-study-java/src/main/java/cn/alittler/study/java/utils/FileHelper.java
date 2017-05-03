package cn.alittler.study.java.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * @description: 文件操作的辅助类
 * @date: Created on 2017年4月17日
 * @author: Mr.LiuDC
 * @email: 1911939348@qq.com
 */
public class FileHelper {
 
	/**  
     * 删除文件，可以是单个文件或文件夹  
     * @param   fileName    待删除的文件名  
     * @return 文件删除成功返回true,否则返回false  
     */  
    public static boolean delete(String fileName){   
        File file = new File(fileName);   
        if(!file.exists()){   
            return false;   
        }else{   
            if(file.isFile()){   
                return deleteFile(fileName);   
            }else{   
                return deleteDirectory(fileName);   
            }   
        }   
    }   
       
    /**  
     * 删除单个文件  
     * @param   fileName    被删除文件的文件名  
     * @return 单个文件删除成功返回true,否则返回false  
     */  
    public static boolean deleteFile(String fileName){   
        File file = new File(fileName);   
        if(file.isFile() && file.exists()){   
            file.delete();   
            return true;   
        }else{   
            return false;   
        }   
    }   
       
    /**  
     * 删除目录（文件夹）以及目录下的文件  
     * @param   dir 被删除目录的文件路径  
     * @return  目录删除成功返回true,否则返回false  
     */  
    public static boolean deleteDirectory(String dir){   
        //如果dir不以文件分隔符结尾，自动添加文件分隔符   
        if(!dir.endsWith(File.separator)){   
            dir = dir+File.separator;   
        }   
        File dirFile = new File(dir);   
        //如果dir对应的文件不存在，或者不是一个目录，则退出   
        if(!dirFile.exists() || !dirFile.isDirectory()){   
            return false;   
        }   
        boolean flag = true;   
        //删除文件夹下的所有文件(包括子目录)   
        File[] files = dirFile.listFiles();   
        for(int i=0;i<files.length;i++){   
            //删除子文件   
            if(files[i].isFile()){   
                flag = deleteFile(files[i].getAbsolutePath());   
                if(!flag){   
                    break;   
                }   
            }   
            //删除子目录   
            else{   
                flag = deleteDirectory(files[i].getAbsolutePath());   
                if(!flag){   
                    break;   
                }   
            }   
        }   
           
        if(!flag){   
            return false;   
        }   
           
        //删除当前目录   
        if(dirFile.delete()){   
            return true;   
        }else{   
            return false;   
        }   
    }
    
    /**
     * 如果此文件不存在则创建信息，否则重新删除再添加
     * @param file 文件对象
     */
    public static void resetFile(String filePath) throws IOException{
    	resetFile(new File(filePath));
    }
    
    
    /**
     * 如果此文件不存在则创建信息，否则重新删除再添加
     * @param file 文件对象
     */
    public static void resetDir(String filePath) throws IOException{
    	resetDir(new File(filePath));
    }
    
    
    /**
     * 如果此文件不存在则创建信息，否则重新删除再添加
     * @param file 文件对象
     */
    public static void resetDir(File file) throws IOException{
    	if (file.exists())  {
    		delete(file.getAbsolutePath());
    	}
    	
    	createDir(file);
    }
    
    /**
     * 如果此文件不存在则创建信息，否则重新删除再添加
     * @param file 文件对象
     */
    public static void resetFile(File file) throws IOException{
    	if (file.exists())  {
    		delete(file.getAbsolutePath());
    	}
    	
    	createFile(file);
    }
    
    /**
     * 如果此文件不存在则创建信息
     * @param file 文件对象
     */
    public static void createDir(String filePath) throws IOException{
    	createDir(new File(filePath));
    }
    
    /**
     * 如果此文件不存在则创建信息
     * @param file 文件对象
     */
    public static void createDir(File file) throws IOException{
    	if (!file.exists())  file.mkdirs();
    }
    
    /**
     * 用于上传或复制文件
     * @param srcFile 源文件
     * @param targetFile 目标文件
     * @throws IOException 
     */
    public static void moveFile(String srcPath,String tarPath) throws IOException{
    	moveFile(new File(srcPath),tarPath);
    }
    
    
    /**
     * 用于上传或复制文件
     * @param srcFile 源文件
     * @param targetFile 目标文件
     * @throws IOException 
     */
    public static void moveFile(File srcFile,String tarPath) throws IOException{
    	if(srcFile != null && srcFile.exists()) {
    		if(srcFile.isDirectory()) {
    			//创建文件夹
    			resetDir(tarPath);
              	
              	File[] files = srcFile.listFiles();  
              	 
              	//遍历此文件夹所有的文件
              	if(files != null && files.length > 0) {
              		for (File file : files) {
              			moveFile(file,tarPath + File.separator + file.getName());
          			}
              	}
        	}
        	else {
        		convertToFile(new FileInputStream(srcFile),new File(tarPath));
        	}
    	}
    	else {
    		throw new IOException("文件找不到");
    	}
    }
    
    
    /**
     * 用于上传或复制文件
     * @param srcFile 源文件
     * @param targetFile 目标文件
     * @throws IOException 
     */
    public static void moveFile(File srcFile,File tarFile) throws IOException{
    	moveFile(srcFile,tarFile.getAbsolutePath());
    }
    
    /**
     * 取得文件的长度
     * @param file 文件
     * @return 文件长度
     */
    public static Integer getFileLen(File file) {
    	int k = 0;
    	
    	InputStream inStream = null;
    	try {
			if(file != null && file.exists()) {
				inStream = new FileInputStream(file);
				k = inStream.available();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if(inStream != null) {
					inStream.close();
					inStream = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return k;
    }
    
    /**
     * 将文件的byte数组转换成目标文件
     * @param srcByte 源文件数组
     * @param targetFile 目标文件
     * @throws IOException 
     */
    public static File convertToFile(byte[] srcByte,File tarFile) throws IOException {
    	return convertToFile(new ByteArrayInputStream(srcByte),tarFile);
    }
    
    /**
     * 将文件的byte数组转换成目标文件
     * @param srcByte 源文件数组
     * @param targetFile 目标文件
     * @throws IOException 
     */
    public static void convertToFile(File srcFile,OutputStream outStream) throws IOException {
    	convertToFile(new FileInputStream(srcFile),outStream);
    }
    
    /**
     * 将文件的byte数组转换成目标文件
     * @param srcByte 源文件数组
     * @param targetFile 目标文件
     * @throws IOException 
     */
    public static void convertToFile(byte[] srcByte,OutputStream outStream) throws IOException {
    	convertToFile(new ByteArrayInputStream(srcByte),outStream);
    }
    
    /**
     * 将文件的byte数组转换成目标文件
     * @param srcByte 源文件数组
     * @param targetFile 目标文件
     * @throws IOException 
     */
    public static void convertToFile(InputStream inStream,OutputStream outStream) throws IOException {
    	if(inStream == null || outStream == null) return;
    	
    	try {
			byte[]   buff   =   new   byte[1024]; 
			int   readed   =   -1; 
			while((readed   =   inStream.read(buff))   >   0) {
				outStream.write(buff,   0,   readed); 
			}
			
			outStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		finally{
			//关闭各种流
			try {
				if(inStream != null) {
					inStream.close();
					inStream = null;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(outStream != null) {
					outStream.close();
					outStream = null;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
    
    /**
     * 将文件的byte数组转换成目标文件
     * @param srcByte 源文件数组
     * @param targetFile 目标文件
     * @throws IOException 
     */
    public static File convertToFile(InputStream inStream,File tarFile) throws IOException {
    	if(inStream == null) return null;
     
    	//如果不存在父路径，则创建此路径
		if(!tarFile.getParentFile().exists()) tarFile.getParentFile().mkdirs();
		convertToFile(inStream, new FileOutputStream(tarFile));
     
		return tarFile;
    }
    
    /**
     * 将文件转换成byte数组的形式
     * @param tarFile 目标文件
     * @return byte数组
     * @throws IOException
     */
    public static byte[] convertToByte(String srcPath) throws IOException {
    	return convertToByte(new File(srcPath));
    }
    
    
    /**
     * 将文件转换成byte数组的形式
     * @param tarFile 目标文件
     * @return byte数组
     * @throws IOException
     */
    public static byte[] convertToByte(File srcFile) throws IOException {
    	if(srcFile == null || !srcFile.exists() || srcFile.isDirectory()) return null;
    	return convertToByte(new FileInputStream(srcFile));
    }
    
    /**
     * 将文件转换成byte数组的形式
     * @param tarFile 目标文件
     * @return byte数组
     * @throws IOException
     */
    public static byte[] convertToByte(InputStream inStream) throws IOException {
    	if(inStream == null) return null;
    	byte[] content = null;
    	ByteArrayOutputStream outStream = null;
     
		try {
			//构建字节流
			outStream = new ByteArrayOutputStream();
   
			//转换成byte数组
			byte[]   buff   =   new  byte[1024]; 
			int   readed   =   -1; 
			while((readed   =   inStream.read(buff))   >   0) {
				outStream.write(buff,   0,   readed); 
			}
			outStream.flush();

			//取得字节信息
			content = outStream.toByteArray();

			//关闭流
			inStream.close();
			outStream.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		finally{
			//关闭各种流
			try {
				if(inStream != null) {
					inStream.close();
					inStream = null;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(outStream != null) {
					outStream.close();
					outStream = null;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
    	return content;
    }
    
    /**
     * 网络下载
     * @return InputStream对象
     * @throws IOException
     */
    public static byte[] netDownload(String netUrl) throws IOException{
    	if(netUrl == null || "".equals(netUrl.trim())) return null;
    	return convertToByte(new URL(netUrl).openStream());
    }
    
    /**
     * 将文件转换成对应的字符串
     * @return InputStream对象
     * @throws IOException
     */
    public static String covertToString(String filePath) throws IOException{
    	if(filePath == null || "".equals(filePath.trim())) return null;
    	return covertToString(new File(filePath));
    }
    
    /**
     * 将文件转换成对应的字符串
     * @return InputStream对象
     * @throws IOException
     */
    public static String covertToString(File srcFile) throws IOException{
    	if(srcFile == null || !srcFile.exists() || srcFile.isDirectory()) return null;
    	return covertToString(new FileInputStream(srcFile));
    }
    
    
    /**
     * 将文件转换成对应的字符串
     * @return InputStream对象
     * @throws IOException
     */
    public static String covertToString(File srcFile,String encode) throws IOException{
    	if(srcFile == null || !srcFile.exists() || srcFile.isDirectory()) return null;
    	return covertToString(new FileInputStream(srcFile),encode);
    }
    
    /**
     * 将文件转换成对应的字符串
     * @return InputStream对象
     * @throws IOException
     */
    public static String covertToString(byte[] srcByte) throws IOException{
    	if(srcByte == null || srcByte.length == 0) return null;
    	return covertToString(new ByteArrayInputStream(srcByte));
    }
    
    /**
     * 将文件转换成对应的字符串
     * @return InputStream对象
     * @throws IOException
     */
    public static String covertToString(byte[] srcByte,String encode) throws IOException{
    	if(srcByte == null || srcByte.length == 0) return null;
    	return covertToString(new ByteArrayInputStream(srcByte),encode);
    }
    
    /**
     * 将文件转换成对应的字符串
     * @return InputStream对象
     * @throws IOException
     */
    public static String covertToString(InputStream inStream) throws IOException{
    	return covertToString(inStream,"UTF-8");
    }
    
    /**
     * 将文件转换成对应的字符串
     * @return InputStream对象
     * @throws IOException
     */
    public static String covertToString(InputStream inStream,String encode) throws IOException{
    	if(inStream == null) return null;
    	
    	String content = "";
    	BufferedReader buffReader = null;
    	InputStreamReader inReader = null;
		
		try {
			//设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码
			inReader = new InputStreamReader(inStream,encode);
			
			//读取文件字符信息
			String inStr = null;
			StringBuffer sb = new StringBuffer("");
			
			//组合控制台输出信息字符串
			buffReader = new BufferedReader(inReader);
			while ((inStr = buffReader.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			
			content = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		finally{
			//关闭各种流
			try {
				if(inStream != null) {
					inStream.close();
					inStream = null;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(inReader != null) {
					inReader.close();
					inReader = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(buffReader != null) {
					buffReader.close();
					buffReader = null;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
    	//转换成字节信息
    	return content.toString();
    }
    
    /**
     * 将文件内容追加到文件中
     * @param content 文件类容
     * @param filePath 文件路径
     */
    public static void appendStringToFile(String content,String filePath) throws IOException {
    	appendStringToFile(content, new File(filePath));
    }
    
    
    /**
     * 将文件内容追加到文件中
     * @param content 文件类容
     * @param filePath 文件路径
     */
    public static void appendStringToFile(String content,File file) throws IOException{
    	FileOutputStream outStream = null;
    	OutputStreamWriter writer = null;
    	
    	try {
    		//如果文件不存在则创建文件
        	if(!file.exists())createFile(file);
    		
			// 要用来做导入用的sql目标文件：保存备份文件的位置
			outStream = new FileOutputStream(file,true);
			writer = new OutputStreamWriter(outStream, "utf-8");
			  
			//把备份类容写入到备份的文件中
			writer.write(content + "\r\n");
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		finally {
			try {
				if(writer != null) {
					writer.close();
					writer = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(outStream != null) {
					outStream.close();
					outStream = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    
    /**
     * 将文件类容转换成文件
     * @param content 文件类容
     * @param filePath 文件路径
     */
    public static File covertStringToFile(String content,String filePath) throws IOException{
    	return covertStringToFile(content, new File(filePath));
    }
    
    /**
     * 将文件内容转换成文件
     * @param content 文件类容
     * @param filePath 文件路径
     */
    public static File covertStringToFile(String content,File file) throws IOException{
    	FileOutputStream outStream = null;
    	OutputStreamWriter writer = null;
    	
    	try {
    		//如果不存在父路径，则创建此路径
    		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
    		
			// 要用来做导入用的sql目标文件：保存备份文件的位置
			outStream = new FileOutputStream(file);
			writer = new OutputStreamWriter(outStream, "utf-8");
			  
			//把备份类容写入到备份的文件中
			writer.write(content);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return file;
    }
    
    /**
     * 格局文件路径创建文件
     * @param filePath 文件路径
     * @return 文件对象
     */
    public static File createFile(String filePath) {
    	return createFile(new File(filePath));
    }
    
    /**
     * 格局文件路径创建文件
     * @param filePath 文件路径
     * @return 文件对象
     */
    public static File createFile(File file) {
    	try {
			if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
			file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return file;
    }
}