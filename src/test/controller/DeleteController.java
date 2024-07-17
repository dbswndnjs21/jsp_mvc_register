package test.controller;

import test.dao.DeleteDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/member/delete")
public class DeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
//        System.out.println(id);
        DeleteDao dao = new DeleteDao();
        int delete = dao.delete(id);

        if (delete == 1) {
//            req.setAttribute("msg", "삭제 완료");
            resp.sendRedirect(req.getContextPath() + "/member/list");
        } else {
            req.setAttribute("msg", "오류오 인한 회원 삭제 실패");
            RequestDispatcher rd = req.getRequestDispatcher("/member/delete.jsp");
            rd.forward(req, resp);
        }

    }
}
