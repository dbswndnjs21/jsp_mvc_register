package test.controller;

import test.dao.MemberDao;
import test.dto.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/join")
public class JoinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/member/join.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 전송된 데이터를 DB에 저장하기
        // 결과를 응답하기
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        int iage = Integer.parseInt(age);

        MemberDao dao = new MemberDao();
        Member member = new Member(id,pwd,email,iage,null);

        int n = dao.insert(member);
        if (n == 1) {
            request.setAttribute("msg", "회원가입 완료");
        } else {
            request.setAttribute("msg", "오류오 인한 회원 가입 실패");
        }
        // 여기서 이동할땐 forward로 이동해서 contextPath를 안써줘도 됨
        RequestDispatcher rd = request.getRequestDispatcher("/member/result.jsp");
        rd.forward(request, response);
    }
}
