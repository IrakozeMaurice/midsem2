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

// import com.irakozemaurice.dao.AUDao;
// import com.irakozemaurice.dao.StudentDao;
// import com.irakozemaurice.model.AcademicUnit;
// import com.irakozemaurice.model.Student;

// @WebServlet(name = "StudentsController", urlPatterns = "/admin-students")
// public class StudentsController extends HttpServlet {

// private static final long serialVersionUID = 1L;

// protected void doGet(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// // Get student list

// StudentDao studentDao = new StudentDao();
// List<Student> studentList = studentDao.getAll();

// AUDao auDao = new AUDao();
// List<AcademicUnit> auList = auDao.getAll();

// // Pass student list to jsp

// request.setAttribute("studentList", studentList);
// request.setAttribute("auList", auList);

// // display the students jsp page

// getServletContext().getRequestDispatcher("/admin-students.jsp").forward(request,
// response);
// }

// protected void doPost(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// // format date
// LocalDate dob = LocalDate.parse(request.getParameter("dob"),
// DateTimeFormatter.ISO_DATE);

// // create a new Student
// Student student = new Student(request.getParameter("student_id"),
// request.getParameter("names"), dob);

// // attach au
// AUDao audao = new AUDao();
// AcademicUnit academicUnit =
// audao.getById(Integer.parseInt(request.getParameter("academicUnit_id")));

// student.setAcademicUnit(academicUnit);

// // persist student
// StudentDao studentdao = new StudentDao();
// studentdao.save(student);

// request.setAttribute("success", "Student saved successfully");

// doGet(request, response);

// // response.sendRedirect("/admin-au");

// }
// }
