package iuh.fit.se.services.impl;

import iuh.fit.se.dtos.request.NhaCungCapRequest;
import iuh.fit.se.dtos.response.NhaCungCapResponse;
import iuh.fit.se.entities.NhaCungCap;
import iuh.fit.se.exceptions.AppException;
import iuh.fit.se.exceptions.ErrorCode;
import iuh.fit.se.repositories.NhaCungCapRepository;
import iuh.fit.se.services.NhaCungCapService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {
    private final NhaCungCapRepository nhaCungCapRepository;
    private final ModelMapper modelMapper;

    @Override
    public NhaCungCapResponse add(NhaCungCapRequest nhaCungCapRequest) {
        NhaCungCap nhaCungCap = fromNhaCungCapRequest(nhaCungCapRequest);
        nhaCungCap = nhaCungCapRepository.save(nhaCungCap);
        return toNhaCungCapResponse(nhaCungCap);
    }

    @Override
    public boolean hasData() {
        return nhaCungCapRepository.count() > 0;
    }

    @Override
    public List<NhaCungCapResponse> findAll() {
        return nhaCungCapRepository.findAll().stream().map(this::toNhaCungCapResponse).toList();
    }

    @Override
    public List<NhaCungCapResponse> findCustom(String find) {
        return nhaCungCapRepository
                .findByMaNCCContainsOrTenNCCContainsOrDiaChiContainsOrSoDienThoaiContains(find, find, find, find)
                .stream().map(this::toNhaCungCapResponse).toList();
    }

    @Override
    public NhaCungCapResponse findById(String id) {
        return toNhaCungCapResponse(nhaCungCapRepository
                .findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NHACUNGCAP_NOT_EXISTED))
        );
    }

    private NhaCungCap fromNhaCungCapRequest(NhaCungCapRequest nhaCungCapRequest) {
        return modelMapper.map(nhaCungCapRequest, NhaCungCap.class);
    }

    private NhaCungCapResponse toNhaCungCapResponse(NhaCungCap nhaCungCap) {
        return modelMapper.map(nhaCungCap, NhaCungCapResponse.class);
    }

}
