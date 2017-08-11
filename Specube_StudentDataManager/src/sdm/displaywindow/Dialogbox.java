package sdm.displaywindow;

import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JLabel;


import sdm.data.Student;


public class Dialogbox extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentDataViewer stdView;
	//private StudentDataViewer stdView;
	//This constructor builds up a special DialogBox that show data of studentData object
	public Dialogbox(String title,boolean resizable,Rectangle dimension,LayoutManager mgr,Student studentData,boolean modify){
		this.setTitle(title);
		stdView=new StudentDataViewer(studentData,modify);
		setResizable(resizable);
		setBounds(dimension);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	
	//	this.getContentPane().setLayout(mgr);
		add(stdView);
		pack();
		setVisible(true);
	}
	public Dialogbox(String title,boolean resizable,Rectangle dimension,LayoutManager mgr,String text){
		JLabel label = new JLabel(text);
		setTitle(title);
		setResizable(resizable);
		setBounds(dimension);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(mgr);
		label.setBounds(10,10,500,50);
		label.setVisible(true);
		this.getContentPane().add(label);
		setVisible(true);
		
		
	}
	public Dialogbox(String title,boolean resizable,Rectangle dimension,LayoutManager mgr){
		setTitle(title);
		setResizable(resizable);
		setBounds(dimension);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(mgr);
	}
	public void reset(){
		this.getContentPane().removeAll();
	}
	public void reset(String newtitle){
		setTitle(newtitle);
		reset();
	}
}
