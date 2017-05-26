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
 * Servlet implementation class FixerRegister
 */
public class FixerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixerRegister() {
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
		String fixerName=request.getParameter("fixername");
		String passWord=request.getParameter("password");
		String fixerPhone=request.getParameter("fixerphone");
		PrintWriter pw = response.getWriter();
		JSONObject resp = new JSONObject(); 
		if(fixerName!=null&&passWord!=null&&fixerPhone!=null){
			FixerDao dao = new FixerDao();
			Fixer user = new Fixer(fixerName,passWord,fixerPhone);
			int i=dao.fixerRegister(user);
			if (i>0) {
				try {
					resp.put("serverState",0);
					resp.put("serverMsg","ע��ɹ���");
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
					resp.put("serverMsg","�˻��Ѵ��ڣ�ע��ʧ�ܡ�");
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
				resp.put("serverMsg","ע����Ϣ����������½ʧ�ܡ�");
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
