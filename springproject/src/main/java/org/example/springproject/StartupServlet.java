package org.example.springproject;

import org.example.springproject.config.Config;
import org.example.springproject.dao.PersonDao;
import org.example.springproject.dao.jdbc.JdbcPersonDao;
import org.example.springproject.dao.jdbc.mapper.PersonMapper;
import org.example.springproject.model.Person;
import org.example.springproject.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@ComponentScan("org.example.config")
//@WebServlet(name = "StartupServlet", value = "/StartupServlet")
public class StartupServlet  {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        System.out.println(context);
//        Config config = context.getBean("config", Config.class);
//        System.out.println(config);
//        DataSource ds = config.dataSource();
       // PasswordEncoder passwordEncoder = context.getBean("passwordEncoder", PasswordEncoder.class);
//        System.out.println(ds);
//        Connection conn = ds.getConnection();
//        System.out.println(conn);
//        conn.close();
//        System.out.println(conn);
        //JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
//        System.out.println(jdbcTemplate);
        //PersonMapper personMapper = context.getBean("personMapper", PersonMapper.class);
        //PersonDao personDao = new JdbcPersonDao(jdbcTemplate, passwordEncoder, personMapper);
        //PersonDao personDao = context.getBean("jdbcPersonDao", JdbcPersonDao.class);
        PersonService personService = context.getBean("personService", PersonService.class);
        Person person = new Person("name", "surname", 1991, "login", "anton1234", "mail.gmail.com", 911, 0);
        System.out.println(person);
        personService.add(person);
        System.out.println(person);
       System.out.println(personService.getAll());
//        person = new Person(1L,"name", "surname", 1991, "login", "anton12345", "mail.gmail.com", 911, 1);
//        personDao.update(person);
//        Person personDb = personDao.getById(1L);
//        System.out.println(personDb);
//        System.out.println(passwordEncoder.matches(person.getPassword(), personDb.getPassword()));
//        personDao.add(person);
//        //person = personDao.getById(1);
//        System.out.println(person);
//        person = new Person(person.getId(), "name2", "surname2", 1991, "login2", "anton123455", "mail.gmail.com2", 912);
//        personDao.update(person);
//        person = personDao.getById(1);
//        System.out.println(person);

//        personDao.deleteById(person.getId());
//        System.out.println(personDao.getAll());
    }

   // private Logger log = Logger.getLogger(StartupServlet.class.getSimpleName());

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        process(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        process(req, resp);
//    }

//    public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        //ServletContext ctx = req.getServletContext();
//        log.info(context.toString());
//        context.refresh();
//        Config config = context.getBean(Config.class);
//        log.info(config.toString());
//        resp.setContentType("text/html");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.print("<html>");
//        printWriter.print("<body>");
//        printWriter.print("<h1>Startup Servlet</h1>");
//        printWriter.print("<a href=index.jsp>back</a>");
//        printWriter.print("</body>");
//        printWriter.print("</html>");
//        printWriter.close();
//    }
}
