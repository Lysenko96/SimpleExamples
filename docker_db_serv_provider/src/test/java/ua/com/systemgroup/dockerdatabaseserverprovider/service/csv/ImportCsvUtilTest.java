//package ua.com.systemgroup.dockerdatabaseserverprovider.service.csv;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import ua.com.systemgroup.dockerdatabaseserverprovider.config.TestcontainersConfiguration;
//import ua.com.systemgroup.dockerdatabaseserverprovider.filter.imports.ArticleFilter;
//import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Article;
//import ua.com.systemgroup.dockerdatabaseserverprovider.model.pkey.ArticlePk;
//import ua.com.systemgroup.dockerdatabaseserverprovider.util.ImportCsvUtil;
//import ua.com.systemgroup.dockerdatabaseserverprovider.util.ParseUtil;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//// add file t_article.csv from resource import to path in application.yml
//// encoding utf-8
//
//@SpringBootTest(classes = {ArticleFilter.class, ImportCsvUtil.class, ParseUtil.class})
//class ImportCsvUtilTest extends TestcontainersConfiguration {
//
//    @Autowired
//    private ImportCsvUtil<Article, ArticlePk> importCsvUtilArticleFilter;
//    @Autowired
//    private ArticleFilter articlesFilter;
//    @Value("${custom.path}")
//    private String path;
//
//    private String fileName = "t_article.csv";
//    private String fileNameBackup = "t_article.csv.bak";
//
//    @BeforeEach
//    public void setUp() throws IOException {
//        if (new File(path + File.separator + fileNameBackup).exists()) {
//            String source = path + File.separator + fileNameBackup;
//            String target = path + File.separator + fileName;
//            Files.move(Path.of(source), Path.of(target));
//        }
//    }
//
//    @Test
//    void givenFilter_whenGetFileNames_thenGetFileNamesByFilter() {
//        String[] fileNames = importCsvUtilArticleFilter.getFileNames(articlesFilter);
//        assertEquals(fileName, fileNames[0]);
//    }
//
//    @Test
//    void givenFileName_whenGetListArticle_thenGetListArticle() {
//        Article article = new Article(Short.parseShort("9999"), 11184, 154, 0, 1, "Ікра лососева Шаланда 230г скляна банка",
//                "ІкраЛососеваШаланда230", Short.parseShort("0"), "1", false, true, true, true, "10011183",
//                "161827;3557;58;244;1331;7791;7227;7391;7418;", 0, null, null, null, 0);
//        List<Article> expected = List.of(article);
//
//        List<Article> actual = importCsvUtilArticleFilter.findListEntityFromCSVByType(Article.class, fileName);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void givenFileName_whenRenameFile_thenRenameFile() {
//        String[] fileNames = importCsvUtilArticleFilter.getFileNames(articlesFilter);
//        assertEquals(fileName, fileNames[0]);
//
//        importCsvUtilArticleFilter.renameFile(fileName);
//
//        fileNames = importCsvUtilArticleFilter.getFileNames((file, s) -> s.equalsIgnoreCase(fileNameBackup));
//        assertEquals(fileNames.length, 0);
//    }
//
//}
