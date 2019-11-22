package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Librarylist;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

@Controller
public class Ajax {

    @RequestMapping(value = "ajaxgetcount",method = RequestMethod.POST)
    @ResponseBody
    public String getcount(HttpServletRequest request,@RequestParam(value = "money[]")String[] money,@RequestParam(value = "tax[]")String[] tax){
        BigDecimal count = new BigDecimal(0);
        for (int i = 0; i < money.length; i++) {
            BigDecimal tmoney = new BigDecimal(money[i]);
            BigDecimal ttax = new BigDecimal(tax[i]);
            System.out.println(tmoney+"  "+ttax);
            count = count.add(ttax.add(tmoney));
        }
        return String.valueOf(count);
    }

    @RequestMapping(value = "ajaxgettravel",method = RequestMethod.POST)
    @ResponseBody
    public String gettarvel(@RequestParam(value = "mmoney")String mmoney,
                            @RequestParam(value = "hmoney")String hmoney,
                            @RequestParam(value = "pmoney")String pmoney,
                            @RequestParam(value = "rmoney")String rmoney,
                            @RequestParam(value = "cmoney")String cmoney,
                            @RequestParam(value = "omoney")String omoney,
                            @RequestParam(value = "tmoney")String tmoney,
                            @RequestParam(value = "fbmoney")String fbmoney,
                            @RequestParam(value = "tbmoney")String tbmoney,
                            @RequestParam(value = "fbp")String fbp,
                            @RequestParam(value = "tbp")String tbp){
        BigDecimal tmmoney = new BigDecimal(mmoney);
        BigDecimal ttmoney = new BigDecimal(tmoney);
        BigDecimal thmoney = new BigDecimal(hmoney);
        BigDecimal tpmoney = new BigDecimal(pmoney);
        BigDecimal trmoney = new BigDecimal(rmoney);
        BigDecimal tcmoney = new BigDecimal(cmoney);
        BigDecimal tomoney = new BigDecimal(omoney);
        int fbm = Integer.parseInt(fbmoney);
        int tbm = Integer.parseInt(tbmoney);
        int ffm = Integer.parseInt(fbp);
        int ttm = Integer.parseInt(tbp);
        BigDecimal count = thmoney.add(tcmoney.add(tmmoney.add(tomoney.add(trmoney.add(tpmoney.add(ttmoney))))));
        int count2 = fbm*ffm*100+tbm*ttm*80;
        count=count.add(new BigDecimal(count2));
        return String.valueOf(count);
    }

}
