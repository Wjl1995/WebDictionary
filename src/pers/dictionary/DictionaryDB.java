package pers.dictionary;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Copyright (C), 2018-3-29, WuJiali.
 * <p>FileName: DictionaryDB.java<br>
 * DictionaryDB类为汉英双译词典数据库类。<br>
 * DictionaryDB类包含学习、查询和打印三个功能。
 * @author 吴佳力
 * @version 1.00
 */
public class DictionaryDB {
	
	private static DictionaryDB instance = new DictionaryDB();
	/** 英译汉数据 */
	private HashMap<String, String> EgToChse;
	/** 汉译英数据 */
	private HashMap<String, String> ChseToEg;
	
	/**
	* 构造方法：初始化数据
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
	* 学习函数：学习新的词汇或者给已有的词添加中文和英文含义
	* @param  Chinese String类型变量，表示中文单词
	* @param  English String类型变量，表示英文文单词
	* @return true boolean类型变量，表示学习成功
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
	* 查找英文单词函数：查找英文单词的中文含义
	* @param  English String类型变量，表示英文文单词
	* @return String类型变量，null表示查不到，否则为中文含义
	*/
	public String searchInEnglish(String English){
		
		if (EgToChse.containsKey(English))
			return EgToChse.get(English);	
		else
			return null;
	}
	
	/**
	* 查找中文单词函数：查找中文单词的英文含义
	* @param  Chinese String类型变量，表示中文文单词
	* @return String类型变量，null表示查不到，否则为英文含义
	*/
	public String searchInChinese(String Chinese){
		
		if (ChseToEg.containsKey(Chinese))
			return ChseToEg.get(Chinese);	
		else
			return null;		
	}
	
	/**
	* 打印所有词典数据
	* @return void
	*/
	public void printDB()
	{
		for (Entry<String, String> entry : EgToChse.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
