package ua.com.systemgroup.dockerdatabaseserverprovider.service.json;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.Client;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CheckRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.PaydiscountRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CashOperationRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CashRegisterReportRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CheckPayRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.ShiftWorkRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.AuditActionRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.CheckArticlesRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.ClientRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.exports.GenericRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.Check;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.Paydiscount;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CashOperation;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CashRegisterReport;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CheckPay;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.ShiftWork;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.AuditAction;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.CheckArticles;
import ua.com.systemgroup.dockerdatabaseserverprovider.util.ParseUtil;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExportJsonService<E> {

    private final CashRegisterReportRepository<E> cashRegisterReportRepository;
    private final CheckArticlesRepository<E> checkArticlesRepository;
    private final CashOperationRepository<E> cashOperationRepository;
    private final ShiftWorkRepository<E> shiftWorkRepository;
    private final AuditActionRepository<E> auditActionRepository;
    private final CheckPayRepository checkPayRepository;
    private final CheckRepository checkRepository;
    private final ClientRepository clientRepository;
    private final PaydiscountRepository paydiscountRepository;
    private final ParseUtil<?> parseUtil;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
    private final DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<E> findAllCashRegisterReportsByReportTime(String dateFrom, String dateTo) {
        return findAllEntityByDateRange(dateFrom, dateTo, cashRegisterReportRepository);
    }

    public List<E> findAllCheckArticlesByTimeAdd(String dateFrom, String dateTo) {
        return findAllEntityByDateRange(dateFrom, dateTo, checkArticlesRepository);
    }

    public List<E> findAllCashOperationByDateOperation(String dateFrom, String dateTo) {
        return findAllEntityByDateRange(dateFrom, dateTo, cashOperationRepository);
    }

    public List<E> findAllShiftWorkByDateShift(String dateFrom, String dateTo) {
        return findAllEntityByDateRange(dateFrom, dateTo, shiftWorkRepository);
    }

    public List<E> findAllAuditActionByDateEvent(String dateFrom, String dateTo) {
        return findAllEntityByDateRange(dateFrom, dateTo, auditActionRepository);
    }

    public List<CashRegisterReport> findAllCashRegisterReports() {
        return cashRegisterReportRepository.findAll();
    }

    public List<Check> findAllChecks() {
        return checkRepository.findAll();
    }

    public List<CheckArticles> findAllCheckArticles() {
        return checkArticlesRepository.findAll();
    }

    public List<CheckPay> findAllCheckPay() {
        return checkPayRepository.findAll();
    }

    public List<CashOperation> findAllCashOperations() {
        return cashOperationRepository.findAll();
    }

    public List<ShiftWork> findAllShiftWork() {
        return shiftWorkRepository.findAll();
    }

    public List<AuditAction> findAllAuditAction() {
        return auditActionRepository.findAll();
    }

    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    public List<Paydiscount> findAllPaydiscount() {
        return paydiscountRepository.findAll();
    }

    public List<Check> findAllChecksByDateOperation(String dateFrom, String dateTo) {
        Date startDate = null;
        Date endDate = null;

        if (dateFrom != null) startDate = parseUtil.parseDate(dateFrom);
        if (dateTo != null) endDate = parseUtil.parseDate(dateTo);

        if (startDate != null && endDate != null) {
            return checkRepository.findCheckByDateOperationBetween(startDate, endDate);
        } else if (startDate != null) {
            return checkRepository.findCheckByDateOperationGreaterThanEqual(startDate);
        } else if (endDate != null) {
            return checkRepository.findCheckByDateOperationLessThanEqual(endDate);
        }

        return checkRepository.findAll();
    }

    private List<E> findAllEntityByDateRange(String dateFrom, String dateTo, GenericRepository<E> genericRepository) {
        ZonedDateTime startDate = null;
        ZonedDateTime endDate = null;

        if (dateFrom != null) startDate = ZonedDateTime.parse(dateFrom, formatter);
        if (dateTo != null) endDate = ZonedDateTime.parse(dateTo, formatter);

        if (startDate != null && endDate != null) {
            return genericRepository.findAllEntityByDateRangeBetween(startDate, endDate);
        } else if (startDate != null) {
            return genericRepository.findAllEntityByDateRangeGreaterThanEqual(startDate);
        } else if (endDate != null) {
            return genericRepository.findAllEntityByDateRangeLessThanEqual(endDate);
        }

        return Collections.emptyList();
    }

}
