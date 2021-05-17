package com.rainlin.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


/**
 * 支持上传、下载文件
 *
 * @author rainlin
 */
@MultipartConfig
@WebServlet(urlPatterns = "/file")
public class FileServlet extends HttpServlet {
    private static final long serialVersionUID = -8129821074671352320L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServletOutputStream fileOutputStream = resp.getOutputStream()) {
            final Path source = Paths.get(req.getServletContext().getRealPath("/") + req.getParameter("fileName"));
            final File file = source.toFile();
            if (file.exists()) {
                resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file.getName(), StandardCharsets.UTF_8.name()));
                Files.copy(source, fileOutputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional.ofNullable(req.getPart("file")).ifPresent(file -> {
            try (final InputStream fileInputStream = file.getInputStream()) {
                Files.copy(fileInputStream, Paths.get(req.getServletContext().getRealPath("/") + file.getSubmittedFileName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
