package app.labs.servlet.basic;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

/**
 * Servlet implementation class CalcServlet2
 */
@WebServlet("/servlet/CalcServlet2")
public class CalcServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력 : null 처리가 중요		
		// ofNullable : null이 아니면 값을 전달, null이면 empty전달
		int num1 = Optional.ofNullable(request.getParameter("num1"))
					.map(Integer::parseInt)
					.orElse(0);		
		String op = Optional.ofNullable(request.getParameter("operator"))
					.orElse("+");		
		int num2 = Optional.ofNullable(request.getParameter("num2"))
					.map(Integer::parseInt)
					.orElse(0);
		
		// 연산(Biz)
		CalcService calc = new CalcService(num1, num2, op);
		int result = calc.getResult();
		
		// 출력 - 제어넘김
		RequestDispatcher rd = request.getRequestDispatcher("calc2.jsp");
		request.setAttribute("result", Integer.toString(result));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}