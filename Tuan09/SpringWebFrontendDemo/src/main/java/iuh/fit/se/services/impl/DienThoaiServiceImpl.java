package iuh.fit.se.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.exceptions.AppException;
import iuh.fit.se.exceptions.ErrorCode;
import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DienThoaiServiceImpl implements DienThoaiService {
    private final RestClient restClient;
    private final ObjectMapper objectMapper;
    @Value("${backend.basic-path}")
    private String endPoint;

    @Override
    public ApiResponse<List<DienThoai>> findByNhaCungCap_MaNCC(String maNCC) {
        return restClient.get().uri(endPoint + "dienThoai/byNhaCungCap/" + maNCC).accept(MediaType.APPLICATION_JSON)
                .exchange((_, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0) {
                            throw new AppException(ErrorCode.NO_CONTENT);
                        }

                        return objectMapper
                                .readValue(body, new TypeReference<>() {});
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new AppException(ErrorCode.CANT_PROCESS);
                    }
                });
    }

    @Override
    public ApiResponse<DienThoai> save(DienThoai dienThoai,
                                       MultipartFile hinhAnhFile) {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
        body.add("dienThoai", dienThoai);
        body.add("hinhAnhFile", hinhAnhFile.getResource());
        return restClient.post().uri(endPoint + "dienThoai").accept(MediaType.APPLICATION_JSON)
                .body(body).exchange((_, response) -> {
                    try (InputStream body2 = response.getBody()) {
                        if (body2.available() == 0) {
                            throw new AppException(ErrorCode.NO_CONTENT);
                        }

                        return objectMapper
                            .readValue(body2, new TypeReference<>() {});
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new AppException(ErrorCode.CANT_PROCESS);
                    }
                });
    }

    @Override
    public ApiResponse delete(String id) {
        return restClient.delete().uri(endPoint + "dienThoai?id=" + id).accept(MediaType.APPLICATION_JSON)
                .exchange((_, respone) -> {
                    try (InputStream body = respone.getBody()) {
                        if (body.available() == 0) {
                            throw new AppException(ErrorCode.NO_CONTENT);
                        }
                        return objectMapper.readValue(body, new TypeReference<>() {});
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new AppException(ErrorCode.CANT_PROCESS);
                    }
                });
    }

    @Override
    public ApiResponse<DienThoai> findById(String id) {
        return restClient.get().uri(endPoint + "dienThoai/" + id).accept(MediaType.APPLICATION_JSON)
                .exchange((_, respone) -> {
                    try (InputStream body = respone.getBody()) {
                        if (body.available() == 0) {
                            throw new AppException(ErrorCode.NO_CONTENT);
                        }
                        return objectMapper.readValue(body, new TypeReference<>() {});
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new AppException(ErrorCode.CANT_PROCESS);
                    }
                });
    }
}
