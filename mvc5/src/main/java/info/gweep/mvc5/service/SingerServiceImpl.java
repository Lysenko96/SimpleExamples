package info.gweep.mvc5.service;

import info.gweep.mvc5.entity.Singer;
import info.gweep.mvc5.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public Singer update(Long id, String firstName, String lastName, String birthDate){
        Singer singer = findById(id);
        singer.setFirstName(firstName);
        singer.setLastName(lastName);
        Date parseBirthDate;
        try {
            parseBirthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
        } catch (ParseException e) {
            throw new RuntimeException(e + System.lineSeparator() + "Use format: yyyy-MM-dd");
        }
        singer.setBirthDate(parseBirthDate);
        return save(singer);
    }

    public Singer save(String firstName, String lastName, String birthDate) {
        Date parseBirthDate;
        try {
            parseBirthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
        } catch (ParseException e) {
            throw new RuntimeException(e + System.lineSeparator() + "Use format: yyyy-MM-dd");
        }
        Singer singer = new Singer(firstName, lastName, parseBirthDate);
        return singerRepository.save(singer);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Singer> findAllByPage(Pageable pageable) {
        return singerRepository.findAll(pageable);
    }
}
