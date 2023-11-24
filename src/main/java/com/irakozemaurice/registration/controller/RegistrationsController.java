// package com.irakozemaurice.controller;

// import java.io.IOException;
// import java.text.SimpleDateFormat;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.util.Date;
// import java.util.List;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.irakozemaurice.dao.CourseDao;
// import com.irakozemaurice.dao.RegistrationDao;
// import com.irakozemaurice.dao.SemesterDao;
// import com.irakozemaurice.dao.StudentDao;
// import com.irakozemaurice.model.Course;
// import com.irakozemaurice.model.Registration;
// import com.irakozemaurice.model.Semester;
// import com.irakozemaurice.model.Student;

// @WebServlet(name = "RegistrationsController", urlPatterns =
// "/admin-registrations")
// public class RegistrationsController extends HttpServlet {
// private static final long serialVersionUID = 1L;

// protected void doGet(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// SemesterDao semesterDao = new SemesterDao();
// List<Semester> semesterList = semesterDao.getAll();

// CourseDao courseDao = new CourseDao();
// List<Course> courseList = courseDao.getAll();

// RegistrationDao registrationDao = new RegistrationDao();
// List<Registration> registrationList = registrationDao.getAll();

// // Pass student list to jsp

// request.setAttribute("semesterList", semesterList);
// request.setAttribute("registrationList", registrationList);
// request.setAttribute("courseList", courseList);

// // display the students jsp page

// getServletContext().getRequestDispatcher("/admin-registrations.jsp").forward(request,
// response);
// }

// protected void doPost(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// // format date
// String dateString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
// LocalDate registrationDate = LocalDate.parse(dateString,
// DateTimeFormatter.ISO_DATE);

// Registration registration = new Registration(registrationDate);

// // attach student
// StudentDao studentDao = new StudentDao();
// Student student = studentDao.getByRegNo(request.getParameter("student_id"));
// registration.setStudent(student);

// // attach au
// registration.setAcademicUnit(student.getAcademicUnit());

// // attach semester
// SemesterDao semesterDao = new SemesterDao();
// Semester semester =
// semesterDao.getById(Integer.parseInt(request.getParameter("semester")));
// registration.setSemester(semester);

// // attach courses
// CourseDao courseDao = new CourseDao();
// String[] courses = request.getParameterValues("courses");
// for (String courseId : courses) {
// Course course = courseDao.getById(Integer.parseInt(courseId));
// registration.addCourse(course);
// }

// RegistrationDao registrationDao = new RegistrationDao();
// registrationDao.save(registration);

// request.setAttribute("success", "Registration saved successfully");

// doGet(request, response);

// // response.sendRedirect("/admin-au");

// }
// }
