package financelogin;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			    response.setContentType("text/html");
			   
			 
			     // Read the request body
		        StringBuilder body = new StringBuilder();
		        try (BufferedReader reader = request.getReader()) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                body.append(line).append("\n");
		            }
		        }
		        
		        
		        JSONObject inputData = new JSONObject(body.toString());
		        
		        String name = inputData.getString("name");
		        String password = inputData.getString("password");
		        
		        
		        JSONObject responseObj = new JSONObject();
		        
		        
		        if("bliss".equals(name) && "bliss".equals(password)) {
		        	responseObj.put("status", true);
		        } else {
		        	responseObj.put("status", false);
		        }
		        
		        PrintWriter out = response.getWriter();
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        out.print(responseObj);
		        out.flush();
		        out.close();
				
			}
		}

	}

}
