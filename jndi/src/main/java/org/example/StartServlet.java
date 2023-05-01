package org.example;

import org.example.dao.delegate.EntityDelegateDao;
import org.example.entity.Entity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static org.example.dao.delegate.jdbc.PgEntityDao.*;

@WebServlet(name = "startServlet", value = "/start-servlet")
public class StartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        EntityDelegateDao entityDelegateDao = new EntityDelegateDao();
        try {
            //Class.forName("org.postgresql.Driver");
            // add
            response.getWriter().println("/add");
            response.getWriter().println(entityDelegateDao.addEntity(new Entity("entity1", new HashSet<>(Arrays.asList("099-342-43", "034-632-44")), new File(PATH_FILE), Files.readAllBytes(Paths.get(PATH_FILE)))));
            response.getWriter().println(entityDelegateDao.addEntity(new Entity("entity2", new HashSet<>(Arrays.asList("099-342-43", "034-632-44")), new File(PATH_FILE), Files.readAllBytes(Paths.get(PATH_FILE)))));
            response.getWriter().println(entityDelegateDao.addEntity(new Entity("entity3", new HashSet<>(Arrays.asList("099-342-43", "034-632-44")), new File(PATH_FILE_NEXT), Files.readAllBytes(Paths.get(PATH_FILE_NEXT)))));
            //get all
            response.getWriter().println("/getAll");
            List<Entity> entities = entityDelegateDao.getAllEntity();
            response.getWriter().println(entities);

            // get by id
            response.getWriter().println("/getById");
            Entity entity = entities.get(0);
            response.getWriter().println(entity);
            Entity entityFromDb = entityDelegateDao.getEntityById(entity.getId());
            response.getWriter().println(entityFromDb);
            // update
            response.getWriter().println("/update");
            entityDelegateDao.updateEntity(new Entity(entityFromDb.getId(), "entityNext", new HashSet<>(Arrays.asList("077-635-11", "066-553-12")), new File(PATH_FILE_UPDATE), Files.readAllBytes(Paths.get(PATH_FILE_UPDATE))));
            response.getWriter().println(entityDelegateDao.getEntityById(entityFromDb.getId()));
            // delete
            response.getWriter().println("/deleteById");
            response.getWriter().println(entities.get(1).getId());
            entityDelegateDao.deleteEntityById(entities.get(1).getId());
            response.getWriter().println(entityDelegateDao.getAllEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}