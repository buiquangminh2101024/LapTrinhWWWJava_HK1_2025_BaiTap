package iuh.fit.se.services.impl;

import iuh.fit.se.dtos.request.DienThoaiRequest;
import iuh.fit.se.dtos.response.DienThoaiResponse;
import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.exceptions.AppException;
import iuh.fit.se.exceptions.ErrorCode;
import iuh.fit.se.exceptions.ValidationException;
import iuh.fit.se.repositories.DienThoaiRepository;
import iuh.fit.se.repositories.NhaCungCapRepository;
import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.services.NhaCungCapService;
import iuh.fit.se.utils.ImageHandler;
import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DienThoaiServiceImpl implements DienThoaiService {
    private final DienThoaiRepository dienThoaiRepository;
    private final NhaCungCapRepository nhaCungCapRepository;
    private final ModelMapper modelMapper;

    @Override
    public DienThoaiResponse add(DienThoaiRequest request, MultipartFile file) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        factory.close();
        Set<ConstraintViolation<DienThoaiRequest>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ValidationException(violations);

        // Nếu thêm mới
        if (request.getHinhAnh() == null || request.getHinhAnh().isEmpty())
            if(dienThoaiRepository.existsById(request.getMaDT()))
                throw new AppException(ErrorCode.DIENTHOAI_EXISTED);

        try {
            String hinhAnh = ImageHandler.luuAnh(file);
            // Nếu thêm mới
            if (request.getHinhAnh() == null || request.getHinhAnh().isEmpty()) {
                request.setHinhAnh(hinhAnh);
            } else {
                if (!hinhAnh.equals("none")) {
                    ImageHandler.xoaAnh(request.getHinhAnh());
                    request.setHinhAnh(hinhAnh);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
        return dienThoaiRepository.findByNhaCungCap_MaNCC(maNCC)
                .stream()
                .map(ncc ->
                        modelMapper.map(ncc, DienThoaiResponse.class))
                .toList();
    }

    @Override
    public void delete(String id) {
        DienThoai dienThoai = dienThoaiRepository.findByIdRaw(id);
        dienThoaiRepository.delete(dienThoai);
    }

    @Override
    public DienThoaiResponse findById(String id) {
        DienThoai dienThoai = dienThoaiRepository.findByIdRaw(id);
        return toDienThoaiResponse(dienThoai);
    }

    private DienThoai fromDienThoaiRequest(DienThoaiRequest request) {
        DienThoai dienThoai = modelMapper.map(request, DienThoai.class);
        dienThoai.setNhaCungCap(nhaCungCapRepository.findByIdRaw(request.getNhaCungCap()));
        return dienThoai;
    }

    private DienThoaiResponse toDienThoaiResponse(DienThoai dienThoai) {
        DienThoaiResponse dienThoaiResponse = modelMapper.map(dienThoai, DienThoaiResponse.class);
        dienThoaiResponse.setNhaCungCap(dienThoai.getNhaCungCap().getMaNCC());
        return dienThoaiResponse;
    }
}
