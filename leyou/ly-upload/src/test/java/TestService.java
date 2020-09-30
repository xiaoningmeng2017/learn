import com.leyou.LyUploadApplication;
import com.leyou.upload.service.UploadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LyUploadApplication.class)
public class TestService {

    @Autowired
    private UploadService uploadService;

    @Test
    public void testService(){
        MultipartFile file = (MultipartFile) new File("C:\\Users\\zhangkun\\Desktop\\20200924111907.jpg");
        this.uploadService.upload(file);
    }

//    @Test
//    public void testService1(){
//        this.uploadService.upload1();
//    }
}
