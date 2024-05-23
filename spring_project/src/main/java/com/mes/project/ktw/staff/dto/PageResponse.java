package com.mes.project.ktw.staff.dto;

import java.util.List;

public class PageResponse<T> {
	private List<T> items;
	private int totalItems;
	private int totalPages;

	// 기본 생성자
	public PageResponse() {
	}

	// 매개변수를 받는 생성자
	public PageResponse(List<T> items, int totalItems, int totalPages) {
		this.items = items;
		this.totalItems = totalItems;
		this.totalPages = totalPages;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "PageResponse [items=" + items + ", totalItems=" + totalItems + ", totalPages=" + totalPages
				+ ", getItems()=" + getItems() + ", getTotalItems()=" + getTotalItems() + ", getTotalPages()="
				+ getTotalPages() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
