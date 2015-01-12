/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import net.elbandi.pve2api.Pve2Api;
import net.elbandi.pve2api.data.VmOpenvz;
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
            //api.deleteQemu("proxmox", 100);

            System.out.println("login ok");
            JSONObject data = new JSONObject();
            boolean vrai = true;

            data.put("cpu", 200);
            data.put("diskwrite", 10);
            data.put("maxdisk",1000);
            data.put("maxmem", 5000);
            data.put("maxswap", 4000);
            data.put("mem",5120);
            data.put("netin", 10);
            data.put("netout", 10);
            data.put("nproc", 10);
            data.put("status","start");
            data.put("uptime", 10);
            data.put("cpuunits", 1000);
            data.put("digest","digest");
            data.put("diskspace", 1024);
            data.put("hostname","hostname");
            data.put("nameserver","proxmox");
            data.put("netif","");
            data.put("onboot", true);
            data.put("quotatime", 10);
            data.put("quotaugidlimit", 10);
            data.put("searchdomain", "search domain");
            data.put("diskread", 1024);

            data.put("vmid", 101);
            data.put("name","proxmox");
            data.put("storage", "local");
            data.put("ostemplate","local:vztmpl/ubuntu-12.04-standard_12.04-1_i386.tar.gz");
                //debian-7.0-standard_7.0-2_i386.tar.gz
                //ubuntu-12.04-standard_12.04-1_i386.tar.gz
            data.put("memory", 512);
            data.put("swap", 512);
            data.put("disk", 4);
            data.put("cpus", 1);
            data.put("ip_address","192.168.100.55");

            VmOpenvz vmOpenvz = new VmOpenvz(data); 
            vmOpenvz.SetConfig(data);
            api.createOpenvz(vmOpenvz);

        } catch(Exception e){
        e.printStackTrace();
        }
    }
}
