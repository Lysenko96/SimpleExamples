package ua.com.systemgroup.dockerdatabaseserverprovider.service.csv;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Service;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.Client;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.Check;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.Paydiscount;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CashOperation;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CashRegisterReport;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CheckPay;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.ShiftWork;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.AuditAction;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CheckArticles;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.ClientPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CheckPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.PaydiscountPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CashOperationPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CashRegisterReportPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CheckPayPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.ShiftWorkPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.AuditActionPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CheckArticlesPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.ClientRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CheckRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.PaydiscountRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CashOperationRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CashRegisterReportRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CheckPayRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.ShiftWorkRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.AuditActionRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CheckArticlesRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.util.ExportCsvUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
@DisallowConcurrentExecution
@Slf4j
public class ExportProviderService implements Job {

    private final ExportCsvUtil<CashRegisterReport, CashRegisterReportPk> cashRegisterReportExportCsvUtil;
    private final CashRegisterReportRepository<CashRegisterReport> cashRegisterReportRepository;
    private final ExportCsvUtil<Check, CheckPk> checkExportCsvUtil;
    private final CheckRepository checkRepository;
    private final ExportCsvUtil<CheckArticles, CheckArticlesPk> checkArticlesExportCsvUtil;
    private final CheckArticlesRepository<CheckArticles> checkArticlesRepository;
    private final ExportCsvUtil<CheckPay, CheckPayPk> checkPayExportCsvUtil;
    private final CheckPayRepository checkPayRepository;
    private final ExportCsvUtil<CashOperation, CashOperationPk> cashOperationExportCsvUtil;
    private final CashOperationRepository<CashOperation> checkOperationRepository;
    private final ExportCsvUtil<ShiftWork, ShiftWorkPk> shiftWorkExportCsvUtil;
    private final ShiftWorkRepository<ShiftWork> shiftWorkRepository;
    private final ExportCsvUtil<AuditAction, AuditActionPk> auditActionExportCsvUtil;
    private final AuditActionRepository<AuditAction> auditActionRepository;
    private final ExportCsvUtil<Client, ClientPk> clientExportCsvUtil;
    private final ClientRepository clientRepository;
    private final ExportCsvUtil<Paydiscount, PaydiscountPk> paydiscountExportCsvUtil;
    private final PaydiscountRepository paydiscountRepository;

    @Override
    public void execute(JobExecutionContext context) {
        log.info("Executing Quartz Job ExportProviderService at " + System.currentTimeMillis());

        try {
            List<Object[]> argsList = cashRegisterReportExportCsvUtil.findListEntityByRepository(cashRegisterReportRepository, CashRegisterReport.class);
            cashRegisterReportExportCsvUtil.writeToFile(argsList, "t_cash_register_report");
        } catch (Exception e) {
            log.error("t_cash_register_report", e);
        }

        try {
            List<Object[]> argsList1 = checkExportCsvUtil.findListEntityByRepository(checkRepository, Check.class);
            checkExportCsvUtil.writeToFile(argsList1, "t_check");
        } catch (Exception e) {
            log.error("t_check", e);
        }

        try {
            List<Object[]> argsList2 = checkArticlesExportCsvUtil.findListEntityByRepository(checkArticlesRepository, CheckArticles.class);
            checkArticlesExportCsvUtil.writeToFile(argsList2, "t_check_articles");
        } catch (Exception e) {
            log.error("t_check_articles", e);
        }

        try {
            List<Object[]> argsList3 = checkPayExportCsvUtil.findListEntityByRepository(checkPayRepository, CheckPay.class);
            checkPayExportCsvUtil.writeToFile(argsList3, "t_check_pay");
        } catch (Exception e) {
            log.error("t_check_pay", e);
        }

        try {
            List<Object[]> argsList4 = cashOperationExportCsvUtil.findListEntityByRepository(checkOperationRepository, CashOperation.class);
            cashOperationExportCsvUtil.writeToFile(argsList4, "t_cash_operation");
        } catch (Exception e) {
            log.error("t_cash_operation", e);
        }

        try {
            List<Object[]> argsList5 = shiftWorkExportCsvUtil.findListEntityByRepository(shiftWorkRepository, ShiftWork.class);
            shiftWorkExportCsvUtil.writeToFile(argsList5, "t_shift_work");
        } catch (Exception e) {
            log.error("t_shift_work", e);
        }


        try {
            List<Object[]> argsList6 = auditActionExportCsvUtil.findListEntityByRepository(auditActionRepository, AuditAction.class);
            auditActionExportCsvUtil.writeToFile(argsList6, "t_audit_action");
        } catch (Exception e) {
            log.error("t_audit_action", e);
        }

        try {
            List<Object[]> argsList7 = clientExportCsvUtil.findListEntityByRepository(clientRepository, Client.class);
            clientExportCsvUtil.writeToFile(argsList7, "t_client");
        } catch (Exception e) {
            log.error("t_client", e);
        }

        try {
            List<Object[]> argsList8 = paydiscountExportCsvUtil.findListEntityByRepository(paydiscountRepository, Paydiscount.class);
            paydiscountExportCsvUtil.writeToFile(argsList8, "t_paydiscount");
        } catch (Exception e) {
            log.error("t_paydiscount", e);
        }
    }

}
