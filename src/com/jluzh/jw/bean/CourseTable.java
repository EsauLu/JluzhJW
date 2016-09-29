package com.jluzh.jw.bean;

import java.util.ArrayList;

/**
 * 课表类
 * @author EsauLu
 *
 */
public class CourseTable {

	/**
	 * 学年度列表
	 */
	private String[] xnd;
	
	/**
	 * 学期列表
	 */
	private String[] xqd;
	
	/**
	 * 当前学年
	 */
	private String currXnd;
	
	/**
	 * 当前学期
	 */
	private String currXqd;
	
	/**
	 * 学生简要信息
	 */
	private StuSimpleInfo simpleInfo;
	
	/**
	 * 课程列表
	 */
	private ArrayList<Course> courses;
	
	/**
	 * 构造函数
	 */
	public CourseTable() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取学年度数组
	 * @return 返回学年度数组
	 */
	public String[] getXnd() {
		return xnd;
	}

	/**
	 * 设置学年度数组
	 * @param xnd 学年度数组
	 */
	public void setXnd(String[] xnd) {
		this.xnd = xnd;
	}

	/**
	 * 获取学期数组
	 * @return 返回学期数组
	 */
	public String[] getXqd() {
		return xqd;
	}

	/**
	 * 设置学期数组
	 * @param xqd 学期数组
	 */
	public void setXqd(String[] xqd) {
		this.xqd = xqd;
	}

	/**
	 * 获取当前学年度
	 * @return 返回当前学年度
	 */
	public String getCurrXnd() {
		return currXnd;
	}

	/**
	 * 设置当前学年度
	 * @param currXnd 学年度
	 */
	public void setCurrXnd(String currXnd) {
		this.currXnd = currXnd;
	}

	/**
	 * 获取当前学期
	 * @return 返回当前学期
	 */
	public String getCurrXqd() {
		return currXqd;
	}

	/**
	 * 设置当前学期
	 * @param currXqd 当前学期
	 */
	public void setCurrXqd(String currXqd) {
		this.currXqd = currXqd;
	}

	/**
	 * 获取课程列表
	 * @return 返回课程列表
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}

	/**
	 * 设置课程列表
	 * @param courses 课程列表
	 */
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	/**
	 * 获取学生简要信息
	 * @return 学生简要信息
	 */
	public StuSimpleInfo getSimpleInfo() {
		return simpleInfo;
	}
	
	/**
	 * 设置学生简要信息
	 * @param simpleInfo 学生简要信息
	 */
	public void setSimpleInfo(StuSimpleInfo simpleInfo) {
		this.simpleInfo = simpleInfo;
	}
	
	public String getJson() {
		StringBuffer sb=new StringBuffer();	
		sb.append("{");
		for(Course c:courses){
			sb.append("\n\t{");
			sb.append("\n\t\t\"name\":\""+c.getName()+"\"");
			sb.append("\n\t\t\"classRoom\":\""+c.getClassRoom()+"\"");
			sb.append("\n\t\t\"teacher\":\""+c.getTeacher()+"\"");
			sb.append("\n\t\t\"classTime\":\""+c.getClassTime()+"\"");
			sb.append("\n\t\t\"weekNum\":\""+c.getWeekNum()+"\"");
			sb.append("\n\t\t\"startWeek\":\""+c.getStartWeek()+"\"");
			sb.append("\n\t\t\"endWeek\":\""+c.getEndWeek()+"\"");
			sb.append("\n\t\t\"weekState\":\""+c.getWeekState()+"\"");
			sb.append("\n\t\t\"number\":\""+c.getNumber()+"\"");
			sb.append("\n\t\t\"day\":\""+c.getDay()+"\"");					
			sb.append("\n\t}\n");
		}
		sb.append("}");		
		return sb.toString();
	}
	
	
}





































