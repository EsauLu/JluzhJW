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

import com.jluzh.jw.blean.Course;
import com.jluzh.jw.blean.CourseTable;

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
				p.setBackground(new Color(127, 209, 161));
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
	
	public void setCourseTable(ArrayList<Course> list,int n){
		m_course_list=list;
		m_week_num=n;
		updateCourseTable(m_week_num);
	}
	
	public void updateCourseTable(int n){
		for(int i=0;i<rowNum/2;i++){
			for(int j=0;j<columNum;j++){
				m_courses_table[i][j].setText("+");
			}
		}
		for(Course c:m_course_list){
			String weekNum=c.getTime();
			if(!judeWeek(weekNum, n)){
				continue;
			}
			int x=c.getX();
			int y=c.getY()%7;
			m_courses_table[x/2][y].setText(""
					+ "<html>"
					+ "<p>"+c.getName()+"</p>"
					+ "<p>"+c.getTime()+"</p>"
					+ "<p>"+c.getTeacher()+"</p>"
					+ "</html>");
		}
	}
	
	private boolean judeWeek(String week,int n) {
		// TODO Auto-generated method stub
		String pattern="(.*)(\\d+)-(\\d+)(.*)";
		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(week);
		String res="";
		if(m.find()){
			res=m.group(2);
			int begin=Integer.parseInt(res);
			
			res=m.group(3);
			int end=Integer.parseInt(res);
			
			if(n<begin||n>end){
				return false;
			}
			
			res=m.group(4);
			if(res.contains("周")){
				return true;
			}else if(res.contains("单周")&&n%2!=0){
				return true;
			}else if(res.contains("双周")&&n%2==0){
				return true;
			}
		}
		return true;
	}
	
}
















































