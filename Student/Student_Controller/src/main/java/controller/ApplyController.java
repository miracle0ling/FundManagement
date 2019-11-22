package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.*;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
    @Autowired
    TravelService travelService;
    @Autowired
    PeopleService peopleService;
    @Autowired
    RentService rentService;
    @Autowired
    TypeService typeService;


    //    报销类别
    public String[] types = {"办公费", "印刷费", "专用材料费", "其他商品和服务支出", "专用设备购置", "维修(护)费"};


    @RequestMapping("/ku")
    public String churuku() {
        return "library";
    }

    //    添加异常处理 可能出现：空值，float输入为string
    @RequestMapping("/applyku")
    public String insertku(HttpServletRequest request, HttpSession session, Model model) {
        try {
            String pid = request.getParameter("pid");
            model.addAttribute("pid", pid);
            if (pid.equals("")) {
                model.addAttribute("errormassage", "请先填写对应报销单内容");
                return "redirect:/application";
            }
            Bill bill = (Bill) session.getAttribute(pid);
            String[] tname = request.getParameterValues("lname");
            String[] dw = request.getParameterValues("lwork");
            String[] smoney = request.getParameterValues("money");
            String[] stax = request.getParameterValues("tax");
            String[] squantity = request.getParameterValues("quantity");
            List<Librarylist> temp = new ArrayList<>();
            for (int i = 0; i < tname.length; i++) {
                Librarylist librarylist = new Librarylist();
                float money = Float.parseFloat(smoney[i]);
                float tax = Float.parseFloat(stax[i]);
                int quantity = Integer.parseInt(squantity[i]);
                librarylist.setDw(dw[i]);
                librarylist.setId(i + 1);
                librarylist.setMoney(money);
                librarylist.setQuantity(quantity);
                librarylist.setTax(tax);
                librarylist.setTname(tname[i]);
                librarylist.setRid(pid);
                temp.add(librarylist);
            }
            model.addAttribute("list",temp);
            List<Librarylist> librarylists = new ArrayList<>();
            for (int i = 0; i < tname.length; i++) {
                Librarylist librarylist = new Librarylist();
                float money = Float.parseFloat(smoney[i]);
                float tax = Float.parseFloat(stax[i]);
                int quantity = Integer.parseInt(squantity[i]);
                if (quantity == 0) {
                    model.addAttribute("errormassage", "输入数量不能为0");
                    return "library";
                }
                float unitprice = (money + tax) / quantity;
                librarylist.setDw(dw[i]);
                librarylist.setId(i + 1);
                librarylist.setMoney(money);
                librarylist.setQuantity(quantity);
                librarylist.setTax(tax);
                librarylist.setUnitprice(unitprice);
                librarylist.setTname(tname[i]);
                librarylist.setRid(pid);
                librarylists.add(librarylist);
            }
            model.addAttribute("Librarylists", librarylists);
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            BigDecimal count = new BigDecimal(0);
            for (Librarylist i :
                    librarylists) {
                BigDecimal money = new BigDecimal(decimalFormat.format(i.getMoney()));
                BigDecimal tax = new BigDecimal(decimalFormat.format(i.getTax()));
                count = count.add(tax.add(money));
            }
            if (count.compareTo(new BigDecimal(decimalFormat.format(bill.getAmoney())))==0) {

                for (Librarylist i : librarylists
                ) {
                    libraryService.insert(i);
                }

                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                bill.setTime(dateFormat.format(date).toString());
                applyService.inserttype2(bill);
            } else {
                model.addAttribute("errormassage", "输入的金额不正确");
                return "library";
            }

        } catch (NullPointerException e) {
            model.addAttribute("errormassage", "检查是否有没输入的选项");
            return "library";
        } catch (NumberFormatException e) {
            model.addAttribute("errormassage", "请输入正确格式");
            return "library";
        }
        model.addAttribute("errormassage", "提交成功");
        return "redirect:/application";
    }

    //    进入普通报销页面之前需要加载的内容
    @RequestMapping("/application")
    public String apply(Model mode, HttpSession session, String errormassage) {
        List<project> projects = projectService.getNI();
        List<Studio> studios = studioService.getNI();
        List<Type> typeList = typeService.selectgroup();

        mode.addAttribute("project", projects);
        mode.addAttribute("typeList", typeList);
        mode.addAttribute("studio", studios);
        mode.addAttribute("errormassage", errormassage);
        return "application";
    }

    //    进入差旅报销页面之前需要加载的内容
    @RequestMapping("/travelapply")
    public String travelapply(Model mode, HttpSession session, String errormassage) {
        List<project> projects = projectService.getNI();
        List<Studio> studios = studioService.getNI();
        mode.addAttribute("project", projects);
        mode.addAttribute("studio", studios);
        mode.addAttribute("errormassage", errormassage);
        return "travel";
    }

    //    进入借款报销页面之前需要加载的内容
    @RequestMapping("/rentapply")
    public String rentlapply(Model mode, HttpSession session, String errormassage) {
        List<project> projects = projectService.getNI();
        List<Studio> studios = studioService.getNI();
        List<Type> typeList = typeService.select();

        mode.addAttribute("typeList", typeList);
        mode.addAttribute("project", projects);
        mode.addAttribute("studio", studios);
        mode.addAttribute("errormassage", errormassage);
        return "rent";
    }


    @RequestMapping("/getapply")
    public String getApply(HttpServletRequest request, HttpSession session, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
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
        if (!proid.equals("") || !sid.equals("")) {
            if (proid.equals("")) {
                try {
                    bill.setPid(sid);
                } catch (NullPointerException e) {
                    model.addAttribute("errormassage", "请选择对应项目/工作室");
                    return "redirect:/application";
                }
            } else {
                try {
                    bill.setPid(proid);
                } catch (NullPointerException e) {
                    model.addAttribute("errormassage", "请选择对应项目/工作室");
                    return "redirect:/application";
                }
            }
        } else {
            model.addAttribute("errormassage", "请选择对应项目/工作室");
            return "redirect:/application";
        }
        Integer selectnum = applyService.selectnum(bill.getPid());
        String rid = bill.getPid() + "_" + selectnum.toString();
        bill.setRid(rid);


        if (type.equals("")) {
            model.addAttribute("errormassage", "请选择报销类别");
            return "redirect:/application";
        }

        if (type.equals("(版面、专利)委托业务费")) {
            if (art.equals("")) {
                model.addAttribute("errormassage", "请选填写论文、专利名称");
                return "redirect:/application";
            }
            if (author.equals("")) {
                model.addAttribute("errormassage", "请选填写作者名称");
                return "redirect:/application";
            }
            bill.setArt(art);
            bill.setAuthor(author);
        } else {

            if (mission.equals("")) {
                model.addAttribute("errormassage", "请填写具体内容/任务/用处");
                return "redirect:/application";
            }
            bill.setMission(mission);
        }
        session.setAttribute(bill.getRid(), bill);
        model.addAttribute("pid", bill.getRid());
        return "library";
    }

    @RequestMapping("/gettravelapply")
    public String getTravelApply(HttpServletRequest request, HttpSession session, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
//        竞赛 获取竞赛名 在竞赛表中查询 然后加入字段
//        String cname = request.getParameter();
        String leibie = request.getParameter("leibie");
        String pid = request.getParameter("pid");
        String sid = request.getParameter("sid");
        String mission = request.getParameter("mission");
        String startdate = request.getParameter("startdate");
        String endtdate = request.getParameter("enddate");
        String place = request.getParameter("place");
        String ppeople = request.getParameter("people");
        String tel = request.getParameter("tel");
        String hhmoney = request.getParameter("hmoney");
        String mmmoney = request.getParameter("mmoney");
        String ttmoney = request.getParameter("tmoney");
        String trmoney = request.getParameter("rmoney");
        String tpmoney = request.getParameter("pmoney");
        String tcmoney = request.getParameter("cmoney");
        String tfbmoney = request.getParameter("fbmoney");
        String ttbmoney = request.getParameter("tbmoney");
        String tomoney = request.getParameter("omoney");
        String ttbp = request.getParameter("tbp");
        String tfbp = request.getParameter("fbp");
        String method = request.getParameter("method");

        String[] pname = request.getParameterValues("pname");
        String[] smoney = request.getParameterValues("money");
        String[] transport = request.getParameterValues("transport");
        int status = 0;

        Travel travel = new Travel();
        List<People> peopleList = new ArrayList<>();
        travel.setLeibie(leibie);
        travel.setMission(mission);
        travel.setStartdate(startdate);
        travel.setEnddate(endtdate);
        travel.setPlace(place);
        travel.setPeople(ppeople);
        travel.setTel(tel);
        travel.setPersonid((String) session.getAttribute("perid"));
        travel.setStatus(status);
        travel.setMethod(method);


        if (!pid.equals("") || !sid.equals("")) {
            if (pid.equals("")) {
                try {
                    travel.setPid(sid);
                } catch (NullPointerException e) {
                    model.addAttribute("errormassage", "请选择对应项目/工作室");
                    return "redirect:/application";
                }
            } else {
                try {
                    travel.setPid(pid);
                } catch (NullPointerException e) {
                    model.addAttribute("errormassage", "请选择对应项目/工作室");
                    return "redirect:/application";
                }
            }
        } else {
            model.addAttribute("errormassage", "请选择对应项目/工作室");
            return "redirect:/application";
        }

//        项目编号+这个项目报销的次数=id
        Integer selectnum = travelService.selectnum(travel.getPid());
        String rid = travel.getPid() + "_" + selectnum.toString();
        travel.setTid(rid);

        try {
            float hmoney = Float.parseFloat(hhmoney);
            float mmoney = Float.parseFloat(mmmoney);
            float tmoney = Float.parseFloat(ttmoney);
            float pmoney = Float.parseFloat(tpmoney);
            float rmoney = Float.parseFloat(trmoney);
            float cmoney = Float.parseFloat(tcmoney);
            float omoney = Float.parseFloat(tomoney);
            int tbp = Integer.parseInt(ttbp);
            int fbp = Integer.parseInt(tfbp);
            int tbmoney = Integer.parseInt(ttbmoney);
            int fbmoney = Integer.parseInt(tfbmoney);
            travel.setHmoney(hmoney);
            travel.setMmoney(mmoney);
            travel.setTmoney(tmoney);
            travel.setPmoney(pmoney);
            travel.setCmoney(cmoney);
            travel.setRmoney(rmoney);
            travel.setOmoney(omoney);
            travel.setTbmoney(tbmoney*tbp*80);
            travel.setFbmoney(fbmoney*fbp*100);

            for (int i = 0; i < pname.length; i++) {
                float money = Float.parseFloat(smoney[i]);
                People people = new People();
                people.setPname(pname[i]);
                people.setPrice(money);
                people.setTid(rid);
                people.setTransport(transport[i]);
                peopleList.add(people);
            }

        } catch (NumberFormatException e) {
            model.addAttribute("errormassage", "请输入正确格式");
            return "redirect:/travelapply";
        } catch (NullPointerException e) {
            model.addAttribute("errormassage", "请点击添加按钮填写具体人员信息");
            return "redirect:/travelapply";
        }
//        插入
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        travel.setTime(dateFormat.format(date).toString());
        for (People i :
                peopleList) {
            peopleService.insert(i);
        }
        travelService.insert(travel);

        model.addAttribute("errormassage", "提交成功");
        return "redirect:/travelapply";
    }

    @RequestMapping("/getrentapply")
    public String getrentApply(HttpServletRequest request, HttpSession session, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
//        竞赛 获取竞赛名 在竞赛表中查询 然后加入字段
//        String cname = request.getParameter();

        String leibie = request.getParameter("leibie");
        String type = request.getParameter("type");
        String proid = request.getParameter("pid");
        String sid = request.getParameter("sid");
        String people = request.getParameter("people");
        String tel = request.getParameter("tel");
        String dw = request.getParameter("dw");
        String bank = request.getParameter("bank");
        String account = request.getParameter("account");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String method = request.getParameter("method");
        String mission = request.getParameter("mission");
        Rent rent = new Rent();
        try{
            float money = Float.parseFloat(request.getParameter("money"));
            rent.setMoney(money);
        }catch (NumberFormatException e){
            model.addAttribute("errormassage", "请输入正确格式");
            return "redirect:/rentapply";
        }
        int status = 0;


        rent.setPersonid((String) session.getAttribute("perid"));
        if (!proid.equals("") || !sid.equals("")) {
            if (proid.equals("")) {
                try {
                    rent.setPid(sid);
                } catch (NullPointerException e) {
                    model.addAttribute("errormassage", "请选择对应项目/工作室");
                    return "redirect:/rentapply";
                }
            } else {
                try {
                    rent.setPid(proid);
                } catch (NullPointerException e) {
                    model.addAttribute("errormassage", "请选择对应项目/工作室");
                    return "redirect:/rentapply";
                }
            }
        } else {
            model.addAttribute("errormassage", "请选择对应项目/工作室");
            return "redirect:/rentapply";
        }
        

        if (type.equals("")) {
            model.addAttribute("errormassage", "请选择报销类别");
            return "redirect:/rentapply";
        }
        rent.setLeibie(leibie);
        rent.setType(type);
        rent.setPeople(people);
        rent.setDw(dw);
        rent.setBank(bank);
        rent.setProvince(province);
        rent.setCity(city);
        rent.setTel(tel);
        rent.setStatus(status);
        rent.setAccount(account);
        rent.setMethod(method);
        rent.setMission(mission);

//        插入
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rent.setTime(dateFormat.format(date).toString());
        rentService.insert(rent);

        model.addAttribute("errormassage", "提交成功");
        return "redirect:/rentapply";
    }


    @RequestMapping("/repeal")
    public String repeal(HttpServletRequest request) {
        String id = request.getParameter("id");
        applyService.repeal(Integer.parseInt(id));
        return "redirect:/projectInfo";
    }

}
