package com.projects.oa.service.serviceImpl;

import com.projects.oa.repository.*;
import com.projects.oa.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 注册为服务层
 */
@Service
@Transactional(readOnly = true, rollbackFor = java.lang.RuntimeException.class)
public class IdentityServiceImpl implements IdentityService {

    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private PopedomRepository popedomRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

}
