package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatServer
 */
@WebServlet("/ChatServer")
public class ChatServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArrayList<ChatEntry> chatwork;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServer() {
        super();
        // TODO Auto-generated constructor stub
        chatwork = new ArrayList<ChatEntry>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		for(ChatEntry ce : chatwork){
			out.println(ce.getNick() + ": " + ce.getMessage());
		}
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String nick = request.getParameter("nickname");
		String message = request.getParameter("message");
		
		ChatEntry ce = new ChatEntry(nick, message);
		chatwork.add(ce);
	}

}
