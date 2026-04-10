package com.corporate.talent.ui;

public interface ConsoleBanners {

    static void mainConsole (){
        String console = """
                -----------------------------
                |          MENU             |
                -----------------------------
                | 1) Management employees   |
                | 2) Management Business    |
                | 3) Search employee        |
                | 4) Watch employee salary  |
                | 5) Salary category        |
                | 6) Employee notes         |
                | 7) Exit                   |
                -----------------------------
                """
        ;

        System.out.println(console);
    }

    static void banner(){
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

    static void managementEmployee(){
        String console = """
                -----------------------------
                |          MENU             |
                -----------------------------
                | 1) Add new employee       |
                | 2) Watch all employees    |
                | 3) Remove employee        |
                | 4) Edit employee          |
                | 5) Employee reports       |
                | 6) Back                   |
                -----------------------------
                """
        ;

        System.out.println(console);
    }

    static void managementBusiness(){
        String console = """
                -----------------------------
                |          MENU             |
                -----------------------------
                | 1) Add new business       |
                | 2) Watch all businesses   |
                | 3) Remove business        |
                | 4) Edit business          |
                | 5) Business reports       |
                | 6) Back                   |
                -----------------------------
                """
                ;

        System.out.println(console);
    }

    static void employeesData(){
        String console = """
                -----------------------------
                |          MENU             |
                -----------------------------
                | 1) Employees first-last   |
                | 2) Employees DESC         |
                | 3) Employee report        |
                | 4) Back                   |
                -----------------------------
                """
                ;

        System.out.println(console);
    }

    static void employeesInfo(int total, int declined, double salaries, double average) {
        String console = """
                -----------------------------
                |      Employees Data       |
                -----------------------------
                | Total Employees: %d
                | Declined Employees: %d
                | Total Salaries: $%.2f
                | Average Salaries: $%.2f
                -----------------------------
                """.formatted(total, declined, salaries, average);

        System.out.println(console);
    }

}
