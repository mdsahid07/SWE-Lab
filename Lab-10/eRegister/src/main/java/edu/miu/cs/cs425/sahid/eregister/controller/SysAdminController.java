package edu.miu.cs.cs425.sahid.eregister.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/secured/sysadmin"})
public class SysAdminController {

    @GetMapping(value = {"/index"})
    public String displaySysAdminPage() {
        return "secured/sysadmin/index";
    }

}
