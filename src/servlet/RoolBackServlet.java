package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.FileTree;

public class RoolBackServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7077804403257737388L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		FileTree filetree = new FileTree();
		List<String> list = new LinkedList<>();
		String temp = request.getParameter("temp");
//		System.out.println("\\的位置:" + temp.lastIndexOf("\\"));
//		System.out.println("\\的位置:" + temp.indexOf("\\"));
		if (temp.lastIndexOf("\\") != temp.indexOf("\\")) {
			temp = new String(temp.getBytes("ISO-8859-1"), "UTF-8");
			int indext = temp.lastIndexOf("\\");
//			System.out.println("传入URL" + temp);
//			System.out.println("\\的位置:" + temp.lastIndexOf("\\"));
//			System.out.println("\\的位置:" + temp.indexOf("\\"));
//			System.out.println("截取之后的URL:" + temp.substring(0, indext));
			String newURL = temp.substring(0, indext);
			list = filetree.FileList(newURL);
			request.setAttribute("path", newURL);
		}else{
			list = filetree.FileList();
		}

		request.setAttribute("filelist", list);
		request.getRequestDispatcher("NewIndex.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
