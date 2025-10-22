package iuh.fit.se.services.impl;

import iuh.fit.se.entities.NhaCungCap;
import iuh.fit.se.repositories.NhaCungCapRepository;
import iuh.fit.se.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {
    private NhaCungCapRepository nhaCungCapRepository;

    @Autowired
    public NhaCungCapServiceImpl(NhaCungCapRepository nhaCungCapRepository) {
        this.nhaCungCapRepository = nhaCungCapRepository;
    }

    @Override
    public NhaCungCap save(NhaCungCap nhaCungCap) {
        if (nhaCungCapRepository.existsById(nhaCungCap.getMaNCC()))
            return null;
        return nhaCungCapRepository.save(nhaCungCap);
    }

    @Override
    public NhaCungCap update(NhaCungCap nhaCungCap) {
        if (nhaCungCapRepository.existsById(nhaCungCap.getMaNCC()))
            return nhaCungCapRepository.save(nhaCungCap);
        return null;
    }

    @Override
    public void delete(int id) {
        nhaCungCapRepository.deleteById(id);
    }

    @Override
    public NhaCungCap findById(int id) {
        return nhaCungCapRepository.findById(id).orElse(null);
    }

    @Override
    public List<NhaCungCap> findAll() {
        return nhaCungCapRepository.findAll();
    }

    @Override
    public boolean hasData() {
        return nhaCungCapRepository.count() > 0;
    }

    @Override
    public List<NhaCungCap> findByCustom(String text) {
        return nhaCungCapRepository.findByTenNCCContainsOrDiaChiContainsOrSoDienThoaiContains(text, text, text);
    }
}
