// package com.irakozemaurice.controller;

// import java.io.IOException;
// import java.util.List;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.irakozemaurice.dao.CourseDao;
// import com.irakozemaurice.model.Course;

// @WebServlet(name = "CoursesController", urlPatterns = "/admin-courses")
// public class CoursesController extends HttpServlet {
// private static final long serialVersionUID = 1L;

// protected void doGet(HttpServletRequest request, HttpServletResponse
// response) throws ServletException, IOException {

// // Get AU list

// CourseDao courseDao = new CourseDao();
// List<Course> courseList = courseDao.getAll();

// // Pass au list to jsp

// request.setAttribute("courseList", courseList);

// // display the au jsp page

// getServletContext().getRequestDispatcher("/admin-courses.jsp").forward(request,
// response);
// }

// protected void doPost(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// // create a new Student
// Course course = new Course(request.getParameter("code"),
// request.getParameter("name"),
// request.getParameter("description"),Integer.parseInt(
// request.getParameter("credits")));

// CourseDao courseDao = new CourseDao();
// courseDao.save(course);

// request.setAttribute("success", "Course saved successfully");

// doGet(request, response);

// }
// }
