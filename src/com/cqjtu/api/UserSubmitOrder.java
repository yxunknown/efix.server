package com.cqjtu.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.cqjtu.dao.OrderDao;
import com.cqjtu.vo.Order;

/**
 * Servlet implementation class UserSubmitOrder
 */
public class UserSubmitOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSubmitOrder() {
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
		double bill=Double.parseDouble(request.getParameter("bill"));
		String orderInfo=request.getParameter("orderinfo");
		PrintWriter pw = response.getWriter();
		JSONObject resp = new JSONObject(); 
		if(userPhone!=null&&bill>0&&orderInfo!=null){
			OrderDao dao = new OrderDao();
			Order user =new Order();
			user.setUserPhone(userPhone);
			user.setBill(bill);
			user.setOrderInfo(orderInfo);
			int i=dao.orderRegister(user);
			if (i>0) {
			resp.accumulate("serverState",0);
			resp.accumulate("serverMsg","用户提交订单成功。");
			pw.write(resp.toString());
				pw.flush();
				pw.close();
			} else {
				resp.accumulate("serverState",1);
				resp.accumulate("serverMsg","用户提交订单失败。");
				pw.write(resp.toString());
				pw.flush();
				pw.close();
			}
		}
		else
		{
			resp.accumulate("serverState",1);
			resp.accumulate("serverMsg","订单信息不完整，用户提交订单失败。");
			pw.write(resp.toString());
			pw.flush();
			pw.close();
		}
		
}

}


