package iuh.fit.se.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.services.DienThoaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class DienThoaiServiceImpl implements DienThoaiService {
    private final RestClient restClient;
    private final ObjectMapper objectMapper;
}
