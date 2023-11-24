// package com.irakozemaurice.controller;

// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.List;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.google.gson.Gson;
// import com.irakozemaurice.dao.AUDao;
// import com.irakozemaurice.model.AcademicUnit;

// @WebServlet(name = "AUControllerData", urlPatterns = "/admin-au-api")
// public class AUControllerData extends HttpServlet {

// private Gson gson = new Gson();

// private static final long serialVersionUID = 1L;

// protected void doGet(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// // Get a list of Academic units
// AUDao auDao = new AUDao();
// List<AcademicUnit> auList = auDao.getAll();

// String data = this.gson.toJson(auList);

// PrintWriter out = response.getWriter();
// response.setContentType("application/json");
// response.setCharacterEncoding("UTF-8");
// out.print(data);
// out.flush();

// }
// }
