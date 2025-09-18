package iuh.fit.se.controllers;

import iuh.fit.se.dao.UserDao;
import iuh.fit.se.dao.impl.UserDaoImpl;
import iuh.fit.se.models.User;
import iuh.fit.se.utils.CreateSimpleConstraintViolation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String reEmail = req.getParameter("reEmail");
        String password = req.getParameter("password");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String gender = req.getParameter("gender");

        LocalDate birthday = (!day.equals("Day") && !month.equals("Month") && !year.equals("Year"))? LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)) : null;

        User user = new User(firstName, lastName, email, password, birthday, gender);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        factory.close();

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Set<ConstraintViolation<User>> customViolations = new HashSet<>(violations);

        if (!email.equals(reEmail)) {
            customViolations.add(CreateSimpleConstraintViolation.create(User.class, user, reEmail, "reEmail", "email và re-email phải giống nhau"));
        }

        if (!customViolations.isEmpty()) {
            req.setAttribute("errors", customViolations);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            userDao.save(user);
            req.setAttribute("message", "Đã thêm thành công");
            getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
        }
    }
}
