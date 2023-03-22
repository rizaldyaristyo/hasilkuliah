## nmap #1

`sudo nmap 10.10.11.239 -sS -p 0-3306 -sV`

```bash
PORT     STATE SERVICE VERSION
22/tcp   open  ssh     OpenSSH 8.2p1 Ubuntu 4 (Ubuntu Linux; protocol 2.0)
80/tcp   open  http    Apache httpd 2.4.41
3306/tcp open  mysql   MySQL 8.0.19-0ubuntu5
Device type: general purpose
Running: Linux 4.X|5.X
OS CPE: cpe:/o:linux:linux_kernel:4 cpe:/o:linux:linux_kernel:5
OS details: Linux 4.15 - 5.6
Network Distance: 3 hops
Service Info: Host: [PraktikumKejar.umm.ac.id](http://praktikumkejar.umm.ac.id/); OS: Linux; CPE: cpe:/o:linux:linux_kernel
```

## naabu

`naabu -host 10.10.11.239`

```bash
[INF] Running SYN scan with root privileges
[INF] Found 3 ports on host 10.10.11.239 (10.10.11.239)
10.10.11.239:22
10.10.11.239:80
10.10.11.239:3306
```

## masscan

`sudo masscan 10.10.11.239 -p0-65535 --rate 1500000`

```bash
Discovered open port 3306/tcp on 10.10.11.239
Discovered open port 22/tcp on 10.10.11.239
Discovered open port 201/tcp on 10.10.11.239
Discovered open port 80/tcp on 10.10.11.239
```

## nmap #2

`sudo nmap 10.10.11.239 -p 201 -sV`

```bash
PORT    STATE SERVICE VERSION
201/tcp open  ftp     vsftpd 3.0.3
Service Info: OS: Unix
```

# Vuln dan Mitigasi

### FTP Anonymous Access

File listing dan retrieval dapat dilakukan bahkan melalui cURL
atau login sebagai anonymous melalui port 201

- via ftp cURL
    
    `curl ftp://10.10.11.239`
    
- via FTP
    
    $> `ftp 10.10.11.239 -p 201`
    
    Name (10.10.11.239:username): `anonymous`
    
    ftp> ls
    

### Mitigasi

Disable anonymous login

file: **`/etc/vsftpd/vsftpd.conf`**

```bash
anonymous_enable=NO
```