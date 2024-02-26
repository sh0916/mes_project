package workOrder;

public class WorkOrderDTO {

	String title;
	String detail;
	/**
	 * @return the title
	 */ 
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "WorkOrderDTO [title=" + title + ", detail=" + detail + "]";
	}
	
}
