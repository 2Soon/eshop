package org.xianghao.eshop.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xianghao.eshop.auth.domain.PriorityDTO;
import org.xianghao.eshop.auth.domain.PriorityVO;
import org.xianghao.eshop.auth.service.PriorityService;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限控制模块的Controller组件
 *
 * */
@RestController
@RequestMapping("/auth/priority")
public class PriorityController {
    private static final Logger logger = LoggerFactory.getLogger(PriorityController.class);

    @Autowired
    private PriorityService priorityService;

    /**
     * 查询根权限
     * @return 根权限集合
     * */
    @GetMapping("/root")
    public List<PriorityVO> ListRootPriorities(){

        try {
            List<PriorityDTO> priorityDTOS = priorityService.listRootPriorities();
            if (priorityDTOS== null){
                priorityDTOS = new ArrayList<PriorityDTO>();
            }
            ArrayList<PriorityVO> priorityVOS = new ArrayList<PriorityVO>(priorityDTOS.size());
            for (PriorityDTO priorityDTO : priorityDTOS) {
                priorityVOS.add(priorityDTO.clone(PriorityVO.class));
            }
            return priorityVOS;

        }catch (Exception e){
            logger.error("error",e);
        }

        return new ArrayList<PriorityVO>();
    }


}
