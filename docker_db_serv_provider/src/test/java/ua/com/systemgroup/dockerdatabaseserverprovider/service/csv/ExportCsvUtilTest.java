//package ua.com.systemgroup.dockerdatabaseserverprovider.service.csv;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CashRegisterReport;
//import ua.com.systemgroup.dockerdatabaseserverprovider.model.pkey.CashRegisterReportPk;
//import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CashRegisterReportRepository;
//import ua.com.systemgroup.dockerdatabaseserverprovider.util.ExportCsvUtil;
//import ua.com.systemgroup.dockerdatabaseserverprovider.util.ParseUtil;
//
//import java.io.File;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.nio.file.Files;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//
//@DataJpaTest
//@Import({CashRegisterReport.class, CashRegisterReportPk.class,
//        ExportCsvUtil.class, ParseUtil.class})
//public class ExportCsvUtilTest {
//
//    @Autowired
//    private ExportCsvUtil<CashRegisterReport, CashRegisterReportPk> cashRegisterReportExportCsvUtil;
//    @MockBean
//    private CashRegisterReportRepository cashRegisterReportRepository;
//
//    @Value("${custom.path}")
//    private String path;
//
//    private final DateTimeFormatter formatterZ = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
//    private List<Object[]> expected;
//
//    @BeforeEach
//    public void setUp() {
//        expected = new ArrayList<>();
//        Object[] args = new Object[14];
//        args[0] = Short.parseShort("9999");
//        args[1] = 1;
//        args[2] = 90;
//        args[3] = 2;
//        args[4] = "2024-07-11T15:29:08.070Z";
//        args[5] = new BigDecimal("0.00");
//        args[6] = new BigDecimal("0.00");
//        args[7] = new BigDecimal("0.00");
//        args[8] = "2024-07-11T15:29:08.070Z";
//        args[9] = "СП802000001";
//        args[10] = 87;
//        args[11] = new BigDecimal("0.00");
//        args[12] = null;
//        args[13] = "{1.00, 2.33}";
//        expected.add(args);
//    }
//
//    @Test
//    void givenEntity_whenFindListEntityByRepository_thenReturnListObjects() {
//        CashRegisterReport cashRegisterReport = new CashRegisterReport(Short.parseShort("9999"), 1, 90, 2,
//                ZonedDateTime.parse("2024-07-11T15:29:08.070Z", formatterZ), new BigDecimal("0.00"), new BigDecimal("0.00"), new BigDecimal("0.00"),
//                ZonedDateTime.parse("2024-07-11T15:29:08.070Z", formatterZ), "СП802000001", 87, new BigDecimal("0.00"),
//                null, new BigDecimal[]{new BigDecimal("1.00"), new BigDecimal("2.33")});
//        when(cashRegisterReportRepository.findAll()).thenReturn(List.of(cashRegisterReport));
//
//        List<Object[]> argsList = cashRegisterReportExportCsvUtil.findListEntityByRepository(cashRegisterReportRepository, CashRegisterReport.class);
//
//        Object[] expectedArr = expected.get(0);
//        Object[] actualArr = argsList.get(0);
//
//        for (int i = 0; i < expectedArr.length; i++) {
//            assertEquals(expectedArr[i], actualArr[i]);
//        }
//    }
//
//    @Test
//    void givenFileNameAndListObjects_whenWriteToFile_thenWriteToFile() throws IOException {
//        File file = new File(path + File.separator + "t_cash_register_report.csv");
//
//        if (file.exists()) {
//            Files.delete(file.toPath());
//        }
//        assertFalse(file.exists());
//
//        Files.createFile(file.toPath());
//
//        cashRegisterReportExportCsvUtil.writeToFile(expected, "t_cash_register_report");
//
//        assertTrue(file.exists());
//    }
//}
//
