package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.*;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
    @Autowired
    TravelService travelService;
    @Autowired
    PeopleService peopleService;
    @Autowired
    RentService rentService;

    @RequestMapping("/personInfo")
    public String personInfo(Model model,HttpSession session){
        List<Bill> bills = applyService.sbyname(String.valueOf(session.getAttribute("perid")));
        List<Travel> travels = travelService.sbyname(String.valueOf(session.getAttribute("perid")));
        List<Rent> rents = rentService.sbyname(String.valueOf(session.getAttribute("perid")));
        model.addAttribute("rent",rents);
        model.addAttribute("bills",bills);
        model.addAttribute("travels",travels);
        return "personInfo";
    }

    @RequestMapping("/selectku")
    public String selectku(String id,Model model){
        List<Librarylist> librarylists = libraryService.selectbyrid(id);

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        BigDecimal count = new BigDecimal(0);
        for (Librarylist i :
                librarylists) {
            BigDecimal money = new BigDecimal(decimalFormat.format(i.getMoney()));
            BigDecimal tax = new BigDecimal(decimalFormat.format(i.getTax()));
            count = count.add(tax.add(money));
        }
        model.addAttribute("library",librarylists);
        model.addAttribute("count",count);
        return "selectlibrary";
    }

    @RequestMapping("/selectpeople")
    public String selectpeople(String id,Model model){
        List<People> peopleList = peopleService.selectbyrid(id);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        BigDecimal count = new BigDecimal(0);
        for (People i :
                peopleList) {
            BigDecimal price = new BigDecimal(decimalFormat.format(i.getPrice()));
            count = count.add(price);
        }
        model.addAttribute("peopleList",peopleList);
        model.addAttribute("count",count);
        return "selectpeople";
    }


    @RequestMapping("/studioInfo")
    public String studio(HttpServletRequest request, HttpSession session, ModelMap model) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
//      是老师就显示信息
        if (teacher!=null){
            try{
                Studio studio = studioService.showinfo(teacher.getTid());
                List<Bill> bills = applyService.sbyid(studio.getSid());
                List<Travel> travels = travelService.sbyname(String.valueOf(session.getAttribute("perid")));
                model.addAttribute("travels",travels);
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
                List<Travel> travels = travelService.sbyname(String.valueOf(session.getAttribute("perid")));
                model.addAttribute("travels",travels);
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
