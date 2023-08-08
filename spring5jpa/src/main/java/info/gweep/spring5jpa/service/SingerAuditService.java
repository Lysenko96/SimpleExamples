package info.gweep.spring5jpa.service;

import info.gweep.spring5jpa.entity.SingerAudit;

import java.util.List;

public interface SingerAuditService {

    List<SingerAudit> findAll();
    SingerAudit findById(Long id);
    SingerAudit save(SingerAudit singerAudit);
}
