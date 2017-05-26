package com.cqjtu.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.json.JSONException;
import org.json.JSONObject;

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
			try {
				resp.put("serverState",0);
				resp.put("serverMsg","�˻����ڣ��޸ĳɹ���");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.write(resp.toString());
				pw.flush();
				pw.close();
			} else {
				try {
					resp.put("serverState",1);
					resp.put("serverMsg","�˻������ڣ��޸�ʧ�ܡ�");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pw.write(resp.toString());
				pw.flush();
				pw.close();
			}
		}
		else
		{
			try {
				resp.put("serverState",1);
				resp.put("serverMsg","�˻���Ϣ���������޸�ʧ�ܡ�");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.write(resp.toString());
			pw.flush();
			pw.close();
		}
		
}

}


