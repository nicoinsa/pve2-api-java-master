package net.elbandi.pve2api.data;

import java.net.InetAddress;
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

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    public void setCpus(int cpus) {
        this.cpus = cpus;
    }

    public void setDisk(float disk) {
        this.disk = disk;
    }

    public void setDiskread(long diskread) {
        this.diskread = diskread;
    }

    public void setDiskwrite(long diskwrite) {
        this.diskwrite = diskwrite;
    }

    public void setMaxdisk(long maxdisk) {
        this.maxdisk = maxdisk;
    }

    public void setMaxmem(long maxmem) {
        this.maxmem = maxmem;
    }

    public void setMaxswap(long maxswap) {
        this.maxswap = maxswap;
    }

    public void setMem(long mem) {
        this.mem = mem;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNetin(long netin) {
        this.netin = netin;
    }

    public void setNetout(long netout) {
        this.netout = netout;
    }

    public void setNproc(int nproc) {
        this.nproc = nproc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSwap(long swap) {
        this.swap = swap;
    }

    public void setUptime(int uptime) {
        this.uptime = uptime;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public void setCpuunits(int cpuunits) {
        this.cpuunits = cpuunits;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setDiskspace(int diskspace) {
        this.diskspace = diskspace;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setNameserver(String nameserver) {
        this.nameserver = nameserver;
    }

    public void setNetif(String netif) {
        this.netif = netif;
    }

    public void setOnboot(boolean onboot) {
        this.onboot = onboot;
    }

    public void setOstemplate(String ostemplate) {
        this.ostemplate = ostemplate;
    }

    public void setQuotatime(int quotatime) {
        this.quotatime = quotatime;
    }

    public void setQuotaugidlimit(int quotaugidlimit) {
        this.quotaugidlimit = quotaugidlimit;
    }

    public void setSearchdomain(String searchdomain) {
        this.searchdomain = searchdomain;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVmid(int vmid) {
        this.vmid = vmid;
    }
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
                ip_address = data.getString("ip_address");
                
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
            if(this.password != null && this.password.length() > 0)
                parameters.put("password", this.password);
            if(this.ostemplate != null)
                parameters.put("ostemplate", this.ostemplate);
            if(this.memory > 0)
                parameters.put("memory", Integer.toString(this.memory));
            if(this.swap > 0)
                parameters.put("swap", Long.toString(this.swap));   
            if(this.disk > 0)
                parameters.put("disk", Float.toString(this.disk));
            if(this.cpus > 0)
                parameters.put("cpus", Integer.toString(this.cpus));
            if(this.ip_address != null)
                parameters.put("ip_address", this.ip_address);
            return parameters;
        }  
        
         public Map<String, String> getsUpdatesParams(){
            Map<String, String> parameters = new HashMap<String, String>();
            if(this.memory > 0)
                parameters.put("memory", Integer.toString(this.memory));
            if(this.swap > 0)
                parameters.put("swap", Long.toString(this.swap));   
            if(this.disk > 0)
                parameters.put("disk", Float.toString(this.disk));
            if(this.cpus > 0)
                parameters.put("cpus", Integer.toString(this.cpus));
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

        public String getIp_address() {
            return ip_address;
        }

        public String getPassword() {
            return password;
        }

        public int getVmid() {
            return vmid;
        }
}
