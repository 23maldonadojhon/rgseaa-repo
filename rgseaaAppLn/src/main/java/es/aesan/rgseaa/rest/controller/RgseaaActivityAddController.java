package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.commom.criteria.GeneralCriteria;
import es.aesan.rgseaa.model.dto.RgseaaActivityAddDto;
import es.aesan.rgseaa.service.facade.RgseaaActivityAddFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.RGSEAA_ACTIVITIES_ADD)
public class RgseaaActivityAddController extends AbstractController<
        RgseaaActivityAddDto,
        RgseaaActivityAddFacade,
        GeneralCriteria
    > {


    RgseaaActivityAddController(RgseaaActivityAddFacade facade) {
        super(facade);
    }

}
