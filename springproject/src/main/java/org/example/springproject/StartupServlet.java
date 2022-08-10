package org.example.springproject;

import org.springframework.context.annotation.ComponentScan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ComponentScan("org.example.config")
@WebServlet(name = "StartupServlet", value = "/StartupServlet")
public class StartupServlet extends HttpServlet {

//    public static void main(String[] args) throws SQLException {
//        ApplicationContext context = new AnnotationConfigApplicationContext(StartupServlet.class);
//        System.out.println(context);
//        Config config = context.getBean(Config.class);
//        System.out.println(config);
//        DataSource ds = config.dataSource();
//        System.out.println(ds);
//        Connection conn = ds.getConnection();
//        System.out.println(conn);
//        conn.close();
//        System.out.println(conn);
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
//        System.out.println(jdbcTemplate);
//        PersonDao personDao = new JdbcPersonDao(jdbcTemplate, context);
//        Person person = new Person("name", "surname", 1991, "login", "anton1234", "mail.gmail.com", 911);
//        personDao.add(person);
//        personDao.add(person);
//        //person = personDao.getById(1);
//        System.out.println(person);
//        person = new Person(person.getId(), "name2", "surname2", 1991, "login2", "anton123455", "mail.gmail.com2", 912);
//        personDao.update(person);
//        person = personDao.getById(1);
//        System.out.println(person);
//        System.out.println(personDao.getAll());
//        personDao.deleteById(person.getId());
//        System.out.println(personDao.getAll());
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Startup Servlet</h1>");
        printWriter.print("<a href=index.jsp>back</a>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
