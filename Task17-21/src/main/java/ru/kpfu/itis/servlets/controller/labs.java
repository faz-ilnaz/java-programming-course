package ru.kpfu.itis.servlets.controller;


public enum labs {

    f_java("Fujitsu Java"),
    f_retail("Fujitsu Retail"),
    f_wats("Fujitsu WATS"),
    f_testing("Fujitsu Testing"),
    f_inf("Fujitsu Infrastucture"),
    wex("Wextor"),
    kir("КИР"),
    ist("Интеллектуальные поисковые технологии и семантические технологии"),
    fs("Flatsoft"),
    bg_py("Барс Груп Python"),
    bg_js("Барс Груп JavaScript"),
    bg_net("Барс Груп .Net"),
    smart("SmartHead"),
    android("Android (Samsung Android Labs)"),
    jetbrains("JetBrains"),
    fosslabs("FossLabs"),
    finlab("Финлаб (Татфондбанк)"),
    sd("Системы электронного документооборота"),
    ios("IOS");

    @Override
    public String toString() {
        return lab;
    }

    private String lab;

    labs(String s) {
        this.lab = s;
    }
}
