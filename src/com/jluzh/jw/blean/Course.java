package com.jluzh.jw.blean;

/**
 * 课程类
 * @author EsauLu
 *
 */
public class Course {
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 教室
	 */
	private String classRoom;
	
	/**
	 * 老师
	 */
	private String teacher;
	
	/**
	 * 上课时间
	 */
	private String classTime;
	
	/**
	 * 周数
	 */
	private String weekNum;
	
	/**
	 * 课程在课表中的位置
	 */
	private SchoolTime schoolTime;
	
	/**
	 * 记录课程在课表中位置的类
	 * @author EsauLu
	 *
	 */
	class SchoolTime{
		private int x;
		private int y;
		public SchoolTime () {
			// TODO Auto-generated constructor stub
		}
		public SchoolTime (int x,int y) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
		}
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
	}
	
	/**
	 * 构造函数
	 */
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 获取姓名
	 * @return 返回姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置姓名
	 * @param name 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取教室
	 * @return 返回教室
	 */
	public String getClassRoom() {
		return classRoom;
	}
	
	/**
	 * 设置教室
	 * @param classRoom 返回教室
	 */
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	/**
	 * 获取教师
	 * @return 返回教师
	 */
	public String getTeacher() {
		return teacher;
	}

	/**
	 * 设置教师
	 * @param teacher 教师
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * 获取上课时间
	 * @return 返回上课时间
	 */
	public String getClassTime() {
		return classTime;
	}

	/**
	 * 设置上课时间
	 * @param time 上课时间
	 */
	public void setClassTime(String time) {
		this.classTime = time;
		
	}

	/**
	 * 返回上课周数
	 * @return 上课周数
	 */
	public String getWeekNum() {
		return weekNum;
	}

	/**
	 * 设置上课周数
	 * @param weekNum 上课周数
	 */
	public void setWeekNum(String weekNum) {
		this.weekNum = weekNum;
	}
	
	/**
	 * 获取课程在课表的位置
	 * @return 课表的位置
	 */
	public SchoolTime getSchoolTime() {
		return schoolTime;
	}

	/**
	 * 设置课表位置
	 * @param schoolTime 课表位置
	 */
	public void setSchoolTime(SchoolTime schoolTime) {
		this.schoolTime = schoolTime;
	}
	
	/**
	 * 设置课表位置
	 * @param x 节数
	 * @param y 星期几
	 */
	public void setSchoolTime(int x,int y) {
		this.schoolTime = new SchoolTime(x,y);
	}
	
	/**
	 * 获取节数 
	 * @return 返回节数
	 */
	public int getX() {
		return schoolTime.getX();
	}
	
	/**
	 * 获取星期几
	 * @return 返回星期几
	 */
	public int getY() {
		return schoolTime.getY();
	}

}





















