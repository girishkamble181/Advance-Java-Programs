// draw chart, data from user and save as jpeg

import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.io.*;
import java.util.*;

class Student
{
	String name;
	int phy, chem, math;
	
	Student(String name, int phy, int chem, int math)
	{
		this.name = name;
		this.phy = phy;
		this.chem = chem;
		this.math = math;
	}
}

class A4 extends JFrame
{
	A4()
	{
		Console c = System.console();
		ArrayList<Student> stu = new ArrayList<>();

		String res = c.readLine("do u wish to enter some students y/n ");

		while (res.equals("y"))
		{
			String name = c.readLine("enter students name ");
			int phy = Integer.parseInt(c.readLine("enter phy "));
			int chem = Integer.parseInt(c.readLine("enter chem "));
			int math = Integer.parseInt(c.readLine("enter maths "));
			Student s = new Student(name, phy, chem, math);
			stu.add(s);
			res = c.readLine("do u wish to enter some students y/n ");
		}
		
		// s1 --> data set
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		for(Student d : stu)
		{
			ds.addValue(d.phy, d.name, "Phy");
			ds.addValue(d.chem, d.name, "Chem");
			ds.addValue(d.math, d.name, "Math");
		}

		// s2 --> design chart
		JFreeChart ch = ChartFactory.createBarChart("Student's Performance", "Subject", "Marks", ds,  PlotOrientation.VERTICAL, true, true, false);
		
		// s3 --> display chart
		ChartPanel cp = new ChartPanel(ch);
		setContentPane(cp);

		// s4 --> save the chart
		try
		{
			File f = new File("Students.jpeg");
			ChartUtilities.saveChartAsJPEG(f, ch, 500, 400);
		}
		catch(IOException e)
		{
			System.out.println("issue " + e);
		}

		setTitle("My First Chart App ");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class chart4_data_user_save
{
	public static void main(String args[])
	{
		new A4();
	}
}