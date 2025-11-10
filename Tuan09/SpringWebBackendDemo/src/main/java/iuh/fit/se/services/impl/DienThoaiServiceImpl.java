package iuh.fit.se.services.impl;

import iuh.fit.se.dtos.request.DienThoaiRequest;
import iuh.fit.se.dtos.response.DienThoaiResponse;
import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.exceptions.AppException;
import iuh.fit.se.exceptions.ErrorCode;
import iuh.fit.se.exceptions.ValidationException;
import iuh.fit.se.repositories.DienThoaiRepository;
import iuh.fit.se.services.DienThoaiService;
import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DienThoaiServiceImpl implements DienThoaiService {
    private final DienThoaiRepository dienThoaiRepository;
    private final ModelMapper modelMapper;

    @Override
    public DienThoaiResponse add(DienThoaiRequest request) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        factory.close();
        Set<ConstraintViolation<DienThoaiRequest>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ValidationException(violations);

        if(dienThoaiRepository.existsById(request.getMaDT()))
            throw new AppException(ErrorCode.DIENTHOAI_EXISTED);

        DienThoai dienThoai = fromDienThoaiRequest(request);
        dienThoai = dienThoaiRepository.save(dienThoai);
        return toDienThoaiResponse(dienThoai);
    }

    @Override
    public boolean hasData() {
        return dienThoaiRepository.count() > 0;
    }

    @Override
    public List<DienThoaiResponse> findByNhaCungCap_MaNCC(String maNCC) {
        System.out.println(dienThoaiRepository.findByNhaCungCap_MaNCC(maNCC));
        return dienThoaiRepository.findByNhaCungCap_MaNCC(maNCC)
                .stream()
                .map(ncc ->
                        modelMapper.map(ncc, DienThoaiResponse.class))
                .toList();
    }

    private DienThoai fromDienThoaiRequest(DienThoaiRequest request) {
        return modelMapper.map(request, DienThoai.class);
    }

    private DienThoaiResponse toDienThoaiResponse(DienThoai dienThoai) {
        return modelMapper.map(dienThoai, DienThoaiResponse.class);
    }
}
