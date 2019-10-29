package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.*;
import service.ApplyService;
import service.LibraryService;
import service.ProjectService;
import service.StudioService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ApplyController {

    @Autowired
    ApplyService applyService;
    @Autowired
    ProjectService projectService;
    @Autowired
    StudioService studioService;
    @Autowired
    LibraryService libraryService;

//    报销类别
    public String[] types = {"办公费","印刷费","专用材料费","其他商品和服务支出","专用设备购置","维修(护)费"};



    @RequestMapping("/ku")
    public String churuku() {
        return "library";
    }

//    添加异常处理 可能出现：空值，float输入为string
    @RequestMapping("/applyku")
    public String insertku(HttpServletRequest request,HttpSession session,Model model){
        try{
            String pid = request.getParameter("pid");
            model.addAttribute("pid",pid);
            if(pid.equals("")){
                model.addAttribute("errormassage","请先填写对应报销单内容");
                return "redirect:/application";
            }
            Bill bill = (Bill) session.getAttribute(pid);
            String[] tname = request.getParameterValues("lname");
            String[] dw = request.getParameterValues("lwork");
            String[] smoney = request.getParameterValues("money");
            String[] stax = request.getParameterValues("tax");
            String[] squantity = request.getParameterValues("quantity");
            List<Librarylist> librarylists = new ArrayList<>();
            for (int i = 0; i < tname.length; i++) {
                Librarylist librarylist = new Librarylist();
                float money = Float.parseFloat(smoney[i]);
                float tax = Float.parseFloat(stax[i]);
                int quantity = Integer.parseInt(squantity[i]);
                float unitprice = (money+tax)/quantity;
                librarylist.setDw(dw[i]);
                librarylist.setId(i+1);
                librarylist.setMoney(money);
                librarylist.setQuantity(quantity);
                librarylist.setTax(tax);
                librarylist.setUnitprice(unitprice);
                librarylist.setTname(tname[i]);
                librarylist.setRid(pid);
                librarylists.add(librarylist);
            }
            model.addAttribute("Librarylists",librarylists);
            float count = 0;
            for (Librarylist i:librarylists
            ) {
                count+=i.getMoney()+i.getTax();
            }
            System.out.println(count);
            if (Math.abs(count-bill.getAmoney())<0.001){

                for (Librarylist i:librarylists
                ) {
                    libraryService.insert(i);
                }

                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                bill.setTime(dateFormat.format(date).toString());
                applyService.inserttype2(bill);
            }else {
                model.addAttribute("errormassage","输入的金额不正确");
                return "library";
            }

        }catch (NullPointerException e){
            model.addAttribute("errormassage","检查是否有没输入的选项");
            return "library";
        }catch (NumberFormatException e){
            model.addAttribute("errormassage","请输入正确格式");
            return "library";
        }
        model.addAttribute("errormassage","提交成功");
        return "redirect:/application";
    }

    //    进入报销页面之前需要加载的内容
    @RequestMapping("/application")
    public String getApply(Model mode, HttpSession session,String errormassage) {
        List<project> projects = projectService.getNI();
        List<Studio> studios = studioService.getNI();
        mode.addAttribute("project",projects);
        mode.addAttribute("studio",studios);
        mode.addAttribute("errormassage",errormassage);
        return "application";
    }

    @RequestMapping("/getapply")
    public String apply(HttpServletRequest request, HttpSession session, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
//        竞赛 获取竞赛名 在竞赛表中查询 然后加入字段
//        String cname = request.getParameter();

        String leibie = request.getParameter("leibie");
        String type = request.getParameter("type");
        String amoney = request.getParameter("amoney");
        String method = request.getParameter("method");
        String people = request.getParameter("people");
        String tel = request.getParameter("tel");
        String proid = request.getParameter("proid");
        String sid = request.getParameter("sid");
        String mission = request.getParameter("mission");
        String art = request.getParameter("art");
        String author = request.getParameter("author");
        String baoxiao = request.getParameter("baoxiao");
        int status = 0;

        Bill bill = new Bill();
        bill.setLeibie(leibie);
        bill.setType(type);
        bill.setAmoney(Float.parseFloat(amoney));
        bill.setMethod(method);
        bill.setPeople(people);
        bill.setTel(tel);
        bill.setPersonid((String) session.getAttribute("perid"));
        if (!proid.equals("")||!sid.equals("")){
            if (proid.equals("")){
                try {
                    bill.setPid(sid);
                }catch (NullPointerException e){
                    model.addAttribute("errormassage","请选择对应项目/工作室");
                    return "redirect:/application";
                }
            }else {
                try {
                    bill.setPid(proid);
                }catch (NullPointerException e){
                    model.addAttribute("errormassage","请选择对应项目/工作室");
                    return "redirect:/application";
                }
            }
        }else {
            model.addAttribute("errormassage","请选择对应项目/工作室");
            return "redirect:/application";
        }
        Integer selectnum = applyService.selectnum(bill.getPid());
        String rid = bill.getPid()+"_"+selectnum.toString();
        bill.setRid(rid);


        if (type.equals("")){
            model.addAttribute("errormassage","请选择报销类别");
            return "redirect:/application";
        }

        if (type.equals("(版面、专利)委托业务费")){
            if(art.equals("")){
                model.addAttribute("errormassage","请选填写论文、专利名称");
                return "redirect:/application";
            }
            if(author.equals("")){
                model.addAttribute("errormassage","请选填写作者名称");
                return "redirect:/application";
            }
            bill.setArt(art);
            bill.setAuthor(author);
        }else {
            if(mission.equals("")){
                model.addAttribute("errormassage","请填写具体内容/任务/用处");
                return "redirect:/application";
            }
            bill.setMission(mission);
        }
        if (baoxiao.equals("")){
            model.addAttribute("errormassage","请选择有无报销凭证");
            return "redirect:/application";
        } else {
            if (baoxiao.equals("有")){
                bill.setBaoxiao(baoxiao);

                session.setAttribute(bill.getRid(), bill);
                model.addAttribute("pid",bill.getRid());
                return "library";
            }
            if (baoxiao.equals("无")||baoxiao.equals("欠")){
                bill.setBaoxiao(baoxiao);
                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                bill.setTime(dateFormat.format(date).toString());
                applyService.inserttype2(bill);
                model.addAttribute("errormassage","提交成功");
            }
        }
        return "redirect:/application";
    }

    @RequestMapping("/repeal")
    public String repeal(HttpServletRequest request){
        String id = request.getParameter("id");
        applyService.repeal(Integer.parseInt(id));
        return "redirect:/projectInfo";
    }

}
