package com.shuttle.service.controll;

import com.shuttle.service.entity.ReturnMessage;
import com.shuttle.service.entity.Services;
import com.shuttle.service.service.ServiceService;
import com.shuttle.service.service.imp.ServiceServiceIpm;
import com.shuttle.service.utils.ReturnMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/service")
public class ServiceController {

    private ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceServiceIpm serviceService) {
        this.serviceService = serviceService;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Services services) {
        serviceService.insert(services);
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        serviceService.delete(id);
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Services services) {
        serviceService.update(services);
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(serviceService.findAll(option));
    }

    @RequestMapping(value = "/exist/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> exist(@PathVariable long id) {
        return ReturnMessageUtil.success(serviceService.exist(id));
    }
}