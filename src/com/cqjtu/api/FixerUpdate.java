package com.cqjtu.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.cqjtu.dao.FixerDao;
import com.cqjtu.vo.Fixer;

/**
 * Servlet implementation class FixerUpdate
 */
public class FixerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixerUpdate() {
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
		String fixerPhone=request.getParameter("fixerphone");
		String identification=request.getParameter("identification");
		PrintWriter pw = response.getWriter();
		JSONObject resp = new JSONObject(); 
		if(fixerPhone!=null&&identification!=null){
			FixerDao dao = new FixerDao();
			Fixer user =new Fixer();
			user.setFixerPhone(fixerPhone);
			user.setIdentification(identification);
			int i= dao.fixerUpdate(user);
			if (i>0) {
			resp.accumulate("serverState",0);
			resp.accumulate("serverMsg","�˻����ڣ��޸ĳɹ���");
			pw.write(resp.toString());
				pw.flush();
				pw.close();
			} else {
				resp.accumulate("serverState",1);
				resp.accumulate("serverMsg","�˻������ڣ��޸�ʧ�ܡ�");
				pw.write(resp.toString());
				pw.flush();
				pw.close();
			}
		}
		else
		{
			resp.accumulate("serverState",1);
			resp.accumulate("serverMsg","�˻���Ϣ���������޸�ʧ�ܡ�");
			pw.write(resp.toString());
			pw.flush();
			pw.close();
		}
		
}

}


