package pers.dictionary;

/**
 * Copyright (C), 2018-4-22, WuJiali.
 * <p>FileName: UseDictionary.java<br>
 * UseDictionary类为汉英双译词典使用类。<br>
 * UseDictionary类进入词典数据库前的逻辑处理。
 * @author 吴佳力
 * @version 1.00
 */
public class UseDictionary {

	private DictionaryDB instance = null;
	
	public UseDictionary()
	{
		instance = DictionaryDB.getInstance();
	}
	
	public void learn(String Chinese, String English)
	{
		if ((English != null) && ((Chinese != null)))
			instance.learn(Chinese, English);
	}
	
	public String searchInEnglish(String EnglishWord)
	{
		if (EnglishWord != null)
		{
			String result = instance.searchInEnglish(EnglishWord.toUpperCase());
			if (result != null)
				return result;
			else
			{
				result = instance.searchInEnglish(EnglishWord.toLowerCase());
				if (result != null)
					return result;
				else
					return null;
			}
		}
		else
			return null;
	}
	
	public String searchInChinese(String ChineseWord)
	{
		if (ChineseWord != null)
		{
			String result = instance.searchInChinese(ChineseWord.toUpperCase());
			if (result != null)
				return result;
			else
			{
				result = instance.searchInChinese(ChineseWord.toLowerCase());
				if (result != null)
					return result;
				else
					return null;
			}
		}
		else
			return null;
	}
	
	public void print()
	{
		instance.printDB();
	}
}
