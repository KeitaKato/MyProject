package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

public class PythonGraphAction extends ActionSupport{

	private String graphImg;

	public String execute() throws Exception{

		return SUCCESS;

	}

	public String getGraphImg() {
		return graphImg;
	}

	public void setGraphImg(String graphImg) {
		this.graphImg = graphImg;
	}


}
