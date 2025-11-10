package iuh.fit.se.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.entities.NhaCungCap;
import iuh.fit.se.exceptions.AppException;
import iuh.fit.se.exceptions.ErrorCode;
import iuh.fit.se.services.NhaCungCapService;
import iuh.fit.se.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NhaCungCapServiceImpl implements NhaCungCapService {
    private final RestClient restClient;
    private final ObjectMapper objectMapper;
    @Value("${backend.basic-path}")
    private String endPoint;

    @Override
    public ApiResponse<List<NhaCungCap>> findAll() {
        return restClient.get().uri(endPoint + "nhaCungCap").accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    try (InputStream body = response.getBody()) {
                        if (body.available() == 0) {
                            throw new AppException(ErrorCode.NO_CONTENT);
                        }

                        return objectMapper
                                .<ApiResponse<List<NhaCungCap>>>readValue(body, new TypeReference<>() {});
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new AppException(ErrorCode.CANT_PROCESS);
                    }
                });
    }
}
