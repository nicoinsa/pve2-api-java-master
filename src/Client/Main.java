/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import net.elbandi.pve2api.Pve2Api;

/**
 *
 * @author Nicolas
 */
public class Main {
    public static void main(String [ ] args)
{
    Pve2Api api = new Pve2Api("192.168.100.55", "root", "pam", "passpass");
    
    try {
    api.login();
    api.deleteQemu("proxmox", 100);
    } catch(Exception e){
    e.printStackTrace();
    }
    
}
}
