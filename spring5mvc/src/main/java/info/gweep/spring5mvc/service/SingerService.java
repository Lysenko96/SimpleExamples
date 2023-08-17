package info.gweep.spring5mvc.service;

import info.gweep.spring5mvc.entity.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class SingerService {

    public abstract List<Singer> findAll();

    public abstract Singer findById(Long id);

    public abstract Singer save(Singer singer);

    public abstract Page<Singer> findAllByPage(Pageable pageable);
}
