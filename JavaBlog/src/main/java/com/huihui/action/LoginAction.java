package com.huihui.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * Created by huihui on 14-10-22.
 */
public class LoginAction implements Action {
    private String username;
    private String password;

    public String execute() throws Exception {
        ActionContext ctx = ActionContext.getContext();
        //通过ActionContext访问application范围的属性置
        Integer counter = (Integer)ctx.getApplication().get("counter");

        if (counter == null) {
            counter = 1;
        }else {
            counter = counter + 1;
        }

        // 通过ActionContext设置application范围的属性
        ctx.getApplication().put("counter",counter);
        // 通过ActionContext设置session范围属性
        ctx.getSession().put("user",getUsername());

        if (getUsername().equals("huihui") && (getPassword().equals("0000"))) {
            // 通过ActionContext设置request范围属性
            ctx.put("tip","服务器提示：您已经成功的登录");
            return SUCCESS;
        }else {
            // 通过ActionContext设置request范围属性
            ctx.put("tip","服务器提示：登录失败");
            return ERROR;
        }

    }

    // get set 方法

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
}
