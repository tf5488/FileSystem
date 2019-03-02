package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.FileTree;

public class FileTreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		FileTree filetree = new FileTree();
		List<String> list = new LinkedList<>();
		String temp = request.getParameter("temp");
		if(temp != null){
			temp = new String(temp.getBytes("ISO-8859-1"),"UTF-8");
//			System.out.println("传入URL"+temp);
			list = filetree.FileList(temp);
			request.setAttribute("path", temp);
		}else{
			list = filetree.FileList();
		}
//		System.out.println("输出结果:"+list.toString());
		request.setAttribute("filelist", list);
		request.getRequestDispatcher("NewIndex.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
