package workOrder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/workOrder", "/workOrderDel", "/workOrderRetouch"})
public class WorkOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WorkOrderDAO dao = new WorkOrderDAO();
		List list = dao.selectTable();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("workOrder.jsp").forward(request, response);
					
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getServletPath();
		System.out.println(url);
		if( url.equals("/workOrder") ) {
			
			try {
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			String title = request.getParameter("title");
			String detail = request.getParameter("detail");
			
			WorkOrderDTO dto = new WorkOrderDTO();
			dto.setTitle(title);
			dto.setDetail(detail);
			
			WorkOrderDAO dao = new WorkOrderDAO();
			dao.insertInfo(dto);
			
			response.sendRedirect("workOrder");
			
		} else if( url.equals("/workOrderDel") ) {
			
			try {
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			String[] seqArr = request.getParameterValues("delCheck");
			for(int i = 0; i < seqArr.length; i++) {
				
				WorkOrderDTO dto = new WorkOrderDTO();
				dto.setSeq(Integer.parseInt(seqArr[i]));
				
				WorkOrderDAO dao = new WorkOrderDAO();
				dao.deleteColumn(dto);
			}
			response.sendRedirect("workOrder");
			
		} else if( url.equals("/workOrderRetouch") ) {
			
			try {
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			String check = request.getParameter("checkValue");
			String title = request.getParameter("title");
			String detail = request.getParameter("detail");
			
			WorkOrderDTO dto = new WorkOrderDTO();
			dto.setSeq(Integer.parseInt(check));
			dto.setTitle(title);
			dto.setDetail(detail);
			
			WorkOrderDAO dao = new WorkOrderDAO();
			dao.retouchColumn(dto);
			
			response.sendRedirect("workOrder");
		}
		
	}

}
