package pers.dictionary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DictionarySearch
 */
@WebServlet({ "/DictionarySearch", "" })
public class DictionarySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DictionarySearch() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try{
			
			UseDictionary DictionarySearch = new UseDictionary();
			String EnglishWord = request.getParameter("English");
			String ChineseWord = request.getParameter("Chinese");
			String result = null;
			if (!EnglishWord.isEmpty())
			{
				result = DictionarySearch.searchInEnglish(EnglishWord);
			}
			else
			{
				result = DictionarySearch.searchInChinese(ChineseWord);
			}
			System.out.println("Ӣ�뺺 "+EnglishWord+"="+result);
			out.write(result);
		}
		finally{
			out.close();
		}
	}

}
