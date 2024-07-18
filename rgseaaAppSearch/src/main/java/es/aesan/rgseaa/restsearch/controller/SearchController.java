package es.aesan.rgseaa.restsearch.controller;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);


    @GetMapping
    public String get(){
        logger.info("=========== LOG ===========");
        return "Bienvenido a RGSEAA / buscador";
    }

}
