/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tausif
 */
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.util.Random;
import javax.swing.JFrame;

public class Lab02 implements GLEventListener{
   
	private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      
      //DRAWING 6
      
      DDA(gl, 0,0,0,50);
      DDA(gl, 25,0,25,25);
      DDA(gl, 0,0,25,0);
      DDA(gl, 0,25,25,25);
      DDA(gl, 0,50,25,50);
         
      //DRAWING 7
      
      DDA(gl, 30,50,55,50);
      DDA(gl, 55,0,55,50);
      
   }
   @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }
   
   @Override
   public void init(GLAutoDrawable gld) {
       GL2 gl = gld.getGL().getGL2();
       glu = new GLU();

       gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
       gl.glViewport(-100, -50, 50, 100);
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
       glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
   }

   

   @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   
   
   public void DDA(GL2 gl, float x1, float y1, float x2, float y2) {
       
       gl.glPointSize(3.0f);
       gl.glColor3d(1, 0, 0);
       
     //write your own code
       
       gl.glBegin (GL2.GL_POINTS);//static field
       
       float delX = x2-x1;
       float delY = y2-y1;
       
       float x1Copy = x1;
       float y1Copy = y1;
       float x2Copy = x2;
       float y2Copy = y2;
       
       float m = (delY/delX);
       
       if (m<1 && m >-1){
            
           
           for (float i=x1; i<x2; i++){
               
               x1Copy = x1Copy+1;
               y1Copy = y1Copy+m;
               
               gl.glVertex3f(x1Copy,y1Copy,0);
               
           }
           
           
           
       }
       else{
           
           for (float i=y1; i<y2; i++){
               
               y1Copy = y1Copy+1;
               x1Copy = x1Copy+(1/m);
               
               gl.glVertex3f(x1Copy,y1Copy,0);
               
           }
       }
       
       
       
       
       
      
      
    	  //float x = r.nextFloat()*(max-min)+min;
    	  //float y = r.nextFloat()*(max-min)+min;
    	  
    	  //gl.glVertex3f(x,y,0);
      
      
//      gl.glVertex3f(0.50f,-0.50f,0);
//      gl.glVertex3f(-0.50f,0.50f,0);
        gl.glEnd();
    }

   
   
   
   
   
   public static void main(String[] args) {
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
      // The canvas 
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      Lab02 l = new Lab02();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(400, 400);
      //creating frame
      final JFrame frame = new JFrame ("straight Line");
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
   }//end of main
}//end of classimport javax.media.opengl.GL2;

