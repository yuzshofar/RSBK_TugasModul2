/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Khairuzzain Shofar
 */
@Stateless
@LocalBean
public class konversimatauang {
    DecimalFormat a = new DecimalFormat("0.00");
    String result;
    
    public String Rp_RM(double param) {
    return result = a.format(param*0.000281963);
    }

    public String Rp_Dollar(double param) {
    return result = a.format(param*0.0000674518);
    }

    public String Rp_Riyal(double param) {
    return result = a.format(param*0.000253246);
    }

    public String Rp_Yen(double param) {
    return result = a.format(param*0.00764198);
    }
}
