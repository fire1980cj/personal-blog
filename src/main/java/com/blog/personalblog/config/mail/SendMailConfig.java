package com.blog.personalblog.config.mail;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SendMailConfig {

    public static void sendMail(MailInfo mailInfo){
        try{
            MailAccount account=new MailAccount();
            //邮件服务器SMTP地址
            account.setHost("smtp.qq.com");
            //邮件服务器的SMTP端口
            account.setPort(587);
            //发件人邮箱，写成自己的
            account.setFrom("363379412@qq.com");
            //邮箱授权码
            account.setPass("fsfev");
            //使用SSL安全连接
            account.setSslEnable(false);
            MailUtil.send(account,mailInfo.getReceiveMail(),mailInfo.getTitle(),mailInfo.getContent(),false);
            log.info("邮件发送成功！"+JSONUtil.toJsonStr(mailInfo));
        }catch (Exception e){
            log.error("邮件发送失败："+ JSONUtil.toJsonStr(mailInfo));
        }
    }
}
