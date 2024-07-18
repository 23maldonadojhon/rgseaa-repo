package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.dto.DocumentDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileUtilService {

    @Value("${path.repo.file}")
    private String pathFile;


    private static final Logger logger = LoggerFactory.getLogger(FileUtilService.class);


    public void saveFileList(List<DocumentDto> fileList, Long idProduct){
        logger.info("==== saveFileList ====");
        logger.info("Size="+fileList.size());

        fileList.forEach(item->saveFile(item,idProduct));
    }


    public String getFile(String filePath){
        logger.info("==== base64ToFile====");
        logger.info("path="+filePath);

        Path path = Paths.get(filePath);
        String base64Encoded="";

        try {
            byte[] fileBytes = Files.readAllBytes(path);
            base64Encoded = Base64.getEncoder().encodeToString(fileBytes);
        } catch (IOException e) {
            logger.error("ERROR="+e);
        }

        return base64Encoded;
    }


    public String getNameFile(String filePath){
        logger.info("==== getNameFile====");
        logger.info("path="+filePath);

        Path path = Paths.get(filePath);

        return path.getFileName().toString();
    }



    public String saveFile(DocumentDto document, Long idProduct){
        logger.info("==== base64ToFile====");
        logger.info("Name="+document.getB64().getName());
        logger.info("PathFile="+pathFile);

        String pathFileName = pathFile+document.getB64().getName();

        try(FileOutputStream fos = new FileOutputStream(pathFileName)){

            byte[] decoderBytes = Base64.getDecoder().decode(document.getB64().getData());
            fos.write(decoderBytes);

        } catch (IOException e) {
            logger.error("ERROR="+e);
        }

        return pathFileName;
    }

}
