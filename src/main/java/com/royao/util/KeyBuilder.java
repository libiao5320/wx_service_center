package com.royao.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*****************************************************
 * 自定义主键生成器
 * @author yangx
 *
 */
public class KeyBuilder{
	
	private static long uniqueID = System.currentTimeMillis();
	
	private static String [] strABC={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private static String [] str={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	public static String generate() {
		uniqueID++;
		return String.valueOf(uniqueID * 1000L + (long)(new Random()).nextInt(999));
	}
	
	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(KeyBuilder.createUidNew10
//					());
//		}
		for (int i = 0; i < 10; i++) {
			System.out.println(createUidNew16());
		}
	}
	
	public static int generateOrderid() {
		uniqueID++;
		return Integer.parseInt(String.valueOf(uniqueID * 1000L + (long)(new Random()).nextInt(999)).substring(7));
	}
	
	/**
	 * 获得时间+6位随机数的ID 
	 * （杨星增加 ）
	 * @return
	 */
	public static String createUidNew(){
		// 获得系统时间并转化为字符串形式
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		// 获得一个随机的6位正整数
		Random random = new Random();
		String ss="";
		String rand="";
		// 6位
		for (int i=0;i<6;i++){
    		rand=String.valueOf(random.nextInt(10));
       		ss+=rand;
		}
		
		return s+ss;
	}
	
	
	/**
	 * 获得时间  14位
	 * （杨星增加 ）
	 * @return
	 */
	public static String createUidNew14(){
		// 获得系统时间并转化为字符串形式
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyMMddHHmmss");
		String s = outFormat.format(now);
		// 获得一个随机的6位正整数
		Random random = new Random();
		String rand="";
		
		rand=String.valueOf(s);
		rand=rand+String.valueOf(random.nextInt(10));
		rand=rand+String.valueOf(random.nextInt(10));
		
		return rand;
	}
	
	/**
	 * 获得10位随机数
	 * （杨星增加 ）
	 * @return
	 */
	public static String createUidNew10(){
		// 获得一个10位正整数
		Random random = new Random();
		String rand="";
		for(int i=0;i<10;i++){
			rand=rand+String.valueOf(random.nextInt(10));
		}
		return rand;
	}
	
	/**
	 * 获得16位包含数字和字母的字符串
	 * @return
	 */
	public static String createUidNew16(){
		Random random = new Random();
		StringBuffer rand = new StringBuffer();
		for(int i=0;i<16;i++){
			rand.append(str[random.nextInt(36)]);
		}
		return rand.toString();
	}
	
	
}
