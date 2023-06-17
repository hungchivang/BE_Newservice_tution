package onegroup.onekids_excel_v3.hoanh.import_Excel.service;

import com.example.onekids_project.import_Excel.ResponseBeforeUpload;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CallApiUploadService {


    public List<ResponseBeforeUpload> readDataFromExcel(MultipartFile file, int collectionTurn, String descriptionTurn) throws IOException {

        Path tempFile = Files.createTempFile("uploaded-file-", file.getOriginalFilename());
        file.transferTo(tempFile);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(tempFile.toFile()));
        body.add("collectionTurn",collectionTurn);
        body.add("descriptionTurn",descriptionTurn);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        String serviceUrl = "http://localhost:8080/uploadExcel";
        ResponseEntity<List<ResponseBeforeUpload>> responseEntity = new RestTemplate().exchange(serviceUrl, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<List<ResponseBeforeUpload>>() {
        });
        System.out.println("responseEntity.getBody()");
        System.out.println(responseEntity.getBody());
        System.out.println(responseEntity.getBody().size());
        return responseEntity.getBody();
    }

    public void saveDataFromExcelToDB(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        authentication.getName();

        System.out.println(authentication.getName());

    }


}
