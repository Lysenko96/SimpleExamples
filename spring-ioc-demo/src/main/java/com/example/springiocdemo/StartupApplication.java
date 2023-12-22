package com.example.springiocdemo;

import com.example.springiocdemo.model.CustomBean;

public class StartupApplication {

    public static void main(String[] args) {
        CustomContext context = new CustomContext();
        CustomBean customBean = context.getBean(CustomBean.class);
        customBean.printCustomBean();
    }
}
