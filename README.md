# javaweb - Servlet과 Request, Response

## 📅 목차

- [2025-07-17](#2025-07-17)
- [2025-07-18](#2025-07-18)

<br><br><br>
# 2025-07-17

## 📘 Java - Servlet

---

### ✅ Servlet이란?

- 자바 기반의 서버 사이드 프로그래밍 기술  
- 웹 서버에서 동적으로 웹 콘텐츠를 생성하기 위해 사용  
- HTTP 요청을 받아 처리하고, 응답을 생성하여 클라이언트에 전달

---

### ✅ Servlet 주요 메서드

- `init()` : 서블릿 초기화 시 호출 (서버 시작 시 1회)  
- `service()` : 클라이언트 요청 시 호출, 요청 타입에 따라 `doGet()`, `doPost()` 등으로 분기  
- `doGet()` : HTTP GET 요청 처리  
- `doPost()` : HTTP POST 요청 처리  
- `destroy()` : 서블릿 종료 시 호출 (서버 종료 시 1회)

---

### ✅ 기본 서블릿 코드 예시

    import java.io.IOException;
    import javax.servlet.*;
    import javax.servlet.http.*;

    public class MyServlet extends HttpServlet {

        @Override
        public void init() throws ServletException {
            // 초기화 코드
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h1>Hello Servlet</h1>");
        }

        @Override
        public void destroy() {
            // 종료 시 처리
        }
    }

---
📅[목차로 돌아가기](#-목차)
<br><br><br>
# 2025-07-18

## 📘 Java - Request와 Response

---

### ✅ Request란?

- 클라이언트가 서버로 보내는 요청 정보  
- HTTP 메서드(GET, POST 등), 요청 URL, 헤더, 파라미터, 바디 등을 포함  
- `HttpServletRequest` 객체를 통해 접근 가능

---

### ✅ Request 주요 기능

- `getParameter(String name)` : 요청 파라미터 값 가져오기  
- `getMethod()` : HTTP 메서드(GET, POST 등) 반환  
- `getHeader(String name)` : 요청 헤더 값 가져오기  
- `getSession()` : 세션 객체 가져오기

---

### ✅ Response란?

- 서버가 클라이언트에게 보내는 응답 정보  
- 상태 코드, 응답 헤더, 바디(HTML, JSON 등)를 포함  
- `HttpServletResponse` 객체를 통해 제어

---

### ✅ Response 주요 기능

- `setContentType(String type)` : 응답 콘텐츠 타입 설정  
- `setStatus(int sc)` : HTTP 상태 코드 설정  
- `getWriter()` : 응답 본문 출력용 PrintWriter 객체 반환  
- `sendRedirect(String location)` : 클라이언트 리다이렉트

---

### ✅ 사용 예시 (Servlet 내)

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>안녕하세요, " + name + "님!</h1>");
    }

---
📅[목차로 돌아가기](#-목차)
<br><br><br>
