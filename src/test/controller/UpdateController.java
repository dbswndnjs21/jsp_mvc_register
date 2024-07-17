package test.controller;

import test.dao.UpdateDao;
import test.dto.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/update")
public class UpdateController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 파라미터 값 받아오기
        String id = request.getParameter("id");
        // db에서 해당 정보 조회하기
        UpdateDao dao = new UpdateDao();
        Member m = dao.select(id);
        // 조회된 결과를 스코프에 담기
        request.setAttribute("member", m);
        // 뷰 페이지로 이동
        request.getRequestDispatcher("/member/update.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        int iage = Integer.parseInt(age);
        
        UpdateDao dao = new UpdateDao();
        Member member = new Member(id, pwd, email, iage, null);
        int n = dao.update(member);

        if (n == 1) {
            req.setAttribute("msg", "회원정보 수정 완료");
        } else {
            req.setAttribute("msg", "오류로 인한 정보 수정 실패");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/member/result.jsp");
        rd.forward(req, resp);
    }
}
