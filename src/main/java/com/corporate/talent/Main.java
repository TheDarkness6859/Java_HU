package com.corporate.talent;

import com.corporate.talent.services.Laboratory;
import com.corporate.talent.ui.ConsoleBanners;
import com.corporate.talent.ui.NavConsole;


public class Main {

    public static void main(String[] args) {

        //Instances
        Laboratory lab = new Laboratory();
        NavConsole console = new NavConsole();

        ConsoleBanners.banner();
        console.navConsole();

        //lab.laboratory();

    }
}

