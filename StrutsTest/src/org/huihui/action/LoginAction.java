package org.huihui.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by huihui on 14-10-26.
 */
public class LoginAction extends ActionSupport {
    // 定义封装请求参数的useranme和password
    private String username;
    private String password;

    // get set方法

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 定义处理用户请求的execute方法
    public String execute() throws Exception{
        //当username为huihui并且password为0000时即为登录

        if (getUsername().equals("huihui") && getPassword().equals("0000")) {
            ActionContext.getContext().getSession().put("user",getUsername());

            return SUCCESS;
        }else {
            return ERROR;
        }

    }
}
