/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import javax.security.auth.login.LoginException;
import net.elbandi.pve2api.Pve2Api;
import net.elbandi.pve2api.data.VmOpenvz;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Nicolas
 */
public class Main {
    public static void main(String [ ] args) {   
        Pve2Api api = new Pve2Api("192.168.100.55", "root", "pam", "passpass");
        
        //Creation d'une VM
        try {
            api.login();
            //api.startOpenvz("proxmox", 105);
            //api.stopOpenvz("proxmox", 100, null);
            //api.shutdownOpenvz("proxmox", 100);
            //api.deleteQemu("proxmox", 100);
            
            System.out.println("login ok");
            JSONObject data = new JSONObject();

            data.put("cpu", 0);
            data.put("diskwrite", 0);
            data.put("maxdisk",0);
            data.put("maxmem", 0);
            data.put("maxswap", 0);
            data.put("mem",0);
            data.put("netin", 0);
            data.put("netout", 0);
            data.put("nproc", 0);
            data.put("status","");
            data.put("uptime", 0);
            data.put("cpuunits", 0);
            data.put("digest","");
            data.put("diskspace", 0);
            data.put("hostname","");
            data.put("nameserver","");
            data.put("netif","");
            data.put("onboot", true);
            data.put("quotatime", 0);
            data.put("quotaugidlimit", 0);
            data.put("searchdomain", "");
            data.put("diskread", 0);
            data.put("vmid", 0);
            data.put("name","");
            data.put("storage", "");
            data.put("ostemplate","");
                //debian-7.0-standard_7.0-2_i386.tar.gz
                //ubuntu-12.04-standard_12.04-1_i386.tar.gz
            data.put("memory", 0);
            data.put("ip_address","");

            
            //Date we (optionnaly) receive from the SAAS (the vmid is mandatory)
            data.put("disk", 0);
            data.put("cpus", 5);
            data.put("swap", 0);
            data.put("vmid", 102);
            
            VmOpenvz vmOpenvz = new VmOpenvz(data); 
            vmOpenvz.SetConfig(data);
            api.updateOpenvz("proxmox", vmOpenvz);
            
        } catch(Exception e){
        e.printStackTrace();
        }
    }
}
