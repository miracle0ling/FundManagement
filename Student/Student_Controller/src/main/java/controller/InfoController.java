package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.*;
import service.ApplyService;
import service.LibraryService;
import service.ProjectService;
import service.StudioService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class InfoController {

    @Autowired
    StudioService studioService;
    @Autowired
    ApplyService applyService;
    @Autowired
    ProjectService projectService;
    @Autowired
    LibraryService libraryService;

    @RequestMapping("/personInfo")
    public String personInfo(Model model,HttpSession session){
        List<Bill> bills = applyService.sbyname(String.valueOf(session.getAttribute("perid")));
        model.addAttribute("bills",bills);
        return "personInfo";
    }

    @RequestMapping("/selectku")
    public String selectku(String id,Model model){
        List<Librarylist> librarylists = libraryService.selectbyrid(id);
        float count  = 0;
        for (Librarylist i :
                librarylists) {
            count+=i.getMoney()+i.getTax();
        }
        model.addAttribute("library",librarylists);
        model.addAttribute("count",count);
        return "selectlibrary";
    }


    @RequestMapping("/studioInfo")
    public String studio(HttpServletRequest request, HttpSession session, ModelMap model) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
//      是老师就显示信息
        if (teacher!=null){
            try{
                Studio studio = studioService.showinfo(teacher.getTid());
                List<Bill> bills = applyService.sbyid(studio.getSid());
                model.addAttribute("bills",bills);
                model.addAttribute("studio",studio);
                model.addAttribute("ifpri",1);
            }catch (NullPointerException e){
                model.addAttribute("ifpri",0);
                return "studioInfo";
            }
        }
        else {

            model.addAttribute("ifpri",0);
        }

        return "studioInfo";
    }

    @RequestMapping("/projectInfo")
    public String project(HttpServletRequest request, HttpSession session, ModelMap model) {
        Student student = (Student) session.getAttribute("student");
//      是负责人显示信息
        if (student!=null){
            if (student.getIfpri() == 1) {
                project project = projectService.PgetIfno(student.getSnum());
                List<Bill> bills = applyService.sbyid(project.getProid());
                model.addAttribute("bills",bills);
                model.addAttribute("project", project);
                model.addAttribute("ifpri",1);
            } else {
                model.addAttribute("ifpri",0);
            }
        } else {
            model.addAttribute("ifpri",0);
        }


        return "projectInfo";
    }

}
