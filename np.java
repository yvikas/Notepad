import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class np  implements ActionListener,KeyListener,MouseListener
{
	static Frame f,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10; 
	MenuBar mb;
	Panel p,p1,p2,p4;
	TextArea ta,ta1;
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
     	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
     	Label l,l1,l2,l3,l4,l5,lbl4,l6;
     	int flag=0,flag1=0,flag2=0,flag3=0,flag4=0,flag5=0,flag6=0;
     	int n=0,n1=0,n2=0,n3=0,n4=0,x,y,entry=0;
     	int index1,index2;
     	FileDialog fd;
     	String fileIteam[] = {"New","Open","Save","Save as","Exit"};
     	String editIteam[] = {"Cut","Copy","Paste","Find","Find & Replace"};
     	Dialog d,d1;
     	Pattern pa;
     	Matcher m;
	int a;
	boolean q;
	boolean o;
	 
	public void cl()
	{
		f.dispose();
	}
	public void ss()
		{
			
		try
            	{
                       		String path=fd.getDirectory();
                       		String name=fd.getFile();
                       		System.out.println(path+name);
                       		fd.setVisible(false);
                       		FileOutputStream fis = new FileOutputStream(path+"/"+name);
                       		String s=ta.getText();
                          	for (int j = 0; j < s.length(); j++)
                                {
                                  	char c = s.charAt(j);
                                  	fis.write(c);
                                }
                              	fis.close();
                              	f.setTitle(name);
	           
					
					
					
                  }
                  catch(Exception e1)
                  {
                 	e1.getMessage();
                  }
                  
	}
			
	 
	public void op()
	{
		
		try
            	{
            		fd=new FileDialog(f,"select",FileDialog.LOAD);
            		fd.setVisible(true);
                	String dir=fd.getDirectory();
                	String fname=fd.getFile();
                	FileInputStream fis=new FileInputStream(dir+fname);
                	DataInputStream dis=new DataInputStream(fis);
                	String str=" ",msg=" ";
                	while((str=dis.readLine())!=null)
                	{
                		msg=msg+str;
                    		msg+="\n";
                	}
               		ta.setText(msg);
                	dis.close();
            	}
            	catch(Exception e1)
            	{
                	e1.getMessage();
            	}
		
	 }
	 public void rpl()
	 {
		 String s;
            	 s = t1.getText();   
              	 pa = Pattern.compile(s);
            	 m = pa.matcher(ta.getText().replaceAll("\r", ""));
		 if (m.find(y))
		 {
                 	System.out.println("hello4");
    			s =t2.getText();
                        ta.replaceRange(s,x,y);
                        y = (x + s.length());
                        ta.select(x,y);
                        entry=0;
                        System.out.println("r");
                        f.toFront();
		  }
		  else
		  {
		  	dbox();
			entry=0;
		   }
						          
	 }
	 
	 public void rep()
	 {
		String s;        
                s = t1.getText();   
                pa = Pattern.compile(s);
                m = pa.matcher(ta.getText().replaceAll("\r", ""));
                System.out.println("hello2");
                System.out.println("find");
                if (m.find(y))
		{
                	System.out.println("hello3");
                	x = m.start();
                	y =m.end();
                 	ta.select(x,y);
                	System.out.println("f,,,,");
                  	entry=1;
			f.toFront();
                  }
              	else 
                {
			entry=0;
                }
						
	}
	
	public void save()
	{
		try
            	{
             		
                  		fd=new FileDialog(f,"SAVE",FileDialog.SAVE);
                            	fd.setVisible(true);
                 		String path=fd.getDirectory();
                 		String name=fd.getFile();
                 		System.out.println(path);
                		FileOutputStream fis = new FileOutputStream(path+"/"+name);
                 		String s=ta.getText();
                          	for (int j = 0; j < s.length(); j++)
                                {
                                	char c = s.charAt(j);
                                  	fis.write(c);
                                }
                                fis.close();
                                f.setTitle(name);
                  	
               
					
					
					
                  }
                  catch(Exception e1)
                  {
                 	e1.getMessage();
                  }
                  System.out.println("save"+flag);
	}
	
	public void end()
	{
		 f.setTitle("Untitled-Notepad");
         	 ta.setText("");
		 d.dispose();
	 }
	 public void ex()
	 {
		 System.exit(0);
	 }
	
		
	 public np()
	 {
		f=new Frame("Untitled-Notepad");
         	f.setSize(600,600);
	     	ta = new TextArea();
         	f.add(ta);
         	Menu m1 = new Menu("File");
         	Menu m2 = new Menu("Edit");
         	for(int i=0; i<fileIteam.length;i++)
         	{
			 MenuItem item = new MenuItem(fileIteam[i]);
			 m1.add(item);
			 item.addActionListener(this);
         	}
         	for(int i=0; i<editIteam.length;i++)
         	{
			 MenuItem item = new MenuItem(editIteam[i]);
			 m2.add(item);
			 item.addActionListener(this);
         	}
         	ta.addKeyListener(this);
         	ta.addMouseListener(this);
         	mb =new MenuBar();
         	mb.add(m1); mb.add(m2);
         	f.setMenuBar(mb);
         	f.setVisible(true);
        	f.addWindowListener(new WindowAdapter() 
		{
			 public void windowClosing(WindowEvent e) 
			 {	if(ta.getText().equals(""))
				 {
					 f.dispose();
				 }
				 else if(flag6==1)
				 {
					f.dispose();
				 }
				else
				{
					dialogOpen();
					 a=4;
				}
			 } 
		 });
     }
       
     public void actionPerformed(ActionEvent e)
     {
     	String com = e.getActionCommand();
    	System.out.println(com);
        if(com.equals("New"))
        {           
                 if(ta.getText().equals(""))
                { 
                	f.setTitle("Untitled-Notepad");
                  	ta.setText("");   
                 }
                else
                {
			 dialogOpen();
			 a=1;
		}
	}
	if(com.equals("Exit"))
        {
				if(ta.getText().equals(""))
				 {
					 f.dispose();
				 }
				 else if(flag6==1)
				 {
					f.dispose();
				 }
				else
				{
					dialogOpen();
					 a=4;
				}
            
        }
        if(com.equals("Open"))
        {
            	if(ta.getText().equals("")) 
		{       
            	try
            	{
            		fd=new FileDialog(f,"select",FileDialog.LOAD);
            		fd.setVisible(true);
                	String dir=fd.getDirectory();
                	String fname=fd.getFile();
                	FileInputStream fis=new FileInputStream(dir+fname);
                	DataInputStream dis=new DataInputStream(fis);
                	String str=" ",msg=" ";
                	while((str=dis.readLine())!=null)
                	{
                    		msg=msg+str;
                    		msg+="\n";
                	}
               		ta.setText(msg);
                	dis.close();
			a=5;
			
            	}
            	catch(Exception e1)
            	{
             		e1.getMessage();
            	}
			}
		
		else if(flag6==1)
		
		{       
            	try
            	{
            		fd=new FileDialog(f,"select",FileDialog.LOAD);
            		fd.setVisible(true);
                	String dir=fd.getDirectory();
                	String fname=fd.getFile();
                	FileInputStream fis=new FileInputStream(dir+fname);
                	DataInputStream dis=new DataInputStream(fis);
                	String str=" ",msg=" ";
                	while((str=dis.readLine())!=null)
                	{
                    		msg=msg+str;
                    		msg+="\n";
                	}
               		ta.setText(msg);
                	dis.close();
			a=5;
			
            	}
            	catch(Exception e1)
            	{
             		e1.getMessage();
            	}
			}
            	else
		{
              		dialogOpen();
			  a=2;
              
            	}

         }
         if(com.equals("Save"))
         { 
		if(a==1)
		{
			save();
			end();
			flag6=1;
		}
		else if(a==3)
		{
			save();
			ex();
			flag6=1;
		}
		else if(a==2)
		{
			save();
			op();
			flag6=1;
		}
		else if(a==4)
		{
			save();
			cl();
			flag6=1;
		}
		else if(a==5)
		{
			
                      ss(); 
			flag6=1;		
			}
		else
		{
			save();
			flag6=1;
		}
	}
	if(com.equals("Save as"))
        { 
		save();
	}
	if(com.equals("Find & Replace"))
	{
		findReplace();
        }
	if(com.equals("Find"))
        {
        	finddd();
        }
        if(com.equals("Cancel"))
        {
        	d.dispose();
        }
	if(com.equals("Don't save"))
        {
	if(a==1)
	{
		ta.setText("");
                System.out.println("hello");
                d.dispose();
	}
	else if(a==2)
	{
		d.dispose();
		op();
	}
	else if(a==3)
	{
		ex();
	}
	else if(a==4)
	{
		cl();
	}
	else
	{
		d.dispose();
	}
     }

				    
               if(com.equals("Find Next") || com.equals("Replace") || com.equals("Replace All") || com.equals("Cancel"))
               {
                
                     String s;
               
                       
                      s = t1.getText();   
               
            pa = Pattern.compile(s);
            m = pa.matcher(ta.getText().replaceAll("\r", ""));
                                    



                        if (com.equals("Find Next")){
							 
                System.out.println("hello2");
              System.out.println("find");
              if (m.find(y)){
                  System.out.println("hello3");
                   x = m.start();
                   y =m.end();
                   ta.select(x,y);
                   System.out.println("f,,,,");
                   entry=1;
				  q=true;
				   f.toFront();
                  }
              else 
                {
					dbox();
                  entry=0;
                  //JOptionPane.showMessageDialog(this,"Cannot Find  "+s+"...","Not Found",JOptionPane.PLAIN_MESSAGE);
              }
            } // if find 
            else if(com.equals("Replace")){
                         if(q==true)
						 {rpl();
								 rep();
						 }
						 else{
							 rep();
							 rpl();
							 
						 }
              }

                        else   if(com.equals("Replace All")) {          
                    if (!s.equals("")){
                         ta.setText(Pattern.compile(s).matcher(ta.getText()).replaceAll(t2.getText()));
                      }
                            }
					else if(com.equals("Cancel"))
                  {
                      //System.out.println("hello");
                      d.dispose();
                   }
				   



            }//find next replace replace all


          




         }//       
   public void mouseClicked(MouseEvent e)
  { 
          y = ta.getCaretPosition();
    System.out.println("position "+ta.getCaretPosition());
    System.out.print("clicked y=" + this.y);
  }
  
public void mouseEntered(MouseEvent e) {} 
public void mouseExited(MouseEvent e) {} 
public void mousePressed(MouseEvent e) {} 
public void mouseReleased(MouseEvent e) {}       



    
    public void keyPressed(KeyEvent k1)
    {
           n=ta.getCaretPosition();
         //   n1=ta.getCaretPosition();
           // n2=ta.getCaretPosition();
          // int i=jtps.getSelectedIndex();
       String s=f.getTitle();
      System.out.println("title name="+s);
       if(s.lastIndexOf("*")==-1)
        f.setTitle(s+"*");
        
    }
    public void keyReleased(KeyEvent k2)
    {}
    public void keyTyped(KeyEvent k3)
    {
              if(ta.getText().equals(""))
              {
                flag=0;
              }
              else
              {
                flag=1;
				o=true;
              }
          
     }
	 
	 
	  public void dbox()
  {
    
    final Dialog db=new Dialog(f,"Notepad");
     db.setSize(400,200);
     p=new Panel();
     p.setLayout(null);
     l=new Label("No Match Found");
     l.setFont(new Font("Serif",Font.PLAIN,15));
     b1=new Button("OK");
     b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { 
			db.dispose();
		}
	 });
    
     l.setBounds(50,30,250,20);
     b1.setBounds(50,100,70,25);
    p.add(l);p.add(b1);
     db.add(p);
     //d.addWindowListener(this);
     db.setVisible(true);
  //   d.setVisible(true);
   db.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
   db.dispose();
    } });
  
  }
	 
	 

     public void dialogOpen()
  {
    //flag2=1;
     d=new Dialog(f,"Notepad");
     d.setSize(400,200);
     p=new Panel();
     p.setLayout(null);
     l=new Label("Do you want to save this file ");
     l.setFont(new Font("Serif",Font.PLAIN,25));
     b1=new Button("Save");
     b1.addActionListener(this);
	 
     b2=new Button("Don't save");
     b2.addActionListener(this);
     b3=new Button("Cancel");
     b3.addActionListener(this);
     l.setBounds(50,30,250,20);
     b1.setBounds(50,100,70,25);
     b2.setBounds(150,100,70,25);
     b3.setBounds(250,100,75,25);
     p.add(l);p.add(b1);p.add(b2);p.add(b3);
     d.add(p);
	 a=5;
     //d.addWindowListener(this);
     d.setVisible(true);
  //   d.setVisible(true);
   d.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
   d.dispose();
    } });
  
  }
  public void finddd()
  {
    //flag2=1;
    final Dialog d1=new Dialog(f,"Notepad");
    d1.setSize(300,150);
    p=new Panel();
    p.setLayout(null);a=4;
   // l=new Label();
     l=new Label("Find what");
    t1 = new TextField(20);
    l.setFont(new Font("Serif",Font.PLAIN,20));
    b1=new Button("Find Next");
    b1.addActionListener(this);
    b2=new Button("Cancel");
    b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { 
			d1.dispose();
		}
	});
    l.setBounds(20,20,100,20);
    t1.setBounds(120,20,120,25);
    b1.setBounds(50,60,70,25);
    b2.setBounds(150,60,70,25);
    p.add(l);;p.add(b1);p.add(b2); p.add(t1);
    d1.add(p);
    //d.addWindowListener(this);
    d1.setVisible(true);
   d1.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
   d1.dispose();
    } });
  }
   


  public void findReplace()
  {
    //flag2=1;
     d=new Dialog(f,"Notepad");
     d.setSize(400,150);   //d.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
     p=new Panel();
     p.setLayout(null);
    // l=new Label();
     l=new Label("Find what: ");l.setFont(new Font("Serif",Font.PLAIN,16));
     l2=new Label("Replace With: ");l2.setFont(new Font("Serif",Font.PLAIN,16));
     t1= new TextField(20);
     t2= new TextField(20);
     b1=new Button("Find Next");
     b2=new Button("Replace");
     b3=new Button("Replace All");
     b4=new Button("Cancel");
     b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);
     b4.addActionListener(this);
     l.setBounds(15,15,100,20);
     l2.setBounds(15,40,110,25);
     t1.setBounds(135,15,120,23);
     t2.setBounds(135,40,120,23);
     b1.setBounds(10,80,70,25);
     b2.setBounds(100,80,70,25);
     b3.setBounds(180,80,70,25);
     b4.setBounds(260,80,70,25);
     p.add(l);p.add(l2);p.add(t1); p.add(t2);p.add(b1);p.add(b2);p.add(b3);p.add(b4);
     d.add(p);
	 a=6;
  //   //b4.addWindowListener(this);
		
     d.setVisible(true);
   d.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
   d.dispose();
    } });
	
   }

	public static void main(String args[])
	{
	 np ss= new np();
	}
}