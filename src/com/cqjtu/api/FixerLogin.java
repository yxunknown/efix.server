package com.cqjtu.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqjtu.dao.FixerDao;
import com.cqjtu.vo.Fixer;

import net.sf.json.JSONObject;


/**
 * Servlet implementation class FixerLogin
 */
public class FixerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String fixerphone=request.getParameter("fixerphone");
		String passWord=request.getParameter("password");
		PrintWriter pw = response.getWriter();
		JSONObject resp = new JSONObject(); 
		if(fixerphone!=null&&passWord!=null){
			FixerDao dao = new FixerDao();
			Fixer user =dao.selectByNameAndPass(fixerphone, passWord);
			if (user!=null) {
			resp.accumulate("serverState",0);
			resp.accumulate("serverMsg","账户存在，登陆成功。");
			pw.write(resp.toString());
				pw.flush();
				pw.close();
			} else {
				resp.accumulate("serverState",1);
				resp.accumulate("serverMsg","账户不存在，登陆失败。");
				pw.write(resp.toString());
				pw.flush();
				pw.close();
			}
		}
		else
		{
			resp.accumulate("serverState",1);
			resp.accumulate("serverMsg","账户信息不完整，登陆失败。");
			pw.write(resp.toString());
			pw.flush();
			pw.close();
		}
		
}

}

