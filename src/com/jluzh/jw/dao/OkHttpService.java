package com.jluzh.jw.dao;

import org.apache.http.client.entity.UrlEncodedFormEntity;

import com.jluzh.jw.bean.CourseTable;
import com.jluzh.jw.bean.PersonalInfo;
import com.jluzh.jw.bean.User;

public class OkHttpService implements HttpDAO {
	
//	HttpCli

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public StringBuffer sendGetRequest(String url, String ref) {
		// TODO Auto-generated method stub
//		okio.
		return null;
	}

	@Override
	public StringBuffer sendPostRequest(String url, String ref, UrlEncodedFormEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getCheckImg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CourseTable getCourseTable(String xnd, String xqd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCourseTableAsJson(String xnd, String xqd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonalInfo getPersonalInfo(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessege() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	get

}
