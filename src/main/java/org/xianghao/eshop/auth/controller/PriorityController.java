package org.xianghao.eshop.auth.controller;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    /**
     * 根据父权限id查询子权限
     * @param parentId 父权限
     * @return 子权限
     * */
    @GetMapping("/child/{parentId}")
    public List<PriorityVO> listChildPriorities(
            @PathVariable("parentId") Long parentId){
        try {
            List<PriorityDTO> priorityDTOS = priorityService.listChildPriorities(parentId);
            if (priorityDTOS==null){
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
    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public PriorityVO getPriorityById(@PathVariable("id") Long id){
        try {
            PriorityDTO priorityDTO = priorityService.getPriorityById(id);
            if (priorityDTO == null){
                priorityDTO = new PriorityDTO();
            }
            return priorityDTO.clone(PriorityVO.class);
        }catch (Exception e){
            logger.error("error",e);
        }
        return new PriorityVO();
    }

    /**
     * 新增权限
     *
     * @param priorityVO 权限DO对象
     */
    @PostMapping("/")
    public Boolean savePriority(@RequestBody PriorityVO priorityVO){
        try {
            PriorityDTO priorityDTO = priorityVO.clone(PriorityDTO.class);
            priorityService.savePriority(priorityDTO);
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }
    /**
     * 更新权限
     *
     * @param priorityVO 权限DO对象
     */
    @PostMapping("/{id}")
    public Boolean updatePriority(@RequestBody PriorityVO priorityVO){
        try {
            PriorityDTO priorityDTO = priorityVO.clone(PriorityDTO.class);
            priorityService.updatePriority(priorityDTO);
        }catch (Exception e){
            logger.error("error",e);
            return false;
        }
        return true;
    }
    /**
     * 删除权限
     * */
    @Delete("/{id}")
    public Boolean removePriority(@PathVariable("id") Long id){
        try {
            return priorityService.removePriority(id);
        }catch (Exception e){
            logger.error("error",e);
        }
        return false;

    }
}
