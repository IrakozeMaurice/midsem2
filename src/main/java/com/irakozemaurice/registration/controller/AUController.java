// package com.irakozemaurice.controller;

// import java.io.IOException;
// import java.util.List;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.irakozemaurice.dao.AUDao;
// import com.irakozemaurice.model.AcademicUnit;
// import com.irakozemaurice.model.Department;
// import com.irakozemaurice.model.Faculty;
// import com.irakozemaurice.model.Program;

// @WebServlet(name = "AUController", urlPatterns = "/admin-au")
// public class AUController extends HttpServlet {

// private static final long serialVersionUID = 1L;

// protected void doGet(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// // Get AU list

// AUDao auDao = new AUDao();
// List<AcademicUnit> auList = auDao.getAll();

// // Pass au list to jsp

// request.setAttribute("auList", auList);

// // display the au jsp page

// getServletContext().getRequestDispatcher("/admin-au.jsp").forward(request,
// response);

// }

// protected void doPost(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {

// // create a new AcademicUnit
// AcademicUnit au = new AcademicUnit();
// // set values
// au.setCode(request.getParameter("code"));

// au.setProgram(Program.valueOf(request.getParameter("program")));

// au.setFaculty(Faculty.valueOf(request.getParameter("faculty")));

// au.setDepartment(Department.valueOf(request.getParameter("department")));

// au.setName(au.getProgram().getName() + " " + au.getFaculty().getName() + " "
// + au.getDepartment().getName());

// // persist AU
// AUDao auDao = new AUDao();
// auDao.save(au);

// request.setAttribute("success", "Academic unit saved successfully");

// doGet(request, response);

// // getServletContext().getRequestDispatcher("/admin-au.jsp").forward(request,
// // response);

// // response.sendRedirect("/admin-au");

// }

// }
