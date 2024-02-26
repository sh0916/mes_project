package workOrder;

import java.util.List;

public class WorkOrderView {

	
	public StringBuffer orderView(List list) {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < list.size(); i++) {
			
			WorkOrderDTO dto = (WorkOrderDTO)list.get(i);
			String title = dto.getTitle();
			String detail = dto.getDetail();
			
			sb.append("<div class='workList'>");
			sb.append("<div class='delete-checkbox'>");
			sb.append("<input type='checkbox' class='delete-check'>");
			sb.append("</div>");
			sb.append("<div class='workOrder'>");
			sb.append("<p>");
			sb.append(title);
			sb.append("<br>");
			sb.append(detail);
			sb.append("</p>");
			sb.append("</div>");
			sb.append("<div class='workImg'>");
			sb.append("<img"
					+ "	src='https://image.spreadshirtmedia.net/image-server/v1/compositions/T996A1PA2179PT10X17Y18D172654919W7098H6789/views/1,width=550,height=550,appearanceId=1,backgroundColor=FFFFFF,noPt=true/pixel-art-fox-fox-podstawki.jpg'>");
			sb.append("</div>");
			sb.append("</div>");
		}
		
		return sb;
	}
}
