package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.RgseaaActivityCriteria;
import es.aesan.rgseaa.model.dto.RgseaaActivityDto;
import es.aesan.rgseaa.service.facade.RgseaaActivityFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.RGSEAA_ACTIVITIES)
public class RgseaaActivityController extends AbstractController<
        RgseaaActivityDto,
        RgseaaActivityFacade,
        RgseaaActivityCriteria
        > {

    RgseaaActivityController(RgseaaActivityFacade facade) {super(facade);}
}
