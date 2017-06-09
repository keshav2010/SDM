package sdm.displaywindow;

import java.awt.Container;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import com.sun.javafx.tk.Toolkit;

//CFrame class stands for "Custom Frames", this class is child of JFrame class and can be used to build frames that comes with component attached
//GOOD for encapsulating large chunk of code into few lines
public class CFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	

	public CFrame(String title,int width,int height ,LayoutManager lyt,boolean Resizable){
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, width, height);
		this.getContentPane().setLayout(lyt);
		this.setVisible(true);	
		this.setResizable(Resizable);
	}
	public void reset(){
		this.getContentPane().removeAll();
	}
}
