package com.jluzh.control;

import java.awt.Image;

import com.jluzh.jw.bean.Course;
import com.jluzh.jw.bean.CourseTable;
import com.jluzh.jw.bean.User;
import com.jluzh.jw.dao.HttpDAO;
import com.jluzh.jw.dao.HttpService;
import com.jluzh.view.LoginFrame;
import com.jluzh.view.MainFream;

/**
 * 控制器类
 * @author EsauLu
 *
 */
public class Controller {

	/**
	 * 登录界面
	 */
	private LoginFrame mLoginFrame;

	/**
	 * 主界面
	 */
    private MainFream mMainFream;
   
    /**
     * 获取数据的类
     */
    private HttpDAO mHttpDAO;

    /**
     * 构造函数
     */
    public Controller() {
      // TODO: implement
	   
    	init();
//    	mHttpDAO.init();
    	mLoginFrame.setVisible(true);
    	mLoginFrame.showCheckImg();
	   
    }
    
    //初始化
    private void init() {
	// TODO Auto-generated method stub		   
    	mLoginFrame=new LoginFrame(this);
	   	mMainFream=new MainFream(this);
	   	mHttpDAO=new HttpService();
    }
   
    /**
     * 登陆
     * @param user 登陆用户信息
     * @return 返回登陆是否成功
     */
    public boolean login(User user) {
    	if(mHttpDAO.login(user)){
    		return true;
    	}
    	return false;
    }
   
    /**
     * 获取验证码
     * @return 返回验证码图片对象
     */
    public Image getCheckImg() {
    	return mHttpDAO.getCheckImg();
    }
	   
    /**
     * 打开主界面
     */
	public void openMainFream() {		   

		mMainFream.setVisible(true);
		CourseTable ct=mHttpDAO.getCourseTable(null,null);	
		mMainFream.showCourseTable(ct);
		mMainFream.setXndOrXqdComb(ct.getXnd(), ct.getXqd());
	}
	
	/**
	 * 查询并显示课表
	 * @param xnd 学年度
	 * @param xqd 学期
	 */
	public void qureyCourseTable(String xnd,String xqd){
		CourseTable ct=mHttpDAO.getCourseTable(xnd,xqd);

		mMainFream.showCourseTable(ct);
	}
	   
	/**
	 * 打开成绩页面
	 */
	public void openScoreFrame() {
    }
	   
	/**
	 * 打开个人信息页面
	 */
	public void openPersonalFrame() {
    }
	   
	/**
	 * 获取登陆错误信息
	 * @return 返回错误信息
	 */
	public String getErrorMessege(){
		   return mHttpDAO.getErrorMessege();
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
