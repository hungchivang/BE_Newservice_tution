package onegroup.onekids_excel_v3;

import onegroup.onekids_excel_v3.repository.fileStorage.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class OnekidsExcelV3Application implements CommandLineRunner {

    @Resource
    FilesStorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(OnekidsExcelV3Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------ONEKIDS APPLICATION STARTED---------------");
        System.out.println("---------------------------06/2023---------------");
        System.out.println();
        storageService.init();
    }

}
