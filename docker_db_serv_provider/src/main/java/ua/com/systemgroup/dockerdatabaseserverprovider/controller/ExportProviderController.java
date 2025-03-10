package ua.com.systemgroup.dockerdatabaseserverprovider.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.Client;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.AuditAction;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.Paydiscount;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.Check;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CashOperation;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CashRegisterReport;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CheckPay;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CheckArticles;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.ShiftWork;
import ua.com.systemgroup.dockerdatabaseserverprovider.service.json.ExportJsonService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/export")
@RequiredArgsConstructor
public class ExportProviderController {

    private final ExportJsonService<?> exportJsonService;
    private final ExportJsonService<CashRegisterReport> cashRegisterReportExportJsonService;
    private final ExportJsonService<CheckArticles> checkArticlesExportJsonService;
    private final ExportJsonService<CashOperation> cashOperationExportJsonService;
    private final ExportJsonService<ShiftWork> shiftWorkExportJsonService;
    private final ExportJsonService<AuditAction> auditActionExportJsonService;

    @GetMapping("/cash-register-report")
    public List<CashRegisterReport> findAllCashRegisterReports() {
        return cashRegisterReportExportJsonService.findAllCashRegisterReports();
    }

    @GetMapping("/range/cash-register-report")
    public List<CashRegisterReport> findAllCashRegisterReportsByReportTime(@RequestParam(value = "dateFrom", required = false) String dateFrom,
                                                                           @RequestParam(value = "dateTo", required = false) String dateTo) {
        return cashRegisterReportExportJsonService.findAllCashRegisterReportsByReportTime(dateFrom, dateTo);
    }

    @GetMapping("/check")
    public List<Check> findAllChecks() {
        return exportJsonService.findAllChecks();
    }

    @GetMapping("/range/check")
    public List<Check> findAllChecksByDateOperation(@RequestParam(value = "dateFrom", required = false) String dateFrom,
                                                    @RequestParam(value = "dateTo", required = false) String dateTo) {
        return exportJsonService.findAllChecksByDateOperation(dateFrom, dateTo);
    }

    @GetMapping("/check-articles")
    public List<CheckArticles> findAllCheckArticles() {
        return checkArticlesExportJsonService.findAllCheckArticles();
    }

    @GetMapping("/range/check-articles")
    public List<CheckArticles> findAllCheckArticlesByTimeAdd(@RequestParam(value = "dateFrom", required = false) String dateFrom,
                                                             @RequestParam(value = "dateTo", required = false) String dateTo) {
        return checkArticlesExportJsonService.findAllCheckArticlesByTimeAdd(dateFrom, dateTo);
    }

    @GetMapping("/check-pay")
    public List<CheckPay> findAllCheckPay() {
        return exportJsonService.findAllCheckPay();
    }

    @GetMapping("/cash-operation")
    public List<CashOperation> findAllCashOperation() {
        return cashOperationExportJsonService.findAllCashOperations();
    }

    @GetMapping("/range/cash-operation")
    public List<CashOperation> findAllCashOperationByDateOperation(@RequestParam(value = "dateFrom", required = false) String dateFrom,
                                                                   @RequestParam(value = "dateTo", required = false) String dateTo) {
        return cashOperationExportJsonService.findAllCashOperationByDateOperation(dateFrom, dateTo);
    }

    @GetMapping("/shift-work")
    public List<ShiftWork> findAllShiftWork() {
        return shiftWorkExportJsonService.findAllShiftWork();
    }

    @GetMapping("/range/shift-work")
    public List<ShiftWork> findAllShiftWorkByDateShift(@RequestParam(value = "dateFrom", required = false) String dateFrom,
                                                       @RequestParam(value = "dateTo", required = false) String dateTo) {
        return shiftWorkExportJsonService.findAllShiftWorkByDateShift(dateFrom, dateTo);
    }

    @GetMapping("/audit-action")
    public List<AuditAction> findAllAuditAction() {
        return auditActionExportJsonService.findAllAuditAction();
    }

    @GetMapping("/range/audit-action")
    public List<AuditAction> findAllAuditActionByDateEvent(@RequestParam(value = "dateFrom", required = false) String dateFrom,
                                                           @RequestParam(value = "dateTo", required = false) String dateTo) {
        return auditActionExportJsonService.findAllAuditActionByDateEvent(dateFrom, dateTo);
    }

    @GetMapping("/client")
    public List<Client> findAllClient() {
        return exportJsonService.findAllClient();
    }

    @GetMapping("/paydiscount")
    public List<Paydiscount> findAllPaydiscount() {
        return exportJsonService.findAllPaydiscount();
    }
}
