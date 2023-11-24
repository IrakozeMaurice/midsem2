// package com.irakozemaurice.controller;

// import java.io.IOException;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.util.List;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.irakozemaurice.dao.SemesterDao;
// import com.irakozemaurice.model.Semester;
// import com.irakozemaurice.model.SemesterType;

// @WebServlet(name = "SemestersController", urlPatterns = "/admin-semesters")
// public class SemestersController extends HttpServlet {
// private static final long serialVersionUID = 1L;

// protected void doGet(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// SemesterDao semesterDao = new SemesterDao();
// List<Semester> semesterList = semesterDao.getAll();

// // Pass student list to jsp

// request.setAttribute("semesterList", semesterList);

// // display the students jsp page

// getServletContext().getRequestDispatcher("/admin-semesters.jsp").forward(request,
// response);
// }

// protected void doPost(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// // format date
// LocalDate start = LocalDate.parse(request.getParameter("start"),
// DateTimeFormatter.ISO_DATE);
// LocalDate end = LocalDate.parse(request.getParameter("end"),
// DateTimeFormatter.ISO_DATE);
// SemesterType type = SemesterType.valueOf(request.getParameter("type"));
// String name = request.getParameter("type") + "_"
// +request.getParameter("start")+ "_" + request.getParameter("end");

// // create a new Student
// Semester semester = new Semester(name,type,start,end);

// // persist student
// SemesterDao semesterDao = new SemesterDao();
// semesterDao.save(semester);

// request.setAttribute("success", "Semester saved successfully");

// doGet(request, response);

// // response.sendRedirect("/admin-au");

// }
// }
