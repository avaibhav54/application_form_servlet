import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text.html");
		PrintWriter out=resp.getWriter();
		out.println("<h1> welcome </h1>");
		String name=req.getParameter("user_name");
		String password=req.getParameter("user_password");
		String mail=req.getParameter("user_mail");
		String gender=req.getParameter("user_gender");
		String course=req.getParameter("user_courde");
		String cond=req.getParameter("condition");
		if(cond!=null)
		{
			out.println("<h2> Name::"+name+"</h2>");
			out.println("<h2> Password::"+password+"</h2>");
			out.println("<h2> Mail::"+mail+"</h2>");
			out.println("<h2> Gender::"+gender+"</h2>");
			out.println("<h2> your selected course is ::::"+course+"</h2>");
			
			//let us asume we have saved the data here in a database now we will print success message using forward method oh request dispatcher
		RequestDispatcher rd=req.getRequestDispatcher("success");
		rd.forward(req, resp);
		
		}
		else
		{
			out.println("<h2> you have not accepted terms and condition</h2>");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		
		
		
	}
	
	

}
