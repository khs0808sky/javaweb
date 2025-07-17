package app.labs.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/servlet/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request: 클라이언트가 전달한 정보를 받을 때 사용. String형이 기본이다.
		int num1 = Integer.parseInt(request.getParameter("num1"));
		String op = request.getParameter("operator");
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		// 연산(Biz)
		/*
		int result = 0;
		
		if (op.equals("+")) {
			result = num1 + num2;
		} 
		else if (op.equals("-")) {
			result = num1 - num2;
		} 
		else if (op.equals("*")) {
			result = num1 * num2;
		} 
		else if (op.equals("/")) {
			result = num1 / num2;
		}*/
		CalcService calc = new CalcService(num1, num2, op);
		int result = calc.getResult();
		
		// 출력
		response.setContentType("text/html;charset=UTF-8"); // application/json

        PrintWriter out = response.getWriter();

        String html = "<html>";
        html += "<head><title>계산결과</title></head>";
        html += "<body><h1>계산결과</h1><h3>" + num1 + op + num2 + "=" + result + "</h3></body>";
        html += "</html>";

        out.println(html);
        out.close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
