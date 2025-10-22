package iuh.fit.se.services.impl;

import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.repositories.DienThoaiRepository;
import iuh.fit.se.services.DienThoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DienThoaiServiceImpl implements DienThoaiService {
    private DienThoaiRepository dienThoaiRepository;

    @Autowired
    public DienThoaiServiceImpl(DienThoaiRepository dienThoaiRepository) {
        this.dienThoaiRepository = dienThoaiRepository;
    }

    @Override
    public DienThoai save(DienThoai dienThoai) {
        if (dienThoaiRepository.existsById(dienThoai.getMaDT()))
            return null;
        return dienThoaiRepository.save(dienThoai);
    }

    @Override
    public DienThoai update(DienThoai dienThoai) {
        if (dienThoaiRepository.existsById(dienThoai.getMaDT()))
            return dienThoaiRepository.save(dienThoai);
        return null;
    }

    @Override
    public void delete(int id) {
        dienThoaiRepository.deleteById(id);
    }

    @Override
    public DienThoai findById(int id) {
        return dienThoaiRepository.findById(id).orElse(null);
    }

    @Override
    public List<DienThoai> findAll() {
        return dienThoaiRepository.findAll();
    }

    @Override
    public boolean hasData() {
        return dienThoaiRepository.count() > 0;
    }
}
