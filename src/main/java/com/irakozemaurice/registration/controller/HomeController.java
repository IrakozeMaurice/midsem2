// package com.irakozemaurice.controller;

// import java.io.IOException;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// @WebServlet(name = "HomeController", urlPatterns = "/admin-home")
// public class HomeController extends HttpServlet {
// private static final long serialVersionUID = 1L;

// protected void doGet(HttpServletRequest request, HttpServletResponse
// response) throws ServletException, IOException {
// getServletContext().getRequestDispatcher("/admin-home.jsp").forward(request,
// response);
// }

// protected void doPost(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {
// // create a user account
// // User user = new
// User(Integer.parseInt(request.getParameter("student_id")),request.getParameter("password"));

// // create a student
// // Student student = new
// Student(Integer.parseInt(request.getParameter("student_id")),
// // request.getParameter("firstname"),request.getParameter("lastname"),
// // request.getParameter("faculty"),request.getParameter("department"),
// // request.getParameter("address"),request.getParameter("phone_number"),
// // request.getParameter("email"),photo,diploma);

// // student.setUser(user);

// // persist data
// // UserDao userDao = new UserDao();
// // userDao.save(user);
// //
// // StudentDao studentDao = new StudentDao();
// // studentDao.save(student);

// //
// getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request,
// response);
// response.sendRedirect("/home");

// }
// }
