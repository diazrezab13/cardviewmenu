package com.example.cardviewmenu.pulsafragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpendableListDataDump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Suspendisse potenti nullam ac tortor vitae purus faucibus. Vel facilisis volutpat est velit. Laoreet non curabitur gravida arcu ac tortor dignissim. Aliquam sem et tortor consequat id porta. Elit pellentesque habitant morbi tristique senectus et netus et. Non curabitur gravida arcu ac tortor dignissim convallis. Senectus et netus et malesuada fames ac turpis egestas. Nunc sed id semper risus in. Vivamus arcu felis bibendum ut tristique. Eget mi proin sed libero enim sed. Sodales ut eu sem integer vitae justo eget. Ut porttitor leo a diam. Eu nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper. Pretium lectus quam id leo in vitae turpis massa. Nec nam aliquam sem et tortor consequat id porta nibh. Magna etiam tempor orci eu lobortis elementum nibh. Vitae tempus quam pellentesque nec.");

        List<String> football = new ArrayList<String>();
        football.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Suspendisse potenti nullam ac tortor vitae purus faucibus. Vel facilisis volutpat est velit. Laoreet non curabitur gravida arcu ac tortor dignissim. Aliquam sem et tortor consequat id porta. Elit pellentesque habitant morbi tristique senectus et netus et. Non curabitur gravida arcu ac tortor dignissim convallis. Senectus et netus et malesuada fames ac turpis egestas. Nunc sed id semper risus in. Vivamus arcu felis bibendum ut tristique. Eget mi proin sed libero enim sed. Sodales ut eu sem integer vitae justo eget. Ut porttitor leo a diam. Eu nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper. Pretium lectus quam id leo in vitae turpis massa. Nec nam aliquam sem et tortor consequat id porta nibh. Magna etiam tempor orci eu lobortis elementum nibh. Vitae tempus quam pellentesque nec.");
        List<String> basketball = new ArrayList<String>();

        expandableListDetail.put("ATM BANK BRI", cricket);
        expandableListDetail.put("MOBILE BANKING BRI", football);
        return expandableListDetail;
    }
}

