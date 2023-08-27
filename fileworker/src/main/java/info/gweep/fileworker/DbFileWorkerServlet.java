package info.gweep.fileworker;

import info.gweep.fileworker.dao.jdbc.JdbcEntityDao;
import info.gweep.fileworker.entity.Entity;
import info.gweep.fileworker.provider.Provider;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static info.gweep.fileworker.dao.jdbc.JdbcEntityDao.BUFFER_SIZE;

@WebServlet("/downloadFileServlet")
public class DbFileWorkerServlet extends HttpServlet {
    public static final String PATH_FILE = "/home/user/Documents/Spd/fileworker/src/main/resources/config.properties";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Provider provider = new Provider();
        JdbcEntityDao jdbcEntityDao = new JdbcEntityDao(provider);
        //jdbcEntityDao.add(new Entity("entity1", new HashSet<>(Arrays.asList("099-342-43", "034-632-44")), new File(PATH_FILE), Files.readAllBytes(Paths.get(PATH_FILE))));
        Entity entity = jdbcEntityDao.getById(1L);
        String fileName = entity.getFile().getName();
        ServletContext context = getServletContext();
        InputStream inputStream = new ByteArrayInputStream(entity.getBlob());
        int fileLength = inputStream.available();
        // sets MIME type for the file download
        String mimeType = context.getMimeType(fileName);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        // set content properties and header attributes for the response
        response.setContentType(mimeType);
        response.setContentLength(fileLength);
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileName);
        response.setHeader(headerKey, headerValue);
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();
    }
}
