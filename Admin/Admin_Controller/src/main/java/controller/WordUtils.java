package controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import pojo.Library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class WordUtils {
    static final int wdDoNotSaveChanges = 0;// 不保存待定的更改。
    static final int wdFormatPDF = 17;// PDF 格式
    private Configuration configuration = null;
    public WordUtils(FreeMarkerConfigurer freeMarkerConfigurer) {
        configuration = freeMarkerConfigurer.getConfiguration();
        configuration.setDefaultEncoding("UTF-8");
    }

    public File createWord(List<Library> libraryList,int index,float amoney) {
        Map<String, Object> dataMap =new HashMap<String, Object>();
        List<Map<String, Object>> libraryList1= new ArrayList<Map<String, Object>>();
        for(int i=0;i<index;i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("index",i+1);
            map.put("tname", libraryList.get(i).getTname());
            map.put("dw", libraryList.get(i).getDw());
            map.put("unitprice", libraryList.get(i).getUnitprice());
            map.put("money", libraryList.get(i).getMoney());
            map.put("quantity", libraryList.get(i).getQuantity());
            libraryList1.add(map);
        }
        dataMap.put("libraryList1",libraryList1);
        dataMap.put("amoney",amoney);
        //configuration.setClassForTemplateLoading(this.getClass(), "classpath:ftl/");//模板文件所在路径
        Template t = null;
        try {
            t = configuration.getTemplate("churuku1.ftl"); //获取模板文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*/usr/local/dataFile/创新楼创客教室学生活动备案审批表.ftl*/
        File outFile = new File("C:\\Users\\Administrator\\Desktop\\churuku2.doc"); //导出文件
        Writer out = null;
        try {
            FileOutputStream fos = new FileOutputStream(outFile);
            OutputStreamWriter oWriter = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            out = new BufferedWriter(oWriter);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            t.process(dataMap, out); //将填充数据填入模板文件并输出到目标文件
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outFile;
    }
//
//    private void getData(Map<String, Object> dataMap, List<Library> libraryList,int index) {
//
//    }

    public void exportMillCertificateWord(HttpServletRequest request, HttpServletResponse response, List<Library> libraryList,int index,float amoney) throws IOException {
        File file = createWord(libraryList,index,amoney);
        String fileName=file.getName();
        String ext=fileName.substring(fileName.lastIndexOf(".")+1);
        String agent=(String)request.getHeader("USER-AGENT"); //判断浏览器类型
        try {
            if(agent!=null && agent.indexOf("Fireforx")!=-1) {
                fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");   //UTF-8编码，防止输出文件名乱码
            }
            else {
                fileName=URLEncoder.encode(fileName,"UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BufferedInputStream bis=null;
        OutputStream os=null;
        response.reset();
        response.setCharacterEncoding("utf-8");
        if(ext=="docx") {
            response.setContentType("application/msword"); // word格式
        }else if(ext=="pdf") {
            response.setContentType("application/pdf"); // pdf格式
        }
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        try {
            bis=new BufferedInputStream(new FileInputStream(file));
            byte[] b=new byte[bis.available()+1000];
            int i=0;
            os = response.getOutputStream();   //直接下载导出
            while((i=bis.read(b))!=-1) {
                os.write(b, 0, i);
            }
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}