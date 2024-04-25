package org.example;

import org.example.dao.DaoFactory;
import org.example.dao.delegate.EntityDelegateDao;
import org.example.entity.Entity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static org.example.dao.DaoFactory.getDaoFactory;
import static org.example.dao.delegate.jdbc.PgEntityDao.*;

@WebServlet(name = "startServlet", value = "/start-servlet")
public class StartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        DaoFactory daoFactory = getDaoFactory();
        System.out.println(daoFactory);
//        EntityDelegateDao entityDelegateDao = new EntityDelegateDao();
//        try {
//            //Class.forName("org.postgresql.Driver");
//            if (request.getParameter("actionName").equals("/add")) {
//                response.getWriter().println("/add");
//                response.getWriter().println(entityDelegateDao.addEntity(new Entity("entity1", new HashSet<>(Arrays.asList("099-342-43", "034-632-44")), new File(PATH_FILE), Files.readAllBytes(Paths.get(PATH_FILE)))));
//                response.getWriter().println(entityDelegateDao.addEntity(new Entity("entity2", new HashSet<>(Arrays.asList("099-342-43", "034-632-44")), new File(PATH_FILE), Files.readAllBytes(Paths.get(PATH_FILE)))));
//                response.getWriter().println(entityDelegateDao.addEntity(new Entity("entity3", new HashSet<>(Arrays.asList("099-342-43", "034-632-44")), new File(PATH_FILE_NEXT), Files.readAllBytes(Paths.get(PATH_FILE_NEXT)))));
//            } else if (request.getParameter("actionName").equals("/getAll")) {
//                response.getWriter().println("/getAll");
//                List <Entity> entities = entityDelegateDao.getAllEntity();
//                response.getWriter().println(entities);
//            } else if (request.getParameter("actionName").equals("/getById")) {
//                String id = request.getParameter("id");
//                response.getWriter().println("/getById");
//                Entity entityFromDb = entityDelegateDao.getEntityById(Integer.parseInt(id));
//                response.getWriter().println(entityFromDb);
//            } else if (request.getParameter("actionName").equals("/update")) {
//                String id = request.getParameter("id");
//                response.getWriter().println("/update");
//                entityDelegateDao.updateEntity(new Entity(Integer.parseInt(id), "entityNext", new HashSet<>(Arrays.asList("077-635-11", "066-553-12")), new File(PATH_FILE_UPDATE), Files.readAllBytes(Paths.get(PATH_FILE_UPDATE))));
//                response.getWriter().println(entityDelegateDao.getEntityById(Integer.parseInt(id)));
//            } else if (request.getParameter("actionName").equals("/deleteById")) {
//                String id = request.getParameter("id");
//                response.getWriter().println("/deleteById");
//                entityDelegateDao.deleteEntityById(Integer.parseInt(id));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}