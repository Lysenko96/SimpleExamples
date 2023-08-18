package info.gweep.mvc5.service;

import info.gweep.mvc5.entity.Singer;
import info.gweep.mvc5.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SingerServiceImpl extends SingerService {
    private SingerRepository singerRepository;

    public SingerServiceImpl(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return (List<Singer>) singerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return singerRepository.findById(id).orElse(null);
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Singer> findAllByPage(Pageable pageable) {
        return singerRepository.findAll(pageable);
    }
}
