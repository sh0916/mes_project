package workOrder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/workOrder", "/workOrderDel", "/workOrderRetouch", "/workSafety", "/workSafetyDel", "/workSafetyRetouch", "/workQuality"})
public class WorkOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String local = request.getServletPath();
		System.out.println(local);
		
		WorkOrderDAO dao = new WorkOrderDAO();
		List list = dao.selectTable(local);
		
		request.setAttribute("list", list);

		if( local.equals("/workOrder") ) {
			
			request.getRequestDispatcher("workOrder.jsp").forward(request, response);
		} else if( local.equals("/workSafety") ) {
			
			request.getRequestDispatcher("workSafety.jsp").forward(request, response);
		} else if( local.equals("/workQuality") ) {
			
			request.getRequestDispatcher("workQuality.jsp").forward(request, response);
		}
					
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String local = request.getServletPath();
		System.out.println(local);
		if( local.equals("/workOrder") || local.equals("/workSafety") || local.equals("/workQuality") ) {
			
			String title = request.getParameter("title");
			String detail = request.getParameter("detail");
			String urlImage = request.getParameter("urlImage");
			
			if( local.equals("/workOrder") || local.equals("/workSafety") ) {
				
				if(urlImage.equals(null)) {
					
					urlImage = "https://image.spreadshirtmedia.net/image-server/v1/compositions/T996A1PA2179PT10X17Y18D172654919W7098H6789/views/1,width=550,height=550,appearanceId=1,backgroundColor=FFFFFF,noPt=true/pixel-art-fox-fox-podstawki.jpg";
				}
			}
			
			WorkOrderDTO dto = new WorkOrderDTO();
			dto.setTitle(title);
			dto.setDetail(detail);
			dto.setUrlImage(urlImage);
			
			WorkOrderDAO dao = new WorkOrderDAO();
			dao.insertInfo(dto, local);
			
			if( local.equals("/workOrder") ) {
				
				response.sendRedirect("workOrder");
			} else if( local.equals("/workSafety") ) {
				
				response.sendRedirect("workSafety");
			} else if( local.equals("/workQuality") ) {
				
				response.sendRedirect("workQuality");
			}
			
		} else if( local.equals("/workOrderDel") || local.equals("/workSafetyDel") ) {
			
			String[] seqArr = request.getParameterValues("delCheck");

			for(int i = 0; i < seqArr.length; i++) {
				
				WorkOrderDTO dto = new WorkOrderDTO();
				dto.setSeq(Integer.parseInt(seqArr[i]));
				
				WorkOrderDAO dao = new WorkOrderDAO();
				dao.deleteColumn(dto);
			}
			
			if( local.equals("/workOrderDel") ) {
				
				response.sendRedirect("workOrder");
			} else if( local.equals("/workSafetyDel") ) {
				
				response.sendRedirect("workSafety");
			}
			
		} else if( local.equals("/workOrderRetouch") || local.equals("/workSafetyRetouch") ) {
			
			String check = request.getParameter("checkValue");
			String title = request.getParameter("title");
			String detail = request.getParameter("detail");
			String urlImage = request.getParameter("urlImage");
			
			if(urlImage == null) {
				
				urlImage = "https://image.spreadshirtmedia.net/image-server/v1/compositions/T996A1PA2179PT10X17Y18D172654919W7098H6789/views/1,width=550,height=550,appearanceId=1,backgroundColor=FFFFFF,noPt=true/pixel-art-fox-fox-podstawki.jpg";
			}
			
			WorkOrderDTO dto = new WorkOrderDTO();
			dto.setSeq(Integer.parseInt(check));
			dto.setTitle(title);
			dto.setDetail(detail);
			dto.setUrlImage(urlImage);
			
			WorkOrderDAO dao = new WorkOrderDAO();
			dao.retouchColumn(dto);
			
			if( local.equals("/workOrderRetouch") ) {
				
				response.sendRedirect("workOrder");
			} else if( local.equals("/workSafetyRetouch") ) {
				
				response.sendRedirect("workSafety");
			}
		}
		
	}

}
