package com.mjc.school.repository.NewsReader;

import com.mjc.school.repository.AuthorModel.AuthorModel;
import com.mjc.school.repository.ContentModel.ContentModel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NewsReader {
    private String authorsFileName;
    private String contentsFileName;

    public NewsReader(String authorsFileName, String contentsFileName) {
        this.authorsFileName = authorsFileName;
        this.contentsFileName = contentsFileName;
    }

    public List<AuthorModel> getAuthors() {
        List<AuthorModel> response = new ArrayList<>();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(authorsFileName);
        if (is != null) {
            try (InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {
                String line;
                List<String> stringList = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    if (!line.equals("__end__")) {
                        stringList.add(line);
                    } else {
                        response.add(new AuthorModel(stringList));
                        stringList.clear();
                    }
                }
                is.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return response;
    }

    public List<ContentModel> getContents() {
        List<ContentModel> response = new ArrayList<>();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contentsFileName);
        if (is != null) {
            try (InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {
                String line;
                List<String> stringList = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    if (!line.equals("__end__")) {
                        stringList.add(line);
                    } else {
                        response.add(new ContentModel(stringList));
                        stringList.clear();
                    }
                }
                is.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return response;
    }
}
