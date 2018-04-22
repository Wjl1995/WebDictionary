package pers.dictionary;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Copyright (C), 2018-3-29, WuJiali.
 * <p>FileName: DictionaryDB.java<br>
 * DictionaryDB��Ϊ��Ӣ˫��ʵ����ݿ��ࡣ<br>
 * DictionaryDB�����ѧϰ����ѯ�ʹ�ӡ�������ܡ�
 * @author �����
 * @version 1.00
 */
public class DictionaryDB {
	
	private static DictionaryDB instance = new DictionaryDB();
	/** Ӣ�뺺���� */
	private HashMap<String, String> EgToChse;
	/** ����Ӣ���� */
	private HashMap<String, String> ChseToEg;
	
	/**
	* ���췽������ʼ������
	*/
	private DictionaryDB(){
		EgToChse = new HashMap<String, String>();
		ChseToEg = new HashMap<String, String>();
	}
	
	public static DictionaryDB getInstance()
	{
		return instance;
	}
	
	/**
	* ѧϰ������ѧϰ�µĴʻ���߸����еĴ�������ĺ�Ӣ�ĺ���
	* @param  Chinese String���ͱ�������ʾ���ĵ���
	* @param  English String���ͱ�������ʾӢ���ĵ���
	* @return true boolean���ͱ�������ʾѧϰ�ɹ�
	*/
	public boolean learn(String Chinese, String English){
		
		if (EgToChse.containsKey(English))
			EgToChse.put(English, EgToChse.get(English)+","+Chinese);
		else
			EgToChse.put(English, Chinese);
		
		if (ChseToEg.containsKey(Chinese))
			ChseToEg.put(Chinese, ChseToEg.get(Chinese)+","+English);
		else
			ChseToEg.put(Chinese, English);
		
		return true;
	}
	
	/**
	* ����Ӣ�ĵ��ʺ���������Ӣ�ĵ��ʵ����ĺ���
	* @param  English String���ͱ�������ʾӢ���ĵ���
	* @return String���ͱ�����null��ʾ�鲻��������Ϊ���ĺ���
	*/
	public String searchInEnglish(String English){
		
		if (EgToChse.containsKey(English))
			return EgToChse.get(English);	
		else
			return null;
	}
	
	/**
	* �������ĵ��ʺ������������ĵ��ʵ�Ӣ�ĺ���
	* @param  Chinese String���ͱ�������ʾ�����ĵ���
	* @return String���ͱ�����null��ʾ�鲻��������ΪӢ�ĺ���
	*/
	public String searchInChinese(String Chinese){
		
		if (ChseToEg.containsKey(Chinese))
			return ChseToEg.get(Chinese);	
		else
			return null;		
	}
	
	/**
	* ��ӡ���дʵ�����
	* @return void
	*/
	public void printDB()
	{
		for (Entry<String, String> entry : EgToChse.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
