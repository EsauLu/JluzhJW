package com.jluzh.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
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
	private Color bgColor=new Color(204, 246, 255);
	
	private ArrayList<Course> m_course_list;
	private HashMap<String , Course> m_coourse_map;
	
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

		JPanel weekPanel=new JPanel(new GridLayout(1,columNum,3,3));
		weekPanel.setBorder(BorderFactory.createMatteBorder(10, 0, 10, 0, bgColor));
		weekPanel.setBackground(bgColor);
		m_week_table=new JLabel[columNum];
		for(int i=0;i<columNum;i++){
			JPanel p=new JPanel(new GridLayout());
			p.setBackground(bgColor);
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
		
		JPanel numPanel=new JPanel(new GridLayout(rowNum,1,3,3));
		numPanel.setBorder(BorderFactory.createMatteBorder(0, 10, 0, 10, bgColor));
		numPanel.setBackground(bgColor);
		m_num_table=new JLabel[rowNum];
		for(int i=0;i<rowNum;i++){
			JPanel p=new JPanel(new GridLayout());
			p.setBackground(bgColor);
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
		
		JPanel tablePanel=new JPanel(new GridLayout(rowNum/2, columNum,3,3));
		tablePanel.setBackground(bgColor);
		m_courses_table=new JLabel[rowNum/2][];
		for(int i=0;i<rowNum/2;i++){
			m_courses_table[i]=new JLabel[columNum];
			for(int j=0;j<columNum;j++){
				JPanel p=new JPanel(new GridLayout());
				p.setBackground(bgColor);
				m_courses_table[i][j]=new JLabel("+",JLabel.CENTER);
				p.add(m_courses_table[i][j]);
				tablePanel.add(p);
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
		
		this.setBackground(bgColor);
		
	}
	
	/**
	 * 设置课表
	 * @param list 课程列表
	 * @param n 周数
	 */
	public void setCourseTable(ArrayList<Course> list,int n){
		m_course_list=list;
		m_coourse_map=new HashMap<String, Course>();
		m_week_num=n;
		for(Course c:list){			
			int x=c.getNumber();
			int y=c.getDay()%7;
			m_coourse_map.put(String.valueOf(x/2)+","+String.valueOf(y), c);
//			System.out.println(String.valueOf(x/2)+","+String.valueOf(y)+" ===> "+c.getName());
//			m_coourse_map.
		}
		updateCourseTable(m_week_num);
	}
	
	/**
	 * 更新课表
	 * @param n 当前周
	 */
	public void updateCourseTable(int n){
		
		Color color1=new Color(161,206,250);
		Color color2=new Color(235, 235, 235);
		
		for(int i=0;i<rowNum/2;i++){
			for(int j=0;j<columNum;j++){
				m_courses_table[i][j].setText("+");
				m_courses_table[i][j].setForeground(Color.gray);
				m_courses_table[i][j].getParent().setBackground(new Color(225, 246, 255));
//				m_courses_table[i][j].getParent().setBackground(new Color(240, 240, 240));
			}
		}
		for(Course c:m_course_list){
			
			int x=c.getNumber();
			int y=c.getDay()%7;
			
//			if(n<c.getStartWeek()||n>c.getEndWeek()){
//				m_courses_table[x/2][y].getParent().setBackground(new Color(240, 240, 240));
//				continue;
//			}
			String text = "<html>"
					+ "<p>"+c.getName()+"</p>"
					+ "<p>"+c.getClassRoom()+"</p>"
					+ "<p>"+c.getTeacher()+"</p>"
					+ "</html>";

//			m_courses_table[x/2][y].setForeground(Color.black);
			if(m_courses_table[x/2][y].getText().equals("+")){
				m_courses_table[x/2][y].setText(text);
			}else{
				if(c.getWeekState()==Course.SINGLE_WEEK&&n%2!=0
						||c.getWeekState()==Course.DOUBLE_WEEK&&n%2==0){
					m_courses_table[x/2][y].setText(text);
				}else{
					continue;
				}
			}

			boolean f=true;
			if(n>=c.getStartWeek()&&n<=c.getEndWeek()){
				
				int state=c.getWeekState();
				switch(state){
					case Course.ALL_WEEK:
						m_courses_table[x/2][y].getParent().setBackground(color1);
						m_courses_table[x/2][y].setForeground(Color.black);
						f=false;
						break;
					case Course.SINGLE_WEEK:
						if(n%2!=0){
							m_courses_table[x/2][y].getParent().setBackground(color1);
							m_courses_table[x/2][y].setForeground(Color.black);
							f=false;
						}
						break;
					case Course.DOUBLE_WEEK:
						if(n%2==0){
							m_courses_table[x/2][y].getParent().setBackground(color1);
							m_courses_table[x/2][y].setForeground(Color.black);
							f=false;
						}
						break;
				}
			}
			
			if(f){
				m_courses_table[x/2][y].getParent().setBackground(color2);
			}

		}
	}
	
}
















































