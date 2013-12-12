package com.samara.mentoring.bookcms.servlet;

import java.io.IOException;
import java.util.concurrent.Future;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samara.mentoring.bookcms.ejb.AsyncTask;
import com.samara.mentoring.bookcms.ejb.Timer;
import com.samara.mentoring.bookcms.service.BookService;

/**
 * Servlet for start page
 *
 * @author ninjafrombox@users.noreply.github.com
 */
@SuppressWarnings("serial")
@WebServlet("/")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = "ldapUser"))
public class IndexServlet extends HttpServlet {
    @Inject
    private Timer timerBean;
    @Inject
    private AsyncTask asyncBean;
    @Inject
    private BookService bookService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        asyncBean.doLongWork();
        Future<String> result = asyncBean.getImportantInfo();
        try { Thread.sleep(1); } catch (InterruptedException e) { }
        String info = "UNKNOWN";
        if (result.isDone()) try { info = result.get(); } catch (Exception e) { }
        req.setAttribute("info", info);
        req.setAttribute("lifeTime", timerBean.getLifeTime());
        req.setAttribute("books", bookService.getAllBooks());
        RequestDispatcher resultView = req.getRequestDispatcher("hello.jsp");
        resultView.forward(req, resp);
    }
}
