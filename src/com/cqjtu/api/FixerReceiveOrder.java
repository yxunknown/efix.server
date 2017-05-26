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
 * Servlet implementation class FixerReceiveOrder
 */
public class FixerReceiveOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixerReceiveOrder() {
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
		int orderId=Integer.parseInt(request.getParameter("orderid"));
		String fixerPhone=request.getParameter("fixerphone");
		String createTime=request.getParameter("createtime");
		PrintWriter pw = response.getWriter();
		JSONObject resp = new JSONObject(); 
		if(fixerPhone!=null&&createTime!=null&&orderId!=0){
			OrderDao dao = new OrderDao();
			Order user =new Order();
			user.setOrderId(orderId);
			user.setCreateTime(createTime);
			user.setFixerPhone(fixerPhone);
			int i= dao.orderUpdate(user);
			if (i>0) {
			resp.accumulate("serverState",0);
			resp.accumulate("serverMsg","�˻����ڣ��ӵ��ɹ���");
			pw.write(resp.toString());
				pw.flush();
				pw.close();
			} else {
				resp.accumulate("serverState",1);
				resp.accumulate("serverMsg","���������ڣ��ӵ�ʧ�ܡ�");
				pw.write(resp.toString());
				pw.flush();
				pw.close();
			}
		}
		else
		{
			resp.accumulate("serverState",1);
			resp.accumulate("serverMsg","������Ϣ���������޸�ʧ�ܡ�");
			pw.write(resp.toString());
			pw.flush();
			pw.close();
		}
		
}

}



