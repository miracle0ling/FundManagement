package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import pojo.*;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    AdminService adminService;

    @Autowired
    ProjectService projectService;

    @Autowired
    BillService billService;

    @Autowired
    StudioService studioService;

    @Autowired
    LibraryService libraryService;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam("anum")String anum, @RequestParam("apwd")String apwd,Model model){
        HttpSession session = request.getSession();
        session.setAttribute("anum",anum);
        boolean login=adminService.selectUser(anum,apwd);
        if(login){
            Admin admin = adminService.selectAllUser(anum,apwd);
//            获取大创信息
            session.setAttribute("admin", admin);
            return "redirect:/notice";
        }
        return "login";
    }

    @RequestMapping(value="/notice")
    public String emailindex(HttpServletRequest request){
        return "notice";
    }

    @RequestMapping("/projectInfo")
    public String project(HttpServletRequest request,HttpSession session,Model model){
        List<Project> projectlist=projectService.selectproject();
        List<Bill> billList=billService.selectbill();
        model.addAttribute("projectlist",projectlist);
        model.addAttribute("billList",billList);
        return "projectInfo";
    }

    @RequestMapping("/studioInfo")
    public String studioInfo(HttpServletRequest request,HttpSession session,Model model){
        List<Studio> studiolist=studioService.selectstudio();
        List<Bill> billList=billService.selectbill();
        model.addAttribute("studiolist",studiolist);
        model.addAttribute("billList",billList);
        return "studioInfo";
    }

    @RequestMapping("/churukurid")
    public String churukurid(@RequestParam("rid")String rid,HttpServletRequest request,Model model){
        List<Library> libraryList=libraryService.selectridlist(rid);
        Bill bill=billService.billindex2(rid);
        model.addAttribute("bill",bill);
        model.addAttribute("libraryList",libraryList);
        return "churuku";
    }

    @RequestMapping("/churuku")
    public String churuku(HttpServletRequest request,Model model){
        return "churuku";
    }


    @RequestMapping("/projectindex")
    public String projectindex(@RequestParam("proid")String proid, Model model,@RequestParam("pid")String pid,HttpServletRequest request){
        Project project=projectService.projectindex(proid);
        List<Bill> billList=billService.billindex(pid);
        List<Bill> billList2 = new ArrayList<>();
        for (int i=0;i<billList.size();i++) {
            String tname="";
            int count=0;
            Bill bill = new Bill();
            List<Library> libraryList=libraryService.selectridlist(billList.get(i).getRid());
            bill.setId(billList.get(i).getId());
            bill.setPid(billList.get(i).getPid());
            bill.setType(billList.get(i).getType());
            bill.setAmoney(billList.get(i).getAmoney());
            bill.setPeople(billList.get(i).getPeople());
            bill.setTel(billList.get(i).getTel());
            bill.setBaoxiao(billList.get(i).getBaoxiao());
            bill.setLeibie(billList.get(i).getLeibie());
            bill.setStatus(billList.get(i).getStatus());
            bill.setRid(billList.get(i).getRid());
            bill.setTime(billList.get(i).getTime());
            for (Library library : libraryList) {
                tname = tname + library.getTname() + "、";
                count++;
                if (count >= 3) {
                    tname = tname + "......";
                    break;
                }
            }
            bill.setTname(tname);
            billList2.add(bill);
        }
        model.addAttribute("billList2",billList2);
        model.addAttribute("project",project);
        return "projectindex";
    }

    @RequestMapping("/studioindex")
    public String studioindex(Model model,@RequestParam("pid")String pid,@RequestParam("sid")String sid,HttpServletRequest request){
        Studio studio=studioService.studioindex(sid);
        List<Bill> billList=billService.billindex(pid);
        List<Bill> billList2 = new ArrayList<>();
        for (int i=0;i<billList.size();i++) {
            String tname="";
            int count=0;
            Bill bill = new Bill();
            List<Library> libraryList=libraryService.selectridlist(billList.get(i).getRid());
            bill.setId(billList.get(i).getId());
            bill.setPid(billList.get(i).getPid());
            bill.setType(billList.get(i).getType());
            bill.setAmoney(billList.get(i).getAmoney());
            bill.setPeople(billList.get(i).getPeople());
            bill.setTel(billList.get(i).getTel());
            bill.setBaoxiao(billList.get(i).getBaoxiao());
            bill.setLeibie(billList.get(i).getLeibie());
            bill.setStatus(billList.get(i).getStatus());
            bill.setRid(billList.get(i).getRid());
            bill.setTime(billList.get(i).getTime());
            for (Library library : libraryList) {
                tname = tname + library.getTname() + "、";
                count++;
                if (count >= 3) {
                    tname = tname + "......";
                    break;
                }
            }
            bill.setTname(tname);
            billList2.add(bill);
        }
        model.addAttribute("billList2",billList2);
        model.addAttribute("studio",studio);
        return "studioindex";
    }

    @RequestMapping("/application")
    public String application(HttpServletRequest request,Model model,HttpSession session){
        List<Bill> billList=billService.selectbill();
        List<Bill> billList1 = new ArrayList<>();
        for (int i=0;i<billList.size();i++) {
            String tname="";
            int count=0;
            Bill bill = new Bill();
            List<Library> libraryList=libraryService.selectridlist(billList.get(i).getRid());
                bill.setId(billList.get(i).getId());
                bill.setPid(billList.get(i).getPid());
                bill.setType(billList.get(i).getType());
                bill.setAmoney(billList.get(i).getAmoney());
                bill.setPeople(billList.get(i).getPeople());
                bill.setTel(billList.get(i).getTel());
                bill.setBaoxiao(billList.get(i).getBaoxiao());
                bill.setLeibie(billList.get(i).getLeibie());
                bill.setStatus(billList.get(i).getStatus());
                bill.setRid(billList.get(i).getRid());
                bill.setTime(billList.get(i).getTime());
                for (Library library : libraryList) {
                        tname = tname + library.getTname() + "、";
                        count++;
                        if (count >= 3) {
                            tname = tname + "......";
                            break;
                        }
                }
                bill.setTname(tname);
                billList1.add(bill);
        }
        session.setAttribute("billList1",billList1);
        return "application";
    }

    @RequestMapping("/tongyiapplication")
    public String tongyiapplication(HttpServletRequest request,@RequestParam("id")String id,@RequestParam("amoney")float amoney,@RequestParam("pid")String pid,@RequestParam("leibie")String leibie){
        billService.tongyiapplication("1",id);
        if(leibie.equals("project")) {
            Project project = projectService.projectindex(pid);
            float used = project.getUsed() + amoney;
            projectService.updateused(used, pid);
            project = projectService.projectindex(pid);
            float total = project.getTotal();
            float usable = total - project.getUsed();
            projectService.updateusable(usable, pid);
        }
        if(leibie.equals("studio")) {
            Studio studio = studioService.studioindex(pid);
            float used = studio.getUsed() + amoney;
            studioService.updateused(used, pid);
            studio = studioService.studioindex(pid);
            float total = studio.getTotal();
            float usable = total - studio.getUsed();
            studioService.updateusable(usable, pid);
        }
        return "redirect:/application";
    }

    @RequestMapping("/jujueapplication")
    public String jujueapplication(HttpServletRequest request,@RequestParam("id")String id){
        Bill bill=billService.billindex1(id);
        billService.jujueapplication(id);
        libraryService.deletelibrary(bill.getRid());
        return "redirect:/application";
    }

    @RequestMapping("/selectleibie")
    public String selectleibie(@RequestParam("leibie")String leibie, Model model){
        if(leibie.equals("全部")){
            return "redirect:/application";
        }
       List<Bill> billList= adminService.selectleibieregistry(leibie);
       if(billList!=null){
           model.addAttribute("billList",billList);
           return "application";
       }
        return "application";
    }

    @RequestMapping("/changeapplication")
    public String changeapplication(HttpSession session,@RequestParam("id")String id, @RequestParam("pid")String pid, @RequestParam("leibie")String leibie, @RequestParam("tname")String tname, @RequestParam("type")String type, @RequestParam("amoney")float amoney, @RequestParam("people")String people, @RequestParam("tel")String tel, @RequestParam("baoxiao")String baoxiao, Model model) throws IOException {
        Bill bill=new Bill();
        bill.setId(id);
        bill.setPid(pid);
        bill.setLeibie(leibie);
        bill.setTname(tname);
        bill.setType(type);
        bill.setAmoney(amoney);
        bill.setPeople(people);
        bill.setTel(tel);
        bill.setBaoxiao(baoxiao);
        session.setAttribute("bill",bill);
        return "changeapplication";
    }

    @RequestMapping("/updateapplication")
    public String updateapplication(HttpSession session, @RequestParam("leibie")String leibie,@RequestParam("type")String type, @RequestParam("amoney")String amoney, @RequestParam("people")String people, @RequestParam("tel")String tel){
        Bill bill= (Bill) session.getAttribute("bill");
        billService.updateapplication(leibie,type,amoney,people,tel,bill.getId());
        return "redirect:/application";
    }

    @RequestMapping("/changechuruku")
    public String changechuruku(HttpSession session, @RequestParam("rid")String rid) throws IOException {
        List<Library> libraryList=libraryService.selectridlist(rid);
        session.setAttribute("libraryList",libraryList);
        return "changechuruku";
    }

    @RequestMapping("/updatechuruku")
    public String updatechuruku(HttpSession session,@RequestParam("zid")String zid, @RequestParam("tname")String tname, @RequestParam("dw")String dw,@RequestParam("unitprice")String unitprice, @RequestParam("money")String money, @RequestParam("quantity")String quantity){
        libraryService.updatelibrary(tname,dw,unitprice,money,quantity,zid);
        return "redirect:/application";
    }

    @RequestMapping("/exportword")
    public String exportword(@RequestParam("rid")String rid,HttpServletRequest request,HttpServletResponse response){
        System.out.println(rid);
        List<Library> libraryList=libraryService.selectridlist(rid);
        Bill bill=billService.billindex2(rid);
        int index=libraryList.size();
        WordUtils test = new WordUtils(freeMarkerConfigurer);
        try {
            test.exportMillCertificateWord(request, response, libraryList,index,bill.getAmoney());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/churukurid";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "login";
    }
}