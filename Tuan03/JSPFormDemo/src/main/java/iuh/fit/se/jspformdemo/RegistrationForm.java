package iuh.fit.se.jspformdemo;

import iuh.fit.se.models.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().append("Server at: ").append(req.getContextPath());

        // Get data from Form
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        String email = req.getParameter("email");
        String mobileNumber = req.getParameter("mobileNumber");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String pinCode = req.getParameter("pincode");
        String state = req.getParameter("state");
        String country = req.getParameter("country");
        String hobbies = req.getParameter("hobbies");
        String course = req.getParameter("course");

        // Set data to Student
        Student student = new Student();
        if(firstName != null)student.setFirstName(firstName);
        if(lastName != null)student.setLastName(lastName);
        if(year.matches("\\d+") && month.matches("\\d+") && day.matches("\\d+"))student.setDateOfBirth(LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)));
        if(email != null)student.setEmail(email);
        if(mobileNumber != null)student.setMobileNumber(mobileNumber);
        if(gender != null)student.setGender(gender.equals("male"));
        if(address != null)student.setAddress(address);
        if(city != null)student.setCity(city);
        if(pinCode != null)student.setPinCode(pinCode);
        if(state != null)student.setState(state);
        if(country != null)student.setCountry(country);
        if(hobbies != null)
            if(hobbies.equals("others")) {
                String otherHobbies = req.getParameter("otherHobbies");
                if(otherHobbies != null)student.setHobbies(otherHobbies);
            } else
                student.setHobbies(hobbies);
        if(course != null)student.setCourse(course);

        // Set object student to request object
        req.setAttribute("student", student);

        // Forward to result-form.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("result-form.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
