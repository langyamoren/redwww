package com.red.util;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
public class FileUploadUtil 
{
	
	public static File UploadFile(File file,String fileName,String targetPath)
	{
	
		//�����µ��ļ���
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String randName=sf.format(new Date());
	    int index=fileName.lastIndexOf(".");
		String ext=fileName.substring(index);
		String newfile=randName+ext;
		
		//String upload=ServletActionContext.getServletContext().getRealPath(path);
		File path=new File(targetPath);
		if(!path.exists())path.mkdirs();//����������ϴ�Ŀ¼�����ڣ��򴴽�
		
		File f=new File(path,newfile);//����Ŀ���ļ�
		
		//ʵ���ϴ�
		BufferedInputStream bi=null;
		BufferedOutputStream bo=null;
		FileInputStream fi=null;
		try {
			fi=new FileInputStream(file);
			FileOutputStream fo=new FileOutputStream(f);
			bi = new BufferedInputStream(fi);
			bo = new BufferedOutputStream(fo);
			byte []tem=new byte[8192];
			int len=0;
			while((len=bi.read(tem))>0)
			{
				bo.write(tem,0,len);
			}
		} catch (FileNotFoundException e) 
		{
			System.out.println("�Ҳ����ļ�........");
			e.printStackTrace();
		} catch (IOException e)
		{
			System.out.println("�ϴ��ļ�ʧ��............");
			e.printStackTrace();
		}finally
		{
			try {
				if(null!=bi)bi.close();
				if(null!=bo)bo.close();
			} catch (IOException e) {
				System.out.println("�ļ��ϴ�ʱ���ر���ʧ��........");
				e.printStackTrace();
			}
		}
		return f;
	}
	
	public static File createSamllPic(int width,int height,File in) throws IOException
	{
            //String []picExt=new String[]{".jpg",".bmp",".png",".gif"};
            String picExt=".jpg.bmp.png.gif";
            File small=null;
	        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String extName=in.getName().substring(in.getName().lastIndexOf('.'));
            //�ж���չ���Ƿ�ΪͼƬ
		    if(picExt.indexOf(extName.toLowerCase())!=-1)
		    {
		    
			String newName=sf.format(new java.util.Date())+(String.valueOf((int)(Math.random()*10)))+extName;
			String newFileName=in.getParent()+File.separator+newName;
			
	        InputStream insrc = new FileInputStream(in);
	        BufferedImage src = ImageIO.read(insrc); 
	        ImageIOUtil.write(width, height,newFileName,insrc, src);
	        small=new File(newFileName);
		    }
	 return small;	
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        long start=new Date().getTime();
		FileUploadUtil.UploadFile(new File("D:\\develop\\JavaEE\\eclipse-jee-galileo-SR2-win32.zip"), "eclipse-jee-galileo-SR2-win32.zip", "f:\\");
		long end=new Date().getTime();
		System.out.println((end-start)/1000.0);
		//FileUploadUtil.createSamllPic(200, 100, new File("F:\\gz050.jpg"));
		
	}

}
