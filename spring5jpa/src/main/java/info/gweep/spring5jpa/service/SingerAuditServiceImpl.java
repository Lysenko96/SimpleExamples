package info.gweep.spring5jpa.service;

import info.gweep.spring5jpa.entity.SingerAudit;
import info.gweep.spring5jpa.repository.SingerAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("singerAuditService")
@Transactional
public class SingerAuditServiceImpl implements SingerAuditService{

    private SingerAuditRepository singerAuditRepository;

    public SingerAuditServiceImpl(SingerAuditRepository singerAuditRepository) {
        this.singerAuditRepository = singerAuditRepository;
    }

    //@Transactional(readOnly = true)
    @Override
    public List<SingerAudit> findAll() {
        return (List<SingerAudit>) singerAuditRepository.findAll();
    }

    @Override
  //  @Transactional
    public SingerAudit findById(Long id) {
        return singerAuditRepository.findById(id).orElseGet(null);
    }

    @Override
  //  @Transactional
    public SingerAudit save(SingerAudit singerAudit) {
        return singerAuditRepository.save(singerAudit);
    }
}
