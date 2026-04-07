package com.corporate.talent.ui;

public class ConsoleBanners {

    public static void mainConsole (){
        String console = """
                -----------------------------
                |          MENU             |
                -----------------------------
                | 1) Management employees   |
                | 2) Search employee        |
                | 3) Watch employee salary  |
                | 4) Salary category        |
                | 5) Employee notes         |
                | 6) Exit                   |
                -----------------------------
                """
        ;

        System.out.println(console);
    }

    public static void banner(){
        String mainBanner = """

            ====================================================
                    SYSTEM: CORPORATE TALENT MANAGEMENT
            ====================================================
                    [Welcome to the main core system]

                            Status: Online
            ====================================================

            """
        ;

        System.out.println(mainBanner);

    }

    public static void managementConsole(){
        String console = """
                -----------------------------
                |          MENU             |
                -----------------------------
                | 1) Add new employee       |
                | 2) Watch all employees    |
                | 3) Remove employee        |
                | 4) Edit employee          |
                | 5) Back                   |
                -----------------------------
                """
        ;

        System.out.println(console);
    }
}
