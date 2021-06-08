package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Emp;
import DB.DBConnection;
import Dao.HomeDao;

/**
 * Servlet implementation class Forward
 */
@WebServlet("/Forward")
public class Forward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageidstr = request.getParameter("pageid");
		int pageid = Integer.parseInt(pageidstr);
		int count = 4;
		//neu page id =1 ko phan trang
		if(pageid==1){
		
			
		}else{
			pageid = pageid-1;
			pageid = pageid * count +1;
		}
		Connection conn = DBConnection.creatConnection();
		List<Emp> listemp = HomeDao.displayEmp(pageid, count, conn);
		int sumrow = HomeDao.countRow(conn);
		int maxpageid = (sumrow/count)+1;
		request.setAttribute("maxgepageid", maxpageid);
		request.setAttribute("listemp",listemp);
		request.setAttribute("numberpage", Integer.parseInt(pageidstr));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
