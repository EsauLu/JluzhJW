package com.jluzh.jw.factor;

import com.jluzh.jw.blean.Course;

/**
 * Bean工厂
 * @author EsauLu
 *
 */
public class BleanFactor {
	
	/**
	 * 创建课程对象
	 * @param info 课程信息
	 * @param x 第x节课
	 * @param y 星期y
	 * @return 返回课程对象
	 */
	public static Course createCourse(String[] info,int x,int y){
		Course c=new Course();		
		c.setName(info[0]);
		
		String[] t=(" "+info[1]).split("\\{");		
		c.setTime(t[0].trim());//上课时间
		c.setWeekNum(t[1].substring(0, t[1].length()-1));//周数

		c.setTeacher(info[2]);
		c.setClassRoom(info[3]);
		c.setSchoolTime(x, y);
		
		return c;
	}
}


















































