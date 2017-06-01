package com.red.util;


public class RcomeRandCode
{
	//String str="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // String str1="rp2A5SwsUkKtyXLIDmjqhZv9nog7WfF1xJP6Me34HEGCdcV08YROTiBulNaQzb";
	//public static char bitdesc[]="iulNaQzb".toCharArray();
	
	//长度为51个字符,第50个索个表示50(B) 第0个索相表示0(r)

	public static String org="rp2A5SwsUkKtyXLIDmjqhZv9ng7WfF1xJP6Me34HEGCdcV8YRTB";//Arrays.copyOf(org, 50);
	
	public static String CreateRand(int num)
	{
	    char []medata=org.toCharArray();
		char one='@';
		char two='@';
		StringBuffer sb=new StringBuffer();
		if(num>49)
		{
			two=medata[50];
			one=medata[num-50];	
		}else
		{
			two=medata[0];
			one=medata[num];
		}
		sb.append(two);
		sb.append(one);
		return sb.toString();
	}
	/**
	 * 将数据转为推荐码
	 * @param num
	 * @return
	 */
	public static String parseToString(int num)
	{
		StringBuffer sb=new StringBuffer();
		StringBuffer sb1=new StringBuffer();
		String str=String.valueOf(num);
		char chars[]=str.toCharArray();
		int flag=0;
		for(int i=0;i<chars.length;i++)
		{
			if(flag==2)
			{
				sb.append(',');
				flag=0;
			}
			sb.append(chars[i]);
			flag++;	
		}
		String[]strs=sb.toString().split(",");
		for(String tem:strs)
		{
			sb1.append(CreateRand(Integer.parseInt(tem)));
		}
		return sb1.toString();
	}
	
	/**
	 * 将String推荐码转为数字
	 * @param str
	 * @return
	 */
	public static int parseToInt(String str)
	{
		StringBuffer sb=new StringBuffer();
		StringBuffer sb1=new StringBuffer();
		char []chars=str.toCharArray();
		int flag=0;
		for(int i=0;i<chars.length;i++)
		{
			if(flag==2)
			{
				sb.append(',');
				flag=0;
			}
			sb.append(chars[i]);
			flag++;
		}
		//System.out.println(sb.toString());
		String strs[]=sb.toString().split(",");
		for(String tem:strs)
		{
			sb1.append(reversRand(tem));
		}
	
		//System.out.println(sb1.toString());
		return Integer.parseInt(sb1.toString());
	}
	
	public static int reversRand(String str)
	{
		int re=0;
		char tt[]=str.toCharArray();
		if(tt[0]==org.charAt(0))
		{
			re=org.indexOf(tt[1]);
		}else if(tt[0]==org.charAt(50))
		{
			re=50+org.indexOf(tt[1]);
		}
		
		return re;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.print(parseToString(2));
		//System.out.print(parseToInt("BT"));
      // System.out.println();
	}

}
