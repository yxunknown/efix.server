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
 * Servlet implementation class UserUpdate
 */
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
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
		String userPhone=request.getParameter("userphone");
		String userAddress=request.getParameter("address");
		PrintWriter pw = response.getWriter();
		JSONObject resp = new JSONObject(); 
		if(userPhone!=null&&userAddress!=null){
			UserDao dao = new UserDao();
			User user =new User();
			user.setUserPhone(userPhone);
			user.setUserAddress(userAddress);
			int i=dao.userUpdate(user);
			if (i>0) {
			resp.accumulate("serverState",0);
			resp.accumulate("serverMsg","账户存在，修改成功。");
			pw.write(resp.toString());
				pw.flush();
				pw.close();
			} else {
				resp.accumulate("serverState",1);
				resp.accumulate("serverMsg","账户不存在，修改失败。");
				pw.write(resp.toString());
				pw.flush();
				pw.close();
			}
		}
		else
		{
			resp.accumulate("serverState",1);
			resp.accumulate("serverMsg","账户信息不完整，修改失败。");
			pw.write(resp.toString());
			pw.flush();
			pw.close();
		}
		
}

}

