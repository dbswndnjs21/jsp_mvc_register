package test.controller;

import test.dao.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        LoginDao dao = new LoginDao();
        HashMap<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("pwd",pwd);
        boolean result = dao.isMember(map);
        if (result) {  // 계정 정보와 맞을 경우
            HttpSession session = req.getSession();
            session.setAttribute("id",id);
            resp.sendRedirect(req.getContextPath()+"/home.jsp");
        } else { // 틀린 경우
            req.setAttribute("msg","로그인 정보가 맞지 않습니다");
            // request 에 setAttribute 담았기 때문에 반드시 forward 방식으로 보내야함
            req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
        }
    }
}
