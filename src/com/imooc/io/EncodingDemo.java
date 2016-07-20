package com.imooc.io;

import java.io.UnsupportedEncodingException;

public class EncodingDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String s ="Ľ��ABC";
		
		//���ַ���ת�����ֽ����飬�õ�����ĿĬ�ϵ��ֽڱ��루GBK)
		byte[] bytes1 = s.getBytes();
		for (byte b: bytes1) {
			//Integer.toHexString���ֽڣ�ת������int)��16���Ƶķ�ʽ��ʾ
			//b & 0xff ͨ��λ��ѱ�byteת��Ϊint��ǰ���24��0ȥ��
			System.out.print(Integer.toHexString(b & 0xff) + " "); //c4 bd bf ce 41 42 43 ÿ������2���ֽڣ�Ӣ����ĸ1���ֽ�
		}
		
		System.out.println();
		//��ʽָ��Ϊgbk���룬ÿ������2���ֽڣ�Ӣ����ĸ1���ֽ�
		byte[] bytes2 = s.getBytes("gbk"); 
		for (byte b: bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " "); //c4 bd bf ce 41 42 43 
		}
		
		System.out.println();
		//��ʾָ��Ϊutf-8���룬ÿ������3���ֽڣ�Ӣ����ĸ1���ֽ�
		byte[] bytes3 = s.getBytes("utf-8"); 
		for (byte b: bytes3) {
			System.out.print(Integer.toHexString(b & 0xff) + " "); //e6 85 95 e8 af be 41 42 43
		}
		
		System.out.println();
		//Java��˫�ֽڱ��� utf-16be. ÿ�����ֺ�Ӣ����ĸ��ռ2���ֽ�
		byte[] bytes4 = s.getBytes("utf-16be"); 
		for (byte b: bytes4) {
			System.out.print(Integer.toHexString(b & 0xff) + " "); //61 55 8b fe 0 41 0 42 0 43
		}
		
		System.out.println();
		//������ֽ�������ĳ�ֱ���ʱ�����ʱ������ֽ����б���ַ�����Ҳ��Ҫ�����ֱ��뷽����������������
		String str1 = new String(bytes4);
		System.out.println(str1); //��������.�����ֽ�����bytes4�ı�����utf-16be,Ȼ��ת����ʽ����ĿĬ�ϵ�gbk.
		
		String str2 = new String(bytes4, "utf-16be");
		System.out.println(str2); //�������
		
		//�ı��ļ������Ͼ����ֽ�����
		//���������������ֽ�����
		//������������Ļ���ֱ�Ӵ����ı��ļ�����ô���ı��ļ�ֻ��ʶANSI����
		
		
	}

}
