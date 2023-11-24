// package com.irakozemaurice.controller;

// import java.io.IOException;
// import java.util.List;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.irakozemaurice.dao.CourseDao;
// import com.irakozemaurice.dao.TeacherDao;
// import com.irakozemaurice.model.Course;
// import com.irakozemaurice.model.Teacher;
// import com.irakozemaurice.model.TeacherRole;

// @WebServlet(name = "TeachersController", urlPatterns = "/admin-teachers")
// public class TeachersController extends HttpServlet {
// private static final long serialVersionUID = 1L;

// protected void doGet(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// TeacherDao teacherDao = new TeacherDao();
// List<Teacher> teacherList = teacherDao.getAll();

// CourseDao courseDao = new CourseDao();
// List<Course> courseList = courseDao.getAll();

// // Pass student list to jsp

// request.setAttribute("teacherList", teacherList);
// request.setAttribute("courseList", courseList);

// // display the students jsp page

// getServletContext().getRequestDispatcher("/admin-teachers.jsp").forward(request,
// response);
// }

// protected void doPost(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// // format date

// Teacher teacher = new
// Teacher(request.getParameter("name"),TeacherRole.valueOf(request.getParameter("role")),request.getParameter("qualification"));

// CourseDao courseDao = new CourseDao();
// String[] courses = request.getParameterValues("courses");
// for(String courseId : courses){
// Course course = courseDao.getById(Integer.parseInt(courseId));
// teacher.addCourse(course);
// }
// TeacherDao teacherDao = new TeacherDao();
// teacherDao.save(teacher);

// request.setAttribute("success", "Teacher saved successfully");

// doGet(request, response);

// // response.sendRedirect("/admin-au");

// }
// }
