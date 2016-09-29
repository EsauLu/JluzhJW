package com.jluzh.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jluzh.jw.bean.Course;
import com.jluzh.jw.bean.CourseTable;

public class CourseTablePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int m_week_num;
	private int rowNum;
	private int columNum;
	private JLabel[] m_num_table;
	private JLabel[] m_week_table;
	private JLabel[][] m_courses_table;
	
	private ArrayList<Course> m_course_list;
	
	private String[] weekStr={"周日","周一","周二","周三","周四","周五","周六"};
	
	public CourseTablePanel(int r,int c) {
		// TODO Auto-generated constructor stub
		this.rowNum=r;
		this.columNum=c;
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub	

		GridBagLayout layout=new GridBagLayout();
		GridBagConstraints cs=new GridBagConstraints();
		this.setLayout(layout);

		JPanel weekPanel=new JPanel(new GridLayout(1,columNum,5,5));
		weekPanel.setBorder(BorderFactory.createMatteBorder(10, 0, 10, 0, Color.white));
		m_week_table=new JLabel[columNum];
		for(int i=0;i<columNum;i++){
			JPanel p=new JPanel(new GridLayout());
//			p.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
			m_week_table[i]=new JLabel(weekStr[i],JLabel.CENTER);
			p.add(m_week_table[i]);
			weekPanel.add(p);
		}		
		cs.gridx=1;
		cs.gridy=0;
		cs.anchor=GridBagConstraints.CENTER;
		cs.fill=GridBagConstraints.BOTH;
		layout.setConstraints(weekPanel, cs);
		this.add(weekPanel);
		
		JPanel numPanel=new JPanel(new GridLayout(rowNum,1,5,5));
		numPanel.setBorder(BorderFactory.createMatteBorder(0, 10, 0, 10, Color.WHITE));
		m_num_table=new JLabel[rowNum];
		for(int i=0;i<rowNum;i++){
			JPanel p=new JPanel(new GridLayout());
//			p.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
			m_num_table[i]=new JLabel(String.valueOf(i+1),JLabel.CENTER);
			p.add(m_num_table[i]);
			numPanel.add(p);
		}
		cs.gridx=0;
		cs.gridy=1;
		cs.anchor=GridBagConstraints.CENTER;
		cs.fill=GridBagConstraints.BOTH;
		layout.setConstraints(numPanel, cs);
		this.add(numPanel);		
		
		JPanel tablePanel=new JPanel(new GridLayout(rowNum/2, columNum,5,5));
//		tablePanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		m_courses_table=new JLabel[rowNum/2][];
		for(int i=0;i<rowNum/2;i++){
			m_courses_table[i]=new JLabel[columNum];
			for(int j=0;j<columNum;j++){
				JPanel p=new JPanel(new GridLayout());
				p.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
				m_courses_table[i][j]=new JLabel("+",JLabel.CENTER);
				p.add(m_courses_table[i][j]);
				tablePanel.add(p);
//				tablePanel.add(m_courses_table[i][j]);
			}
		}
		cs.gridx=1;
		cs.gridy=1;
		cs.weightx=1;
		cs.weighty=1;
		cs.anchor=GridBagConstraints.CENTER;
		cs.fill=GridBagConstraints.BOTH;
		layout.setConstraints(tablePanel, cs);		
		this.add(tablePanel);
		
	}
	
	/**
	 * 设置课表
	 * @param list 课程列表
	 * @param n 周数
	 */
	public void setCourseTable(ArrayList<Course> list,int n){
		m_course_list=list;
		m_week_num=n;
		updateCourseTable(m_week_num);
	}
	
	/**
	 * 更新课表
	 * @param n 当前周
	 */
	public void updateCourseTable(int n){
		for(int i=0;i<rowNum/2;i++){
			for(int j=0;j<columNum;j++){
				m_courses_table[i][j].setText("+");
//				m_courses_table[i][j].getParent().setBackground(new Color(127, 209, 161));
				m_courses_table[i][j].getParent().setBackground(new Color(225, 225, 225));
			}
		}

		for(Course c:m_course_list){

			if(n<c.getStartWeek()||n>c.getEndWeek()){
//				m_courses_table[i][j].getParent().setBackground(new Color(250,250,250));
				continue;
			}
			int weekState=c.getWeekState();
			if(weekState!=Course.ALL_WEEK){
				if(n%2!=0&&weekState==Course.DOUBLE_WEEK){
					continue;
				}				
				if(n%2==0&&weekState==Course.SINGLE_WEEK){
					continue;
				}
			}			
//			m_courses_table[i][j].getParent().setBackground(new Color(127, 209, 170));

			int x=c.getNumber();
			int y=c.getDay()%7;
			m_courses_table[x/2][y].setText(""
					+ "<html>"
					+ "<p>"+c.getName()+"</p>"
					+ "<p>"+c.getClassTime()+"</p>"
					+ "<p>"+c.getTeacher()+"</p>"
					+ "</html>");
		}
	}
	
}
















































