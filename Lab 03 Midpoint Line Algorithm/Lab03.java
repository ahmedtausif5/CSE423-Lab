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
import java.lang.Math;
import javax.swing.JFrame;

public class Lab03 implements GLEventListener{
   
	private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
          
      
      //DRAWING 6
      Midpoint(gl, 10,25,0,0);
      Midpoint(gl, 10,25,30,25);
      Midpoint(gl, 5,12,25,12);
      Midpoint(gl, 25,12,20,0);
      Midpoint(gl, 0,0,20,0);
      
      
      //DRAWING 7
      Midpoint(gl, 35,25,55,25);
      Midpoint(gl, 45,0,55,25);
      
      
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
   
   
  

   
   public int findZone (float x1, float y1, float x2, float y2){
       
       float dx = x2-x1;
       float dy = y2-y1;
       
       
       
       if (Math.abs(dx)>Math.abs(dy)){
           
           if ((dx>0)&&(dy>0)){
               return 0;
           }
           if ((dx<0)&&(dy>0)){
               return 3;
           }
           if ((dx<0)&&(dy<0)){
               return 4;
           }
           if ((dx>0)&&(dy<0)){
               return 7;
           }
           
       }else{
           
           if ((dx>0)&&(dy>0)){
               return 1;
           }
           if ((dx<0)&&(dy>0)){
               return 2;
           }
           if ((dx<0)&&(dy<0)){
               return 5;
           }
           if ((dx>0)&&(dy<0)){
               return 6;
           }                              
       }
                  
       return 0;
       
   }
   
   public float [] convertToZone_0 (float [] coordinate, int zone){
       float X = coordinate[0];
       float Y = coordinate[1];
       
       float x;
       float y;
       float [] coordinate2 = new float [2];
       
       if (zone == 0){
           x = X;
           y = Y;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 1){
           
           x = Y;
           y = X;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 2){
           
           x = Y;
           y = -X;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 3){
           
           x = -X;
           y = Y;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 4){
           
           x = -X;
           y = -Y;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 5){
           
           x = -Y;
           y = -X;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 6){
           
           x = -Y;
           y = X;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
           
       }else{
           
           x = X;
           y = -Y;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }
       
       
   }
   
   
      public float [] convertToZone_M (float [] coordinate, int zone){
       float X = coordinate[0];
       float Y = coordinate[1];
       
       float x;
       float y;
       float [] coordinate2 = new float [2];
       
       if (zone == 0){
           x = X;
           y = Y;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 1){
           
           x = Y;
           y = X;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 2){
           
           x = -Y;
           y = X;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 3){
           
           x = -X;
           y = Y;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 4){
           
           x = -X;
           y = -Y;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 5){
           
           x = -Y;
           y = -X;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }else if (zone == 6){
           
           x = Y;
           y = -X;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
           
       }else{
           
           x = X;
           y = -Y;
           coordinate2[0]=x;
           coordinate2[1]=y;
           return coordinate2;
           
       }
       
       
   }
      
      
      
      public void Midpoint(GL2 gl, float x1, float y1, float x2, float y2) {
       
       gl.glPointSize(3.0f);
       gl.glColor3d(1, 0, 0);
       
  
       
       gl.glBegin (GL2.GL_POINTS);
       
       
       int zone;
       float []converted_Zone_0_starting_point;
       float []converted_Zone_0_ending_point;
       
       // finding zone
       zone = findZone(x1, y1, x2, y2);
       
       
       //converting to zone zero
       float [] startingPoint = {x1,y1};
       float [] endingPoint = {x2,y2};
       
       converted_Zone_0_starting_point = convertToZone_0(startingPoint, zone);
       converted_Zone_0_ending_point =  convertToZone_0(endingPoint, zone);   

           
       //Mid Point Algo using zone 0
       float x1_prime = converted_Zone_0_starting_point[0];
       float y1_prime = converted_Zone_0_starting_point[1];
       
       float x2_prime = converted_Zone_0_ending_point[0];
       float y2_prime = converted_Zone_0_ending_point[1];
       
       float dx_prime = x2_prime - x1_prime;
       float dy_prime = y2_prime - y1_prime;
       
       float D = (2*dy_prime)-dx_prime;
       float del_NE = 2*(dy_prime-dx_prime);
       float del_E = 2*dy_prime;
       
               
       float x = x1_prime;
       float y = y1_prime;
               
       while (x<x2_prime){
           float [] ccc = {x,y};
           float [] ccc2 = new float [2];
           ccc2 = convertToZone_M(ccc,zone);
           float xx = ccc2 [0];
           float yy = ccc2[1];
           gl.glVertex3f(xx,yy,0);
           
           
           x++;
           
           if (D>0){
               y++;
               D = D + del_NE;
           }else{
               D = D + del_E;
           }
           
       }
       
       
       

      
       //gl.glVertex3f(x1Copy,y1Copy,0);
       gl.glEnd();
    }   
   
   
   
   
   
   public static void main(String[] args) {
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
      // The canvas 
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      Lab03 l = new Lab03();
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

