package workOrder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WorkOrderServlet")
public class WorkOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WorkOrderDAO dao = new WorkOrderDAO();
		List list = dao.selectTable();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("workOrder.jsp").forward(request, response);
					
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		
//		System.out.println(title);
//		System.out.println(detail);
		
		WorkOrderDTO dto = new WorkOrderDTO();
		dto.setTitle(title);
		dto.setDetail(detail);
		
		WorkOrderDAO dao = new WorkOrderDAO();
		dao.insertInfo(dto);
	}

}
