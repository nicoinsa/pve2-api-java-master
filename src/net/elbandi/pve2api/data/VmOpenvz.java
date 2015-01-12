package net.elbandi.pve2api.data;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class VmOpenvz {
	private float cpu;
	private int cpus;
	private float disk;
	private long diskread;
	private long diskwrite;
	private long maxdisk;
	private long maxmem;
	private long maxswap;
	private long mem;
	private String name;
	private long netin;
	private long netout;
	private int nproc;
	private String status;
	private long swap;
	private int uptime;
        private String ip_address;

	private int cpuunits;
	private String digest;
	private int diskspace; // ! name collision
	private int memory;
	private String hostname;
	private String nameserver;
	// TODO: make it object!
	private String netif;
	private boolean onboot;
	private String ostemplate;
	private int quotatime;
	private int quotaugidlimit;
	private String searchdomain;
	private String storage;
        private String password;
        private int vmid;
        
        
	public VmOpenvz(JSONObject data) throws JSONException {
		vmid = (int) data.getInt("vmid");
                cpu = (float) data.getDouble("cpu");
		cpus = data.getInt("cpus");
		disk = (float) data.getDouble("disk");
		diskread = data.getLong("diskread");
		diskwrite = data.getLong("diskwrite");
		maxdisk = data.getLong("maxdisk");
		maxmem = data.getLong("maxmem");
		maxswap = data.getLong("maxswap");
		mem = data.getLong("mem");
		name = data.getString("name");
		netin = data.getLong("netin");
		netout = data.getLong("netout");
		nproc = data.getInt("nproc");
		status = data.getString("status");
		swap = data.getLong("swap");
		uptime = data.getInt("uptime");
	}

	public void SetConfig(JSONObject data) throws JSONException {
		cpuunits = data.optInt("cpuunits", 1000);
		digest = data.getString("digest");
		diskspace = data.getInt("disk");
		memory = data.getInt("memory");
		hostname = data.getString("hostname");
		nameserver = data.getString("nameserver");
		netif = data.getString("netif");
		onboot = data.getBoolean("onboot") == true;
		ostemplate = data.getString("ostemplate");
		quotatime = data.getInt("quotatime");
		quotaugidlimit = data.getInt("quotaugidlimit");
		searchdomain = data.getString("searchdomain");
		storage = data.getString("storage");
	}

        public Map<String, String> getCreateParams(){
    System.out.println("1");
            Map<String, String> parameters = new HashMap<String, String>();
    System.out.println("2");
            parameters.put("vmid", Integer.toString(this.vmid));
            if(this.hostname != null && this.hostname.length() > 0)
                parameters.put("hostname", this.hostname);
    System.out.println("3");
            if(this.storage != null && this.storage.length() > 0)
                parameters.put("storage", this.storage);
    System.out.println("4");
            if(this.password != null && this.password.length() > 0)
                parameters.put("password", this.password);
    System.out.println("5 template : " +this.ostemplate);
            parameters.put("ostemplate", this.ostemplate);
            if(this.memory > 0)
                parameters.put("memory", Integer.toString(this.memory));
            if(this.swap > 0)
                parameters.put("swap", Long.toString(this.swap));   
    System.out.println("6");
            if(this.disk > 0)
                parameters.put("disk", Float.toString(this.disk));
            if(this.cpus > 0)
                parameters.put("cpus", Integer.toString(this.cpus));
    System.out.println("7");
            if(this.ip_address != null && this.ip_address.length() > 0)
                parameters.put("ip_address", Integer.toString(this.cpus));
    System.out.println("8");
            return parameters;
        }  
        
	public float getCpu() {
		return cpu;
	}

	public int getCpus() {
		return cpus;
	}

	public float getDisk() {
		return disk;
	}

	public long getDiskread() {
		return diskread;
	}

	public long getDiskwrite() {
		return diskwrite;
	}

	public long getMaxdisk() {
		return maxdisk;
	}

	public long getMaxmem() {
		return maxmem;
	}

	public long getMaxswap() {
		return maxswap;
	}

	public long getMem() {
		return mem;
	}

	public String getName() {
		return name;
	}

	public long getNetin() {
		return netin;
	}

	public long getNetout() {
		return netout;
	}

	public int getNproc() {
		return nproc;
	}

	public String getStatus() {
		return status;
	}

	public long getSwap() {
		return swap;
	}

	public int getUptime() {
		return uptime;
	}

	public int getCpuunits() {
		return cpuunits;
	}

	public String getDigest() {
		return digest;
	}

	public int getDiskspace() {
		return diskspace;
	}

	public int getMemory() {
		return memory;
	}

	public String getHostname() {
		return hostname;
	}

	public String getNameserver() {
		return nameserver;
	}

	public String getNetif() {
		return netif;
	}

	public boolean isOnboot() {
		return onboot;
	}

	public String getOstemplate() {
		return ostemplate;
	}

	public int getQuotatime() {
		return quotatime;
	}

	public int getQuotaugidlimit() {
		return quotaugidlimit;
	}

	public String getSearchdomain() {
		return searchdomain;
	}

	public String getStorage() {
		return storage;
	}
}
