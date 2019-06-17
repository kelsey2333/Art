/**
 * @Author wpzhang
 * @Date 2019/6/12
 * @Description
 */
package com.itek.netctoss.servlet;

import com.itek.netctoss.service.AccountService;
import com.itek.netctoss.service.impl.AccountServiceImpl;
import commons.Consts;
import dao.AccountDao;
import domain.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: netctoss
 * @description: 账务账号业务处理器
 * @author: wpzhang
 * @create: 2019-06-12 06:21
 **/
@WebServlet(name = "AccountServlet",urlPatterns = "*.acc")
public class AccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo 拦截地址用拦截器截取
        String requestURI =  req.getRequestURI();
        String uriStr = getUri(requestURI);

        switch (uriStr){
            case "list":
                AccountService accountService = new AccountServiceImpl();
                //获取点击下一页的属性值
                String pageNo = req.getParameter("pageNo");
                int endPage = accountService.getAccountEndPage();
                String idCard = req.getParameter("idCard");
                String realName = req.getParameter("realName");
                String loginName = req.getParameter("loginName");
                String status = req.getParameter("status");
                Account account = new Account(idCard,realName,loginName,status);
                int fuzzyQueryEndPage = accountService.getFuzzyQueryEndPage(account);
                //都一次进去list.acc里没有传入任何pageNo，需设默认值pageNo为1；
                if (pageNo == null){
                    pageNo = "1";
                }
                List<Account> accounts = accountService.selectAccountInfo(Integer.parseInt(pageNo),Consts.PAGE_SIZE ,account);
                req.setAttribute("accounts" ,accounts);
                req.setAttribute("curPage",pageNo);
                // 状态不需要考虑
                if (idCard != null||loginName != null||realName != null){
                    req.setAttribute("endPage",fuzzyQueryEndPage);
                }else {
                    req.setAttribute("endPage",endPage);
                }
                //查询账号列表页
                req.getRequestDispatcher("/WEB-INF/jsp/accountList.jsp").forward(req,resp);
                break;
            case "update":
                //修改账号列表页

                break;
            case "add":
                req.getRequestDispatcher("/WEB-INF/jsp/accountAdd.jsp").forward(req,resp);
                break;
            case "addAcc":
                //增加账号
                String addRealName = req.getParameter("realName");
                String idcardNo = req.getParameter("idcardNo");
                String addLoginName = req.getParameter("loginName");
                String addStatus = null;
                String loginPasswd = req.getParameter("loginPasswd");
                String telephone = req.getParameter("telephone");
                String recommenderId = req.getParameter("recommenderId");
                String birthdateStr = req.getParameter("birthdate");
                String email = req.getParameter("email");
                String occupation = req.getParameter("occupation");
                String gender = req.getParameter("gender");
                String mailaddress = req.getParameter("mailaddress");
                String zipcode = req.getParameter("zipcode");
                String qq = req.getParameter("qq");
                //通过用户名判断是否开通
                if (addLoginName != null){
                    addStatus = "1";
                }else{
                    addStatus = "0";
                }
                String occupationName = getOccupationByVal(occupation);

                Account addAccount = new Account(null,null,addLoginName,loginPasswd,addStatus,
                                                null,null,null,addRealName,idcardNo,birthdateStr,gender,occupationName,telephone,
                                                email,mailaddress,zipcode,qq,null,null);
                AccountService accountService1 = new AccountServiceImpl();
                accountService1.addAccounts(addAccount);
                break;
            case "del":
                //删除账号
                break;
        }
    }

    private String getOccupationByVal(String occupation) {
        //通过occupation 0 1 2 3 value值转换成响应职位
        switch (occupation){
            case "0":
                occupation = "干部";
                break;
            case "1":
                occupation = "学生";
                break;
            case "2":
                occupation = "技术人员";
                break;
            case "3":
                occupation = "其他";
                break;
        }
        return occupation;
    }

    /**
     * @Param
     * @description 获取后缀
     * @date 2019/6/12 6:44
     * @return
     */
    private String getUri(String requestURI) {
        int start = requestURI.lastIndexOf("/")+1;
        int end = requestURI.lastIndexOf(".");
        return requestURI.substring(start,end);
    }
}