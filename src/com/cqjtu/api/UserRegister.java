package com.cqjtu.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.cqjtu.dao.UserDao;
import com.cqjtu.vo.User;


/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		String userPhone=request.getParameter("userphone");
		PrintWriter pw = response.getWriter();
		JSONObject resp = new JSONObject(); 
		if(userName!=null&&passWord!=null&&userPhone!=null){
			UserDao dao = new UserDao();
			User user = new User(userName,passWord,userPhone);
			int i=dao.userRegister(user);
			if (i>0) {
				resp.accumulate("serverState",0);
				resp.accumulate("serverMsg","注册成功。");
				pw.write(resp.toString());
				pw.flush();
				pw.close();
			} else {
				resp.accumulate("serverState",1);
				resp.accumulate("serverMsg","账户已存在，注册失败。");
				pw.write(resp.toString());
				pw.flush();
				pw.close();
			}
		}
		else
		{
			resp.accumulate("serverState",1);
			resp.accumulate("serverMsg","注册信息不完整，登陆失败。");
			pw.write(resp.toString());
			pw.flush();
			pw.close();
		}
		
}
	}
