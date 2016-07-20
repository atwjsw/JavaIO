package com.imooc.io;

import java.io.UnsupportedEncodingException;

public class EncodingDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String s ="慕课ABC";
		
		//把字符串转换成字节数组，用的是项目默认的字节编码（GBK)
		byte[] bytes1 = s.getBytes();
		for (byte b: bytes1) {
			//Integer.toHexString把字节（转换成了int)以16进制的方式显示
			//b & 0xff 通过位与把柄byte转换为int后前面的24个0去掉
			System.out.print(Integer.toHexString(b & 0xff) + " "); //c4 bd bf ce 41 42 43 每个汉字2个字节，英文字母1个字节
		}
		
		System.out.println();
		//显式指定为gbk编码，每个汉字2个字节，英文字母1个字节
		byte[] bytes2 = s.getBytes("gbk"); 
		for (byte b: bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " "); //c4 bd bf ce 41 42 43 
		}
		
		System.out.println();
		//显示指定为utf-8编码，每个汉字3个字节，英文字母1个字节
		byte[] bytes3 = s.getBytes("utf-8"); 
		for (byte b: bytes3) {
			System.out.print(Integer.toHexString(b & 0xff) + " "); //e6 85 95 e8 af be 41 42 43
		}
		
		System.out.println();
		//Java是双字节编码 utf-16be. 每个汉字和英文字母都占2个字节
		byte[] bytes4 = s.getBytes("utf-16be"); 
		for (byte b: bytes4) {
			System.out.print(Integer.toHexString(b & 0xff) + " "); //61 55 8b fe 0 41 0 42 0 43
		}
		
		System.out.println();
		//当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，也需要用这种编码方法，否则会出现乱码
		String str1 = new String(bytes4);
		System.out.println(str1); //出现乱码.由于字节序列bytes4的编码是utf-16be,然后转换方式是项目默认的gbk.
		
		String str2 = new String(bytes4, "utf-16be");
		System.out.println(str2); //输出正常
		
		//文本文件本质上就是字节序列
		//可以是任意编码的字节序列
		//如果我们在中文机器直接创建文本文件，那么该文本文件只认识ANSI编码
		
		
	}

}
