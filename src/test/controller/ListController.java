package test.controller;

import test.dao.ListDao;
import test.dto.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/member/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
        if (id == null) {
            resp.sendRedirect(req.getContextPath() + "/member/login.jsp");
        } else {
            ListDao dao = new ListDao();
            ArrayList<Member> list = dao.select();
            req.setAttribute("list", list);
            req.getRequestDispatcher("list.jsp").forward(req, resp);
        }
    }
}
