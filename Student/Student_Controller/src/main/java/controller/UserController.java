package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.*;
import service.StudioService;
import service.login;
import service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    login userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    StudioService studioService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam("snum") String snum, @RequestParam("spwd") String spwd, Model model) {
        HttpSession session = request.getSession();
        session.setAttribute("snum", snum);
        if (userService.judges(snum, spwd)) {
            Student student = userService.selects(snum);
            session.setAttribute("student", student);
            session.setAttribute("pername", student.getSname());
            session.setAttribute("perid", student.getSnum());
            return "redirect:/notice";
        }
        if (userService.judget(snum, spwd)){
            Teacher teacher = userService.selectt(snum);
            session.setAttribute("teacher", teacher);
            session.setAttribute("pername", teacher.getTname());
            session.setAttribute("perid", teacher.getTid());
            return "redirect:/notice";
        }
        return "login";
    }

    @RequestMapping(value = "/notice")
    public String emailindex(HttpServletRequest request) {
        return "notice";
    }



    @RequestMapping("/forgetpassword")
    public String password(Model model){
        return "forgetPassword";
    }

    @RequestMapping("/teacherreg")
    public String teacherreg(Model model){
        return "teacherreg";
    }

    @RequestMapping("/passwordReset")
    public String paaswordReset(Model model, String snum, String sname, String spwd, String spwdConvinced, String sid){
        if (snum == null || sname == null || spwd == null || spwdConvinced == null || sid == null) {
            return "redirect:login.html";
        }
        Student student = userService.selects(snum);
        if (userService.ifsexist(snum)) {
            model.addAttribute("errorMessage", "此账号已进行过激活操作，有问题请联系维护人员");
            model.addAttribute("snum", snum);
            model.addAttribute("spwd", spwd);
            model.addAttribute("spwdConvinced", spwdConvinced);
            model.addAttribute("sname", sname);
            model.addAttribute("sid", sid);
            return "forgetPassword";
        }else if (userService.ifastudent(snum)) {
            model.addAttribute("errorMessage", "所提交的信息有误，请检查后重试！");
            model.addAttribute("snum", snum);
            model.addAttribute("spwd", spwd);
            model.addAttribute("spwdConvinced", spwdConvinced);
            model.addAttribute("sname", sname);
            model.addAttribute("sid", sid);
            return "forgetPassword";
        } else if (!sname.trim().equals(student.getSname()) || !sid.trim().equals(student.getSid()) || spwd == null || sid.trim().length() != 18) {
            model.addAttribute("errorMessage", "所提交的信息有误，请检查后重试！");
            model.addAttribute("snum", snum);
            model.addAttribute("spwd", spwd);
            model.addAttribute("spwdConvinced", spwdConvinced);
            model.addAttribute("sname", sname);
            model.addAttribute("sid", sid);
            return "forgetPassword";
        } else if (!spwd.equals(spwdConvinced)) {
            model.addAttribute("errorMessage", "两次密码内容不一致！");
            model.addAttribute("snum", snum);
            model.addAttribute("spwd", spwd);
            model.addAttribute("spwdConvinced", spwdConvinced);
            model.addAttribute("sname", sname);
            model.addAttribute("sid", sid);
            return "forgetPassword";
        } else if (spwd.length() < 6) {
            model.addAttribute("errorMessage", "密码长度应不少于6位");
            model.addAttribute("snum", snum);
            model.addAttribute("spwd", spwd);
            model.addAttribute("spwdConvinced", spwdConvinced);
            model.addAttribute("sname", sname);
            model.addAttribute("sid", sid);
            return "forgetPassword";
        }
        student.setSpwd(spwd);
        if(projectService.ifpri(snum)){
            student.setIfpri(1);
        }else {
            student.setIfpri(0);
        }
        userService.setspassword(student);
        model.addAttribute("snum", snum);
        return "login";
    }

    @RequestMapping("/tpasswordReset")
    public String tpaaswordReset(Model model, String snum, String sname, String spwd, String spwdConvinced){
        if (snum == null || sname == null || spwd == null || spwdConvinced == null) {
            return "redirect:login";
        }

        Teacher teacher = userService.selectt(snum);
       try {
           if (!sname.trim().equals(teacher.getTname())|| spwd == null) {
               model.addAttribute("errorMessage", "所提交的信息有误，请检查后重试！");
               model.addAttribute("snum", snum);
               model.addAttribute("spwd", spwd);
               model.addAttribute("spwdConvinced", spwdConvinced);
               model.addAttribute("sname", sname);
               return "teacherreg";
           }else if (userService.iftexist(snum)) {
               model.addAttribute("errorMessage", "此账号已进行过激活操作，有问题请联系维护人员");
               model.addAttribute("snum", snum);
               model.addAttribute("spwd", spwd);
               model.addAttribute("spwdConvinced", spwdConvinced);
               model.addAttribute("sname", sname);
               return "teacherreg";
           } else if (!spwd.equals(spwdConvinced)) {
               model.addAttribute("errorMessage", "两次密码内容不一致！");
               model.addAttribute("snum", snum);
               model.addAttribute("spwd", spwd);
               model.addAttribute("spwdConvinced", spwdConvinced);
               model.addAttribute("sname", sname);
               return "teacherreg";
           } else if (spwd.length() < 6) {
               model.addAttribute("errorMessage", "密码长度应不少于6位");
               model.addAttribute("snum", snum);
               model.addAttribute("spwd", spwd);
               model.addAttribute("spwdConvinced", spwdConvinced);
               model.addAttribute("sname", sname);
               return "teacherreg";
           }
       }catch (NullPointerException e){
           model.addAttribute("errorMessage", "所提交的信息有误，请检查后重试！");
           return "teacherreg";
       }
        teacher.setPassword(spwd);
        userService.settpassword(teacher);
        model.addAttribute("snum", snum);
        return "login";
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request,HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

}
